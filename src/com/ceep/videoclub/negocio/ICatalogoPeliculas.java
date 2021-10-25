package com.ceep.videoclub.negocio;

public interface ICatalogoPeliculas {
    
    // Agregar una pelicula
    void agregarPelicula(String nombrePelicula, String nombreCatalogo);
    
    //Mostrar todas las peliculas del catalogo
    void listarPelicula(String nombreCatalogo);
    
    //Busca la pelicula "Buscar" en nuestro archivo
    void buscarPelicula(String nombreCatalogo, String buscar);
    
    //Nos inicia nuestro catalogo
    void iniciarCatalogo(String nombreCatalogo);
}
