package database.mysql;

import model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends AbstractDAO {

    public UserDAO(DBAccess dbAccess){super(dbAccess);}

    /**
     * We gaan er van uit dat:
     * - bij het aanroepen van deze methode:
     * -- er een open database connectie open is
     * - bij het eindigen van deze methode:
     * -- de databaseconnectie open is
     */
    public void storeNewUser(String name, String password, String role ){
        String sql = "INSERT INTO user ( username, password, role ) VALUES (?,?,?);";

        try{
            PreparedStatement preparedStatement = dBaccess.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, role);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public User getUserByUsername(String usernameInput){
        String sql = "SELECT * FROM user WHERE username = ?";
        User user = null;

        try{
            PreparedStatement preparedStatement = getStatement(sql);
            preparedStatement.setString(1, usernameInput);

            ResultSet resultset = preparedStatement.executeQuery();
            while(resultset.next()){

                int userId = resultset.getInt(1);
                String username = resultset.getString(2) ;
                String password = resultset.getString(3);
                String role = resultset.getString(4);

                // afhankelijk van de rol, creëer en return het juiste object
                switch (role){
                    case "Student":
                        user = new Student(userId, username, password, role);
                        break;
                    case "Docent":
                        user = new Teacher(userId, username, password, role);
                        break;
                    case "Coordinator":
                        user = new Coordinator(userId, username, password, role);
                        break;
                    case "Administrator":
                        user = new Administrator(userId, username, password, role);
                        break;
                    case "Technisch beheerder":
                        user = new TechnicalAdministrator(userId, username, password, role);
                        break;
                    default:
                        user = null;
                        break;
                }
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return user;
    }
}
