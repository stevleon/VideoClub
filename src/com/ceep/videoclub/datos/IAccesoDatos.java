package com.ceep.videoclub.datos;

import java.util.*;
import com.ceep.videoclub.dominio.Pelicula;
import com.ceep.videoclub.excepciones.*;

public interface IAccesoDatos {
    
    //comprueba si el fichero existe 
    boolean existe(String nombreArchivo);    
    //Lista todas las peliculas contenidas en el archivo nombreArchivo 
    List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx;
    
    //Escribe una nueba pelicula en el archivo nombreArchivo 
    // con el parametro anexar podemos indicar si queremos agregar la pelicula
    //o sobreescribir
    void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) 
            throws EscrituraDatosEx;
    
    //Busca la expresion de buscar en el archivo y nos muestra un mensaje en 
    //caso de que lo encuentre o no
    String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;
    
    //Crear el archivo
    void crear(String nombreArchivo) throws AccesoDatosEx;
    
    //Borra el archivo
    void borrar(String nombreArchivo);    
}
