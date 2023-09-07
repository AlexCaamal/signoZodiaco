package Data;

import Models.Respuesta;
import Models.Signo;
import Models.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Data_FormUser {

    public Respuesta RegistrarUsuario(Users user) {
        try {
            Connection cn = Conexion.ConnectionDB.GetConnection();
            String sql = "INSERT INTO users (Name, Age, Address, Telephone,Email,Ine, Gender, IdZodiaco) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setString(1, user.getName());
            ps.setString(2, user.getAge());
            ps.setString(3, user.getAddress());
            ps.setString(4, user.getTelephone());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getIne());
            ps.setBoolean(7, user.getGender());
            ps.setInt(8, user.getSigno());

            ps.execute();
            ps.close();
        } catch (Exception e) {
            return new Respuesta("Error: " + e.getMessage());
        }

        return new Respuesta();
    }
    
    public Respuesta ConsultarZodiaco(){
        List<Signo> signos = new ArrayList<Signo>();
        try {
            
            Connection cn = Conexion.ConnectionDB.GetConnection();
            ResultSet rs; 
            String sql = "SELECT*FROM signo";
            PreparedStatement ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Signo signo = new Signo();
                
                signo.setId(rs.getInt("Id"));
                signo.setDescription(rs.getString("Description"));
                signo.setDateStart(convertirFecha(rs.getString("DateStart")));
                signo.setDateEnd(convertirFecha(rs.getString("DateEnd")));
                
                signos.add(signo);
            }rs.close();ps.close();
            
        } catch (Exception e) {
            return new Respuesta("Error: "+e.getMessage());
        }
        
        return new Respuesta(signos);
    }
    
    private Date convertirFecha(String fecha){
        Date fechaConvertida = new Date();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String fechaNueva = fecha + "/2023";
            fechaConvertida = sdf.parse(fechaNueva);
        } catch (Exception e) {
        }
        return fechaConvertida;
    }

}
