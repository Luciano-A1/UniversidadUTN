package Entidades;

public class Materia {

    private int idMateria;
    private String nombre;
    private int año;
    private boolean anual;
    private boolean estado;

    public Materia(int idMateria, String nombre, int año, boolean anual, boolean estado) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.año = año;
        this.anual = anual;
        this.estado = estado;
    }

    public Materia(String nombre, int año, boolean anual, boolean estado) {
        this.nombre = nombre;
        this.año = año;
        this.anual = anual;
        this.estado = estado;
    }

    public Materia() {
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public boolean isAnual() {
        return anual;
    }

    public void setAnual(boolean anual) {
        this.anual = anual;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Materia{" + "idMateria=" + idMateria + ", nombre=" + nombre + ", a\u00f1o=" + año + ", anual=" + anual + ", estado=" + estado + '}';
    }
        
}
