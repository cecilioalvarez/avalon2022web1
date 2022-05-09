package es.avalon.dominio;

public class Persona {

    private String dni;
    private String nombre;
    private int edad;
    
    public String getDni() {
        return dni;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public Persona(String dni, String nombre, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
    }

    
    
}
