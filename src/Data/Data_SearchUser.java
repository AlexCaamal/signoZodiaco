
package Data;

import Models.BusquedaUsuario;
import Models.Respuesta;
import Models.Signo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Data_SearchUser {
    
    public Respuesta ObtenerUsuario(String nombre){
        
        BusquedaUsuario bUser = new BusquedaUsuario();
        
        try {
            
            Connection cn = Conexion.ConnectionDB.GetConnection();
            ResultSet rs;
            String sql = "SELECT us.Id, us.Age, sg.Description FROM users us INNER JOIN signo sg on sg.Id = us.IdZodiaco WHERE us.Name = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();

            if (rs.next()) {

                bUser.setId(rs.getInt("Id"));
                bUser.setDescriptionZodiaco(rs.getString("Description"));
                bUser.setAge(rs.getString("Age"));
            }
            rs.close();
            ps.close();
            
        } catch (Exception e) {
            return new Respuesta("Error: "+e.getMessage());
        }
        
        return new Respuesta(bUser);
    }
    
}
