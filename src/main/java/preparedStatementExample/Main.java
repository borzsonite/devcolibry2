package preparedStatementExample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Calendar;

public class Main {
    private final static String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final static String USER = "postgres";
    private final static String PASSWORD = "root";

    private final static String INSERT_NEW = "INSERT INTO dish VALUES(?,?,?,?,?,?,?)";
    private final static String GET_ALL = "SELECT * from dish";
    private final static String DELETE = "DELETE * from dish WHERE id=?";


    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            /**
            preparedStatement = connection.prepareStatement(INSERT_NEW);
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "title");
            preparedStatement.setString(3, "description");
            preparedStatement.setDouble(4, 5.0);
            preparedStatement.setBoolean(5, true);
            preparedStatement.setDate(6, new Date(Calendar.getInstance().getTimeInMillis()));
            preparedStatement.setBlob(7, new FileInputStream("smile.png"));
            preparedStatement.execute();
            */

        preparedStatement = connection.prepareStatement(DELETE);
        preparedStatement.setInt(1,1);
        preparedStatement.executeUpdate();


            preparedStatement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                String title = resultSet.getString(2);
                String description = resultSet.getString(3);
                Double rating = resultSet.getDouble(4);
                Boolean published = resultSet.getBoolean(5);
                Date date = resultSet.getDate(6);
                System.out.println(id + ":" + title + ":" + description + ":" + rating+ ":" + published);
            }




        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }
}
