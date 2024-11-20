package services;

import models.Productos;

import java.util.List;

public interface ProductoService {
    //Implementamos un método para listar los productos
    List<Productos> listar();
}
