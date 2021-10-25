package com.ceep.videoclub.principal;

import com.ceep.videoclub.dominio.Pelicula;
import com.ceep.videoclub.negocio.*;
import java.util.Scanner;

public class Principal {
    
    public static void main(String[] args){
        
        var opcion = -1;
        var nombrePeli = "";
        var lectura = new Scanner(System.in);
        var nombreCatalogo = "VideoClub.txt";
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl();
        
        while (opcion != 0){
            System.out.println("Elige una de las opciones: \n "
            + "1.- Iniciar catalogo de peliculas.\n"
            + "2.- Agregar pelicula.\n"
            + "3.- Listar peliculas.\n"
            + "4.- Buscar pelicula.\n"
            + "0.- Salir.\n ");
            
            opcion = Integer.parseInt(lectura.nextLine());
            
            switch (opcion){
                case 1:
                    catalogo.iniciarCatalogo(nombreCatalogo);
                    System.out.println("Catalogo iniciado...");
                    break;
                case 2:
                    System.out.println("introduce el nombre de la pelicula a agregar: ");
                    nombrePeli = lectura.nextLine();
                    catalogo.agregarPelicula(nombrePeli, nombreCatalogo);
                    System.out.println("Se ha agregado la pelicula " + nombrePeli + " al catalogo" + nombreCatalogo);
                    break;
                    
                case 3: 
                    catalogo.listarPelicula(nombreCatalogo);
                    break;
                    
                case 4:
                    System.out.println("Introduce el nombre de la pelicula que quieres buscar");
                    nombrePeli = lectura.nextLine();
                    catalogo.buscarPelicula(nombreCatalogo, nombrePeli);
                    break;
                    
                case 0:
                    System.out.println("Adios y hasta pronto!!! : ");
                    break;
                    
                default:
                    System.out.println("Opcion desconocida");
            }
        }
    }
}
