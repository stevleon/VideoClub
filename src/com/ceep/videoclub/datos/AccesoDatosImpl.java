package com.ceep.videoclub.datos;

import com.ceep.videoclub.dominio.Pelicula;
import com.ceep.videoclub.excepciones.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccesoDatosImpl  implements IAccesoDatos{

    @Override
    public boolean existe(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx {
        var archivo = new File(nombreArchivo);
        Pelicula pelicula = null;
        List<Pelicula> peliculas = new ArrayList<>();
        try{
            var entrada = new BufferedReader(new FileReader(archivo));
            //nos devuelve una linea de nuestro archivo 
            var lectura= entrada.readLine();
            while(lectura != null){ //hasta null
                //Creamos un objeto de Pelicula con cada linea del archivo
                pelicula = new Pelicula(lectura);
                // Añado cada pelicula a mi listado de peliculas
                peliculas.add(pelicula);
                // Avanzamos en la lectura 
                lectura = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException e){
            e.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listando las peliculas");
        } catch (IOException e){
            e.printStackTrace(System.out);
             throw new LecturaDatosEx("Error de lectura listando las peliculas");
        }
        return peliculas;   
     }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        File archivo = new File(nombreArchivo);
        
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.getNombre());
            salida.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new EscrituraDatosEx("Excepcion al escribir en el archivo");
        }
        
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {  
        var  archivo = new File(nombreArchivo);
        int cont = 1;
        String mensaje = "";
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();    
           
            while(lectura !=null){
                if (lectura.equalsIgnoreCase(buscar)){
                    mensaje = "La pelicula \n " + buscar + " se encuentra en la " +" linea "
                            + cont + " del catalogo de peliculas";
                    break;
                }
                lectura = entrada.readLine();
                cont++;
            }
            if (lectura == null)
                mensaje = "La pelicula" + buscar +  "no esta en el catalogo de peliculas";   
            
            entrada.close();
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listando las peliculas");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listando las peliculas");
        }
     return mensaje;  
    }
    
    
    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
       var archivo = new File(nombreArchivo);
       try{
           var salida = new PrintWriter(new FileWriter(archivo));
           salida.close();
       } catch (Exception e){
           e.printStackTrace(System.out);
           throw new AccesoDatosEx("Error al crear el archivo");
       }
    }

    @Override
    public void borrar(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        if (archivo.exists()){
            archivo.delete();
        }
        System.out.println("Se ha borrado el archivo");
    }
    
}
