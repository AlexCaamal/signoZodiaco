package Aplication;

import Data.Data_FormUser;
import Dominio.Dominio_FormUser;
import View.FormUser;
import Models.*;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ControllerFormUser implements ActionListener, KeyListener {

    FormUser fm;
    Dominio_FormUser dmf = new Dominio_FormUser();
    Data_FormUser data = new Data_FormUser();
    Users user = new Users();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public ControllerFormUser(FormUser fm) {
        this.fm = fm;
        this.fm.btn_registrar.addActionListener(this);
        this.fm.txt_ine.addKeyListener(this);
        this.fm.txt_tel.addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fm.btn_registrar) {
            try{
                Respuesta respuesta = registrar();
                
                if(respuesta.getEsError())
                    JOptionPane.showMessageDialog(null, respuesta.getRespuesta());                
                    
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, " * Error Interno: "+ ex.toString());
            }
        }
    }
    
        @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getSource() == fm.txt_tel){
            calcularCantidadLetra(fm.txt_tel, fm.lb_tel);
        }else if(e.getSource() == fm.txt_ine){
            calcularCantidadLetra(fm.txt_ine, fm.lb_ine);
        }
    }
    
    private void ConstruirUser(){
        user.setName(fm.txt_name.getText());
        user.setTelephone(fm.txt_tel.getText());
        user.setAddress(fm.txt_addr.getText());
        user.setEmail(fm.txt_email.getText());
        user.setIne(fm.txt_ine.getText());
        user.setGender(this.ObtenerSexo());
        user.setAge(this.ObtenerFechaCumpleaños());
    }
    
    private Boolean ObtenerSexo(){
        return fm.cbx_gen.getSelectedItem().toString().equals("Male");
    }
    
    private String ObtenerFechaCumpleaños(){
        return (fm.date_age.getCalendar() != null) ? dateFormat.format(fm.date_age.getCalendar().getTime()) : "";
    }
    
    public Respuesta registrar(){
        
        try {
            
            this.ConstruirUser();
            
            Respuesta respuesta = dmf.validarUsuario(user);

            if (respuesta.getEsError()) 
                return new Respuesta(respuesta.getRespuesta());
            
            respuesta = data.ConsultarZodiaco();
            
            if (respuesta.getEsError()) 
                return new Respuesta(respuesta.getRespuesta());
            
            respuesta = dmf.ValidarListaZodiaco(respuesta.getSignos());
            
            if (respuesta.getEsError()) 
                return new Respuesta(respuesta.getRespuesta());
            
            respuesta = dmf.ColocarSignoZodiaco(respuesta.getSignos(), user);
            
            if (respuesta.getEsError()) 
                return new Respuesta(respuesta.getRespuesta());
            
            respuesta = data.RegistrarUsuario(user);

            if (respuesta.getEsError()) 
                return new Respuesta(respuesta.getRespuesta());
            
            JOptionPane.showMessageDialog(null, "Se Registro Correctamente.!!!!!"); 
            limpiar();
            
        } catch (Exception e) {
            return new Respuesta("Error: "+e.getMessage());
        }
        
        return new Respuesta();
    }
    
    private void limpiar(){
        fm.txt_name.setText("");
        fm.txt_tel.setText("");
        fm.txt_addr.setText("");
        fm.txt_email.setText("");
        fm.txt_ine.setText("");
        fm.date_age.setCalendar(null);
    }
    
    private void calcularCantidadLetra(JTextField text, JLabel lb){
        String numero = text.getText();
        int cantidad = numero.length();
        lb.setText(""+cantidad);        
    }



}
