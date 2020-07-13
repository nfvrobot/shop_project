package by.shopproject.dao;

import by.shopproject.connection.ConnectionPool;
import by.shopproject.entity.Customer;
import by.shopproject.entity.Guitar;
import by.shopproject.entity.OrderInfo;
import by.shopproject.entity.Status;
import by.shopproject.exception.DaoException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderInfoDao {

    private static final OrderInfoDao INSTANCE = new OrderInfoDao();

    private static final String SAVE = "INSERT INTO shop_storage.orderinfo (customer_id, guitar_id, count, date_placed, status)" +
            " VALUES (?, ?, ?, ?, ?)";
    private static final String GET_ALL = "SELECT id, customer_id, guitar_id, count, date_placed, status FROM shop_storage.orderinfo";

    public OrderInfo save(OrderInfo orderInfo) {
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE, RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1,
                    Optional.ofNullable(orderInfo.getCustomer())
                            .map(Customer::getId)
                            .orElse(null));
            preparedStatement.setInt(2,
                    Optional.ofNullable(orderInfo.getGuitar())
                            .map(Guitar::getId)
                            .orElse(null));
            preparedStatement.setInt(3, orderInfo.getCount());
            preparedStatement.setDate(4, orderInfo.getDatePlaced());
            preparedStatement.setString(5,orderInfo.getStatus().name());
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if(generatedKeys.next()) {
                orderInfo.setId(generatedKeys.getInt("id"));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return orderInfo;
    }

    public List<OrderInfo> getAll() {
        List<OrderInfo> orderInfoList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_ALL);
            while (resultSet.next()) {
                OrderInfo orderInfo = getOrderInfoFromResultSet(resultSet);
                orderInfoList.add(orderInfo);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return orderInfoList;
    }

    private OrderInfo getOrderInfoFromResultSet(ResultSet resultSet) throws SQLException {
        return OrderInfo.builder()
                .id(resultSet.getInt("id"))
                .customer(Customer.builder()
                        .id(resultSet.getInt("id"))
                        .build())
                .guitar(Guitar.builder()
                        .id(resultSet.getInt("id"))
                        .build())
                .count(resultSet.getInt("count"))
                .datePlaced(resultSet.getDate("datePlaced"))
                .status(Status.valueOf(resultSet.getString("status")))
                .build();
    }

    public static OrderInfoDao getInstance() {
        return INSTANCE;
    }
}
