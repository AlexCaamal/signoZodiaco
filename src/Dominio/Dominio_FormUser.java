package Dominio;

import Models.Respuesta;
import Models.Signo;
import Models.Users;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dominio_FormUser {

    public Respuesta validarUsuario(Users user) {

        try {
            
            if (user.getName().isEmpty() || user.getName() == null) 
                return new Respuesta("El Nombre es Obligatorio");
            
             if (user.getTelephone().isEmpty() || user.getTelephone() == null) 
                return new Respuesta("El Telefono es Obligatorio");
            
            if (!user.getTelephone().matches("\\d+"))
                return new Respuesta("El Teléfono debe contener solo números.");
        
            if (user.getTelephone().length() > 10 || user.getTelephone().length() < 10)
                return new Respuesta("El Teléfono debe contener 10 digitos");
            
            if (user.getEmail().isEmpty() || user.getEmail() == null) 
                return new Respuesta("El Correo es Obligatorio");
            
            if (!validarCorreoElectronico(user.getEmail())) 
                return new Respuesta("El Correo no es válido");

            if (user.getAddress().isEmpty() || user.getAddress() == null) 
                return new Respuesta("La Dirección es Obligatorio");
            
            if (user.getAge().isEmpty() || user.getAge() == null)
                return new Respuesta("La fecha de Nacimiento es Obligatorio");
           
            if (user.getIne().isEmpty() || user.getIne() == null) 
                return new Respuesta("La Ine es Obligatorio");
            
            if (!user.getIne().matches("\\d+"))
                return new Respuesta("La Ine debe contener solo números.");
            
            if (user.getIne().length() > 13 || user.getIne().length() < 13)
                return new Respuesta("La Ine debe contener 13 digitos");          
            
        } catch (Exception e) {
            return new Respuesta("Error: "+e.getMessage());
        }

        return new Respuesta();
    }
    
    public Respuesta ValidarListaZodiaco(List<Signo> signos){
        
        if(signos.isEmpty() || signos.size() == 0)
            new Respuesta("Ocurrio un fallo en la consulta de los Zodiacos");
        
        return new Respuesta(signos);
    }
    
    public Respuesta ColocarSignoZodiaco(List<Signo> signos, Users user){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaNacimiento = user.getAge();
        
        try {
           
        Date fechaConvertida = sdf.parse(fechaNacimiento);

        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaConvertida);
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        int mes = cal.get(Calendar.MONTH) + 1; // Sumamos 1 porque enero es 0 en Calendar

        for (Signo signo : signos) {
            
            if (mes == getMonthFromDate(signo.getDateStart()) && dia >= getDayFromDate(signo.getDateStart())
                || mes == getMonthFromDate(signo.getDateEnd()) && dia <= getDayFromDate(signo.getDateEnd())) {
                user.setSigno(signo.getId());
                break;
            }
        }
            
        } catch (Exception e) {
           return new Respuesta("Error: "+e.getMessage());
        }
        
        return new Respuesta();
    }

    private int getDayFromDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    private int getMonthFromDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH) + 1;
    }
    
    public boolean validarCorreoElectronico(String correo) {

        String regex = "^[A-Za-z0-9+_.-]+@(.+)$"; // Expresión regular para validar correos electrónicos
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);

        return matcher.matches();
    }
}
