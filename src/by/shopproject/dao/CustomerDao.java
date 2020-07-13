package by.shopproject.dao;

import by.shopproject.connection.ConnectionPool;
import by.shopproject.dto.CustomerLoginDto;
import by.shopproject.entity.Customer;
import by.shopproject.exception.DaoException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerDao {

    private static final CustomerDao INSTANCE = new CustomerDao();

    private static final String SAVE = "INSERT INTO shop_storage.customer (firstname, lastname, email, password, phone, address) " +
            "VALUES (?, ?, ?, ?, ?, ?)";
    private static final String GET_ALL = "SELECT id, firstname, lastname, email, phone, address " +
            "FROM shop_storage.customer";
    private static final String GET_BY_ID = GET_ALL + " WHERE id = ?";
    private static final String GET_ORDER_INFO = "SELECT oI.id as order_id, oI.customer_id, g.name, oL.count, oI.data_placed " +
            "FROM shop_storage.orderinfo oI " +
            "LEFT JOIN shop_storage.orderLine oL ON oI.id = oL.orderInfo_id " +
            "LEFT JOIN shop_storage.guitar g on oL.guitar_id = g.id " +
            "WHERE oI.customer_id = ?";
    private static final String GET_ID_IF_EXIST = "SELECT id FROM shop_storage.customer WHERE email = ? AND password = ?";

    public Customer save(Customer customer) {
        try (Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SAVE, RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2,customer.getLastName());
            preparedStatement.setString(3, customer.getEmail());
            preparedStatement.setString(4, customer.getPassword());
            preparedStatement.setString(5, customer.getPhone());
            preparedStatement.setString(6, customer.getAddress());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                customer.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return customer;
    }

    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_ALL);
            while (resultSet.next()) {
                Customer customer = Customer.builder()
                        .id(resultSet.getInt("id"))
                        .firstName(resultSet.getString("firstName"))
                        .lastName(resultSet.getString("lastName"))
                        .email(resultSet.getString("email"))
                        .phone(resultSet.getString("phone"))
                        .address(resultSet.getString("address"))
                        .build();
                customers.add(customer);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return customers;
    }

    public Optional<Customer> getById(Integer id) {
        Optional<Customer> customer = Optional.empty();
        try (Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                customer = Optional.of(getCustomerFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return customer;
    }

    public Optional<Integer> getIdIfExist(CustomerLoginDto customerLoginDto) {
        Optional<Integer> id = Optional.empty();
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ID_IF_EXIST)) {
            preparedStatement.setString(1, customerLoginDto.getEmail());
            preparedStatement.setString(2, customerLoginDto.getPassword());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                id = Optional.of(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return id;
    }

    private Customer getCustomerFromResultSet (ResultSet resultSet) throws SQLException {
        return Customer.builder()
                .id(resultSet.getInt("id"))
                .firstName(resultSet.getString("firstName"))
                .lastName(resultSet.getString("lastName"))
                .email(resultSet.getString("email"))
                .phone(resultSet.getString("phone"))
                .address(resultSet.getString("address"))
                .build();
    }

    public static CustomerDao getInstance() {
        return INSTANCE;
    }
}
