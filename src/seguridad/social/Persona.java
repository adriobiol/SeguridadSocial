package seguridad.social;

public class Persona {
    public Persona(String DNI, String numSeguridadSocial, String nombre, String apellidos, int edad, double salario) {
        this.DNI = DNI;
        NumSeguridadSocial = numSeguridadSocial;
        Nombre = nombre;
        Apellidos = apellidos;
        Edad = edad;
        this.salario = salario;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNumSeguridadSocial() {
        return NumSeguridadSocial;
    }

    public void setNumSeguridadSocial(String numSeguridadSocial) {
        NumSeguridadSocial = numSeguridadSocial;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    private String DNI;
    private String NumSeguridadSocial;
    private String Nombre;
    private String Apellidos;
    private int Edad;
    private double salario;

    @Override
    public String toString() {
        return "Persona{" +
                "DNI= '" + DNI + '\'' +
                ", NumSeguridadSocial= '" + NumSeguridadSocial + '\'' +
                ", Nombre= '" + Nombre + '\'' +
                ", Apellidos= '" + Apellidos + '\'' +
                ", Edad= " + Edad +
                ", Salario= " + salario +
                '}';
    }
}