
package Models;

import java.util.List;

public class Respuesta {
    private String Respuesta;
    private Boolean EsError;
    private Boolean EsExito;
    private BusquedaUsuario contenido;
    private List<Signo> signos;

    public Respuesta() {
        this.Respuesta = "";
        this.EsError = false;
        this.EsExito = true;
        this.contenido = null;
    }

    public Respuesta(String Respuesta) {
        this.Respuesta = Respuesta;
        this.EsError = true;
        this.EsExito = false;
        this.contenido = null;
    }

    public Respuesta(BusquedaUsuario contenido) {
        this.Respuesta = "";
        this.EsError = false;
        this.EsExito = true;
        this.contenido = contenido;
    }
    
    public Respuesta(List<Signo> signos) {
        this.Respuesta = "";
        this.EsError = false;
        this.EsExito = true;
        this.contenido = null;
        this.signos = signos;
    }

    public List<Signo> getSignos() {
        return signos;
    }

    public void setSignos(List<Signo> signos) {
        this.signos = signos;
    }

    public String getRespuesta() {
        return Respuesta;
    }

    public void setRespuesta(String Respuesta) {
        this.Respuesta = Respuesta;
    }

    public Boolean getEsError() {
        return EsError;
    }

    public void setEsError(Boolean EsError) {
        this.EsError = EsError;
    }

    public Boolean getEsExito() {
        return EsExito;
    }

    public void setEsExito(Boolean EsExito) {
        this.EsExito = EsExito;
    }

    public BusquedaUsuario getContenido() {
        return contenido;
    }

    public void setContenido(BusquedaUsuario contenido) {
        this.contenido = contenido;
    }    
}
