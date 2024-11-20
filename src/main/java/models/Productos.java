package models;

public class Productos {

    //declaramos las variables para crear el objeto producto
    private Long idProducto;
    private String nombreProducto;
    private String categoria;
    private double precioProducto;
    //Implementamso el contructor vacio

    public Productos() {
    }

    public Productos(Long idProducto, String nombreProducto, String categoria, double precioProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.categoria = categoria;
        this.precioProducto = precioProducto;
    }

    //Métodos Get y set

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }
}


