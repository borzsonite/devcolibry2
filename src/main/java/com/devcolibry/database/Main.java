package com.devcolibry.database;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver"); // загружаем драйвер
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root"); // Создаем коннектион
             Statement statement = connection.createStatement()// создаем стейтмент с помощью которого можно делать запросы к БД
        ) {
           // statement.execute("INSERT INTO animals (anim_name, anim_desc) VALUES ('name', 'desc')");

           // int result = statement.executeUpdate("UPDATE animals SET anim_name='new Name' WHERE id = '1'");
           // System.out.println(result);

            ResultSet resultSet = statement.executeQuery("SELECT * from animals");
            System.out.println(resultSet.next());
            System.out.println(resultSet);

//            statement.addBatch("INSERT INTO animals (anim_name, anim_desc) VALUES ('batch1', 'desc')");
//            statement.addBatch("INSERT INTO animals (anim_name, anim_desc) VALUES ('batch2', 'desc')");
//            statement.addBatch("INSERT INTO animals (anim_name, anim_desc) VALUES ('batch3', 'desc')");
//            statement.executeBatch();
//            statement.clearBatch();

            System.out.println(connection.isClosed());
            statement.getConnection();
            statement.close();
            System.out.println(statement.isClosed());
            statement.getConnection();
            System.out.println(statement.isClosed());



        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
