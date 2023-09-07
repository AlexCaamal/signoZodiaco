
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectionDB {
    
     public static Connection con;
    // Declaramos los datos de conexion a la bd
    private static final String driver="com.mysql.jdbc.Driver";
    private static final String user="root";
    private static final String pass="";
    private static final String url="jdbc:mysql://localhost:3305/signozodiacal?characterEncoding=utf8";
    
      public static Connection GetConnection() {
        con = null;
        try {
            con = (Connection) DriverManager.getConnection(url, user, pass);
            return con;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: No se conecto a la Base de datos. Verifique...");
        }
        return con;
    }
}
