import java.sql.*;

public class DBTest {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/test1";
        Connection myConn = DriverManager.getConnection(url, "root", "");
        try {
            String query1 = "INSERT INTO GameTable VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preStat = myConn.prepareStatement(query1); //PreparedStatement is a subclass of Statement that supports data substitution and can execute a statement multiple times
            preStat.setInt(1, 2); //Using the setter methods to substitute values corresponding to the ?s
            preStat.setString(2, "GTA Trilogy");
            preStat.setString(3, "sdfsgsvdvsdvsvsv");
            preStat.setFloat(4, 8.8f);
            preStat.setString(5, "asfafssffsf");
            preStat.setString(6, "dhxdvsczcz");
            preStat.executeUpdate(); //Executing the statement using executeUpdate()
        }catch (SQLIntegrityConstraintViolationException e){
            System.out.println("Primary Key was repeated");
        }

        String query2 = "SELECT * FROM GameTable;";
        Statement statement= myConn.createStatement();
        ResultSet result = statement.executeQuery(query2); //executeQuery(statement) is used to run DQL command (i.e. SELECT) and returns a ResultSet object

        while(result.next()) { //Now iterating over the ResultSet object to print the results of the query. next() returns false after all rows exhausted, else returns true
            int id = result.getInt("id"); //Getters extract corresponding data from column names
            String name = result.getString("game_name");
            float rating = result.getFloat("rating");
            System.out.println("ID - " + id);
            System.out.println("Name - " + name);
            System.out.println("Rating - " + rating);
        }
    }
}
