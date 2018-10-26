package proyecto.nosvamosv1.Models;

public class Viajes {

    private int idViajes;
    private Usuario usuario;
    private Auto auto;
    private String nroAsientosViaje;
    private String tiempo;
    private String hora;
    private String origen;
    private String precio;
    private String destino;
    private String fecha;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdViajes() {
        return idViajes;
    }

    public void setIdViajes(int idViajes) {
        this.idViajes = idViajes;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public String getNroAsientosViaje() {
        return nroAsientosViaje;
    }

    public void setNroAsientosViaje(String nroAsientosViaje) {
        this.nroAsientosViaje = nroAsientosViaje;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}
