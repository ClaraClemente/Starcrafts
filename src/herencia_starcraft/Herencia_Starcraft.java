/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia_starcraft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DAM
 */
public class Herencia_Starcraft {

    static ArrayList<Escuadron> escuadra;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        escuadra = new ArrayList<>();
        String[] array = null;
        do {

            try {
                String linea = br.readLine();
                array = linea.split(" ");

                if (array[0].equalsIgnoreCase("a")) {
                    altaEscuadron(array);
                } else if (array[0].equalsIgnoreCase("r")) {
                    registrarBatalla(array);
                } else if (array[0].equalsIgnoreCase("m")) {
                    mejorarEscuadron(array);
                } else if (array[0].equalsIgnoreCase("c")) {
                    mostrarClasificacion(array);
                } else if (array[0].equalsIgnoreCase("s")) {
                    // salir
                } else {
                    System.out.println("ERROR 003: Letra incorrecta");
                }
            } catch (IOException ex) {
                Logger.getLogger(Herencia_Starcraft.class.getName()).log(Level.SEVERE, null, ex);
            }

        } while (!array[0].equals("s"));
    }

    private static void altaEscuadron(String[] array) {

        if (!array[1].equalsIgnoreCase("zerg") && !array[1].equalsIgnoreCase("protoss") && !array[1].equalsIgnoreCase("terran")) {
            System.out.println("ERROR 002: Especie incorreta");

        } else {

            if (array[1].equalsIgnoreCase("terran")) {
                if (array.length != 7) {
                    System.out.println("ERROR 001: Nº de argumentos inválido");

                } else {
                    String nombre = array[2];
                    int ataque = Integer.parseInt(array[3]);
                    int defensa = Integer.parseInt(array[4]);
                    int edificio = Integer.parseInt(array[5]);
                    int tecnologia = Integer.parseInt(array[6]);

                    if (ataque < 1 || defensa < 1 || edificio < 1 || tecnologia < 1) {
                        System.out.println(" ERROR 003: Dato incorrecto ");
                    } else if (existeNombre(nombre)) {
                        System.out.println(" ERROR 007: Ya existe un escuadrón con ese nombre");

                    } else {
                        Terran t = new Terran(edificio, tecnologia, nombre, 0, ataque, defensa);
                        escuadra.add(t);
                        System.out.println("Terran dado de alta");
                    }
                }

            } else if (array[1].equalsIgnoreCase("zerg")) {

                if (array.length != 7) {
                    System.out.println("ERROR 001: Nº de argumentos inválido");

                } else {
                    String nombre = array[2];
                    int ataque = Integer.parseInt(array[3]);
                    int defensa = Integer.parseInt(array[4]);
                    int esbirros = Integer.parseInt(array[5]);
                    int overlords = Integer.parseInt(array[6]);

                    if (ataque < 1 || defensa < 1 || esbirros < 1 || overlords < 1) {
                        System.out.println(" ERROR 003: Dato incorrecto ");
                    }

                    if (existeNombre(nombre)) {
                        System.out.println(" ERROR 007: Ya existe un escuadrón con ese nombre");

                    } else {
                        Zerg z = new Zerg(esbirros, overlords, nombre, 0, ataque, defensa);
                        escuadra.add(z);
                        System.out.println("Zerg dado de alta");
                    }
                }

            } else if (array[1].equalsIgnoreCase("protoss")) {
                if (array.length != 7) {
                    System.out.println("ERROR 001: Nº de argumentos inválido");

                } else {

                    String nombre = array[2];
                    int ataque = Integer.parseInt(array[3]);
                    int defensa = Integer.parseInt(array[4]);
                    int pilones = Integer.parseInt(array[5]);

                    if (ataque < 1 || defensa < 1 || pilones < 1) {
                        System.out.println(" ERROR 003: Dato incorrecto ");
                    }

                    if (existeNombre(nombre)) {
                        System.out.println(" ERROR 007: Ya existe un escuadrón con ese nombre");

                    } else {

                        Protoss p = new Protoss(pilones, nombre, 0, ataque, defensa);
                        escuadra.add(p);
                        System.out.println("Protoss dado de alta");
                    }

                }

            }

        }

    }

    private static void registrarBatalla(String[] array) {

        String nombreEscuadron1 = array[1];
        String nombreEscuadron2 = array[2];
        Escuadron e1 = cogerEscuadron(nombreEscuadron1);
        
        if (e1 != null && e2 != null) {

            for (int asaltos = 5; asaltos != 0; asaltos--) {

                int aleatorio = (int) (Math.random() * 9 + 0);
                
                //1r torn
               
                
                
                
                //2n torn

            }

        }

    }

    private static void mejorarEscuadron(String[] array) {

        String nombreEscuadron = array[1];
        String PropiedadAMejorar = array[2];
        String NuevoDato = array[3];

        if (array.length != 4) {
            System.out.println("ERROR 001: Nº de argumentos inválido");

        } else {
            if (PropiedadAMejorar || NuevoDato < 1) {
                System.out.println(" ERROR 003: Dato incorrecto ");
            }else{
                !existeNombre(nombreEscuadron) 
            }

            if (existeNombre(nombreEscuadron)) {
                System.out.println(" ERROR 007: Ya existe un escuadrón con ese nombre");

            } else {

            }
        }

    }

    private static void mostrarClasificacion(String[] array) {
        System.out.println("hola xavi");
    }

    public static boolean existeNombre(String nombre) {
        // recorremos el ArrayList buscando si existe un disco con el mismo título
        for (Escuadron e : escuadra) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }
    
     public static Escuadron cogerEscuadron(String nombre) {
        // recorremos el ArrayList buscando si existe un disco con el mismo título
        for (Escuadron e : escuadra) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                return e;
            }
        }
        return null;
    }

}
