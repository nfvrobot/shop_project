package by.shopproject.dao;

import by.shopproject.connection.ConnectionPool;
import by.shopproject.dto.GuitarBuyDto;
import by.shopproject.entity.Color;
import by.shopproject.entity.Fabric;
import by.shopproject.entity.Guitar;
import by.shopproject.exception.DaoException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GuitarDao {

    private static final GuitarDao INSTANCE = new GuitarDao();

    private static final String SAVE = "INSERT INTO shop_storage.guitar (fabric_id, name, strings, color, count) VALUES (?, ?, ?, ?, ?)";
    private static final String GET_ALL = "SELECT g.id as g_id, " +
            "f.id as f_id, " +
            "f.name as f_name, " +
            "f.country as f_country, " +
            "g.name as g_name, " +
            "g.strings as g_strings, " +
            "g.color as g_color, " +
            "g.count as g_count " +
            "FROM shop_storage.guitar g " +
            "JOIN shop_storage.fabric f " +
            "ON g.fabric_id = f.id";
    private static final String GET_BY_ID = GET_ALL + " WHERE g.id = ?";
    private static final String UPDATE_COUNT_AFTER_SELLING_ONE = "UPDATE shop_storage.guitar SET count = count - 1 WHERE id = ?";
    private static final String BUY_GUITAR = "INSERT INTO shop_storage.orderinfo (customer_id, guitar_id, status) VALUES (?, ?, ?)";

    public Guitar save(Guitar guitar) {
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE, RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1,
                    Optional.ofNullable(guitar.getFabric())
                            .map(Fabric::getId)
                            .orElse(null));
            preparedStatement.setString(2, guitar.getName());
            preparedStatement.setShort(3, guitar.getStrings());
            preparedStatement.setString(4, guitar.getColor().name());
            preparedStatement.setInt(5, guitar.getCount());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                guitar.setId(generatedKeys.getInt("id"));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return guitar;
    }

    public List<Guitar> getAll() {
        List<Guitar> guitars = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_ALL);
            while (resultSet.next()) {
                Guitar guitar = getGuitarFromResultSet(resultSet);
                guitars.add(guitar);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return guitars;
    }

    public Optional<Guitar> getById(Integer guitarId) {
        Optional<Guitar> guitar = Optional.empty();
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, guitarId);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                guitar = Optional.of(getGuitarFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return guitar;
    }

    private Guitar getGuitarFromResultSet(ResultSet resultSet) throws SQLException {
        return Guitar.builder()
                .id(resultSet.getInt("g_id"))
                .fabric(Fabric.builder()
                        .id(resultSet.getInt("f_id"))
                        .name(resultSet.getString("f_name"))
                        .country(resultSet.getString("f_country"))
                        .build())
                .name(resultSet.getString("g_name"))
                .strings(resultSet.getShort("g_strings"))
                .color(Color.valueOf(resultSet.getString("g_color")))
                .count(resultSet.getInt("g_count"))
                .build();
    }

    public static GuitarDao getInstance() {
        return INSTANCE;
    }
}
