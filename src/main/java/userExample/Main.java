package userExample;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        DBWorker dbWorker = new DBWorker();

        String query = "SELECT * from users";

        try {
            Statement statement = dbWorker.getConnection().createStatement();
           // statement.execute("INSERT INTO users (username, password) VALUES ('testName', 'testPass')");
            ResultSet resultSet =  statement.executeQuery(query);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("username"));
                user.setPass(resultSet.getString("password"));
                System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
