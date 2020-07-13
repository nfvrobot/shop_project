package by.shopproject.dao;

import by.shopproject.connection.ConnectionPool;
import by.shopproject.entity.Fabric;
import by.shopproject.exception.DaoException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FabricDao {

    private static final FabricDao INSTANCE = new FabricDao();

    private static final String SAVE = "INSERT INTO shop_storage.fabric (name, country) VALUES (?, ?)";
    private static final String GET_ALL = "SELECT id, name, country FROM shop_storage.fabric";

    public Fabric save(Fabric fabric) {
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE, RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, fabric.getName());
            preparedStatement.setString(2, fabric.getCountry());
            preparedStatement.executeUpdate();

            ResultSet keys = preparedStatement.getGeneratedKeys();
            if (keys.next()) {
                fabric.setId(keys.getInt(1));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return fabric;
    }

    public List<Fabric> getAll() {
        List<Fabric> fabrics = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_ALL);
            while (resultSet.next()) {
                Fabric fabric = Fabric.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .country(resultSet.getString("country"))
                        .build();
                fabrics.add(fabric);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return fabrics;
    }

    public static FabricDao getInstance() {
        return INSTANCE;
    }
}
