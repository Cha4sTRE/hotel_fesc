package cj.models;

public class Habitaciones {

    private int id_habitacion;
    private int numeroHabitacion;
    private String tipo;
    private String estado;
    private String  descripcion;
    private int capacidadMax;

    public Habitaciones() {

    }

    public Habitaciones(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public Habitaciones(int numeroHabitacion, String tipo, String estado, String descripcion, int capacidadMax) {
        this.numeroHabitacion = numeroHabitacion;
        this.tipo = tipo;
        this.estado = estado;
        this.descripcion = descripcion;
        this.capacidadMax = capacidadMax;
    }

    public Habitaciones(int id_habitacion, int numeroHabitacion, String tipo, String estado, String descripcion, int capacidadMax) {
        this.id_habitacion = id_habitacion;
        this.numeroHabitacion = numeroHabitacion;
        this.tipo = tipo;
        this.estado = estado;
        this.descripcion = descripcion;
        this.capacidadMax = capacidadMax;
    }

    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCapacidadMax() {
        return capacidadMax;
    }

    public void setCapacidadMax(int capacidadMax) {
        this.capacidadMax = capacidadMax;
    }
}
