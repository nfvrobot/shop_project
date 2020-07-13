package by.shopproject.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PropertyManager {

    private static final Properties PROPERTIES = new Properties();

    static {
        loadApplicationProperties();
    }

    private static void loadApplicationProperties() {
        try {
            PROPERTIES.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }

}
