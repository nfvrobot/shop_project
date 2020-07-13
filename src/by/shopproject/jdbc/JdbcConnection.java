package by.shopproject.jdbc;

import java.util.Locale;

public class JdbcConnection {

    public static void main(String[] args) {
        Locale locale = new Locale("ru", "RU");
        System.out.println(locale);
    }

    private static void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
