package proyecto.nosvamosv1.Models;

public class Auto {
    private int idAuto;
    private String matricula;
    private String marca;
    private String nroPuesto;
    private String modelo;

    public int getIdAuto() {
        return idAuto;
    }

    public void setIdAuto(int idAuto) {
        this.idAuto = idAuto;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNroPuesto() {
        return nroPuesto;
    }

    public void setNroPuesto(String nroPuesto) {
        this.nroPuesto = nroPuesto;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
