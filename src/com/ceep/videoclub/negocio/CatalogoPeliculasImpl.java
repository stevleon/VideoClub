
package com.ceep.videoclub.negocio;

import com.ceep.videoclub.datos.*;
import com.ceep.videoclub.dominio.Pelicula;
import com.ceep.videoclub.excepciones.EscrituraDatosEx;
import com.ceep.videoclub.excepciones.LecturaDatosEx;
import java.util.*;



public class CatalogoPeliculasImpl implements ICatalogoPeliculas{
    
    private final IAccesoDatos datos;

    public CatalogoPeliculasImpl() {
        this.datos =  new AccesoDatosImpl();
    }
    
    @Override
    public void agregarPelicula(String nombrePelicula, String nombreCatalogo) {
        try{
            if (this.datos.existe(nombreCatalogo)){
            this.datos.escribir(new Pelicula(nombrePelicula), nombreCatalogo, true);
            }else{
                System.out.println("Catalogo no inicializado");
            }
        } catch (EscrituraDatosEx ex){
            System.out.println("Error al escribir en el catalogo");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPelicula(String nombreCatalogo) {
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            peliculas = this.datos.listar(nombreCatalogo);
             peliculas.forEach(pelicula -> {
            System.out.println(pelicula.getNombre());
         });
        } catch (LecturaDatosEx ex) {
           System.out.println("Error leyendo el catalogo");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPelicula(String nombreCatalogo, String buscar) {
        try {
            System.out.println(this.datos.buscar(nombreCatalogo, buscar));
        } catch (LecturaDatosEx ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void iniciarCatalogo(String nombreCatalogo) {
        try{
       if (this.datos.existe(nombreCatalogo)){
           this.datos.borrar(nombreCatalogo);
           this.datos.crear(nombreCatalogo);
       } else{
           this.datos.crear(nombreCatalogo);
       }
       } catch (Exception e){
           e.printStackTrace(System.out);
       }
    }
    
}
