
package Dominio;

import Models.BusquedaUsuario;
import Models.Respuesta;

public class Dominio_SearchUser {
    
    public Respuesta ValidarUsuario (BusquedaUsuario usuario){
        
        if(usuario == null || usuario.getId() == 0)
            return new Respuesta("No se encontro coincidencia con el Usuario");
        
        if(usuario.getDescriptionZodiaco() == null || usuario.getDescriptionZodiaco().equals(""))
            return new Respuesta("Ocurrio un error con la Vinculación del Usuario y el Signo Zodiaco.");
        
        return new Respuesta(usuario);
    }
    
    public Respuesta nombreVacio(String nombre){
        
        if(nombre.equals("") || nombre == null)
            return new Respuesta("Digite el Nombre del Usuario.");
        
        return new Respuesta();
    }
    
}
