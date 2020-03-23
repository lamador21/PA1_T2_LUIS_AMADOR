
package Objetos;

/**
 *
 * @author ROOT
 */
public class Vehiculos {
    private String placa;
    private String modelo;
    private String marca;
    private int anio;
    private String motor;
    private double precio;
    private String nombre;
    private String descripcion;
    private String imagen;
     public Vehiculos() {
    }
    public Vehiculos(String placa, String modelo, String marca, int anio, String motor, double precio, String nombre, String descripcion, String imagen) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.anio = anio;
        this.motor = motor;
        this.precio = precio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "vehiculos{" + "placa=" + placa + ", modelo=" + modelo + ", marca=" + marca + ", anio=" + anio + ", motor=" + motor + ", precio=" + precio + ", nombre=" + nombre + ", descripcion=" + descripcion + ", imagen=" + imagen + '}';
    }
    
    
    
}
