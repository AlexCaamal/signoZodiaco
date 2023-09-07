
package Aplication;

import Data.Data_SearchUser;
import Dominio.Dominio_FormUser;
import Dominio.Dominio_SearchUser;
import Models.BusquedaUsuario;
import Models.Respuesta;
import View.SearchUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

public class ControllerSearchUser implements ActionListener{
    
    SearchUser sh;
    Data_SearchUser data = new Data_SearchUser();
    Dominio_SearchUser dominio = new Dominio_SearchUser();

    public ControllerSearchUser(SearchUser sh) {
        this.sh = sh;
        this.sh.btn_buscarUser.addActionListener(this);
    }
    
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sh.btn_buscarUser) {
            try{
                Respuesta respuesta = buscarUsuario();
                
                if(respuesta.getEsError())
                    JOptionPane.showMessageDialog(null, respuesta.getRespuesta());                
                    
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, " * Error Interno: "+ ex.toString());
            }
        }
    }
    
    private Respuesta buscarUsuario(){
        try {
            String nombre = (sh.txt_buscarUser.getText() != null) ? sh.txt_buscarUser.getText() : "";
            
            Respuesta respuesta = dominio.nombreVacio(nombre);

            if (respuesta.getEsError())
                return new Respuesta(respuesta.getRespuesta());
            
            respuesta = data.ObtenerUsuario(nombre);

            if (respuesta.getEsError())
                return new Respuesta(respuesta.getRespuesta());
            
            respuesta = dominio.ValidarUsuario(respuesta.getContenido());

            if (respuesta.getEsError())
                return new Respuesta(respuesta.getRespuesta());
            
            respuesta = llenarCampos(respuesta.getContenido());
            
            if (respuesta.getEsError())
                return new Respuesta(respuesta.getRespuesta());
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " * Error Interno: "+ e.toString());
        }
        
      return new Respuesta();
    }
    
    private Respuesta llenarCampos(BusquedaUsuario user){
        try {
            
            sh.lb_zodiaco.setText(user.getDescriptionZodiaco());
            sh.lb_edad.setText(this.calcularEdad(user.getAge()));
            
        } catch (Exception e) {
            return new Respuesta("Error Interno: "+e.getMessage());
        }
        
        return new Respuesta();
    }
    
    private String calcularEdad(String Age) {
        int años = 0;
        try {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaNacimiento = LocalDate.parse(Age, formatter);
            LocalDate fechaActual = LocalDate.now();

            Period periodo = Period.between(fechaNacimiento, fechaActual);

            años = periodo.getYears();

            return años + " años. ";

        } catch (Exception e) {

        }

        return String.valueOf(años) + " años. " ;
    }
}
