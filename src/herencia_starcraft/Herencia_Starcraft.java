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
import java.util.Collections;
import java.util.List;
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

        if (array.length != 7) {
            System.out.println("ERROR 001: Nº de argumentos inválido");

        } else {
            if (!array[1].equalsIgnoreCase("zerg") && !array[1].equalsIgnoreCase("protoss") && !array[1].equalsIgnoreCase("terran")) {
                System.out.println("ERROR 002: Especie incorreta");
                
            }else if (array[1].equalsIgnoreCase("terran")) {

                
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
                if (array.length != 6) {
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

        int count1 = 0;
        int count2 = 0;

        Escuadron e1 = cogerEscuadron(nombreEscuadron1);
        Escuadron e2 = cogerEscuadron(nombreEscuadron2);

        if (e1 != null && e2 != null) {

            for (int asaltos = 0; asaltos != 5; asaltos++) {

                int aleatorio1 = (int) (Math.random() * 9 + 0);
                int aleatorio2 = (int) (Math.random() * 9 + 0);

                double b1 = aleatorio1 + e1.calcularAtaque() - e2.calcularDefensa();
                double b2 = aleatorio2 + e2.calcularAtaque() - e1.calcularDefensa();
                String ganador = " ";

                if (b1 > b2) {

                    count1++;
                    ganador = nombreEscuadron1;

                } else if (b1 < b2) {

                    count2++;
                    ganador = nombreEscuadron2;

                }

                System.out.println("Asalto nº " + asaltos);
                System.out.println("Ataca " + nombreEscuadron1 + "- Nº Aleatorio: " + aleatorio1 + "- Valor de su ataque:" + b1);
                System.out.println("Ataca " + nombreEscuadron2 + "- Nº Aleatorio: " + aleatorio2 + "- Valor de su ataque:" + b2);
                System.out.println("Ganador del asalto: " + ganador);

            }
            System.out.println("Fin batalla...");

            if (count1 >= 3) {

                System.out.println("OK: La batalla la ha ganado el escuadron" + nombreEscuadron1 + " con " + count1 + " asaltos.");
            } else if (count2 >= 3) {
                System.out.println("OK: La batalla la ha ganado el escuadron" + nombreEscuadron2 + " con " + count2 + " asaltos.");

            } else {
                System.out.println("OK: La batalla ha acabado en empate");
            }
        }

    }

    private static void mejorarEscuadron(String[] array) {

        String nombreEscuadron = array[1];
        String PropiedadAMejorar = array[2];
        String Nuevo = array[3];
        int NuevoDato = 0;
        NuevoDato = Integer.parseInt(Nuevo);

        if (array.length != 4) {
            System.out.println("ERROR 001: Nº de argumentos inválido");

        } else if (/*PropiedadAMejorar!= ||*/NuevoDato < 1) {
            System.out.println(" ERROR 003: Dato incorrecto ");
        } else if (existeNombre(nombreEscuadron)) {

            Escuadron e = cogerEscuadron(nombreEscuadron);

            if (e instanceof Terran) {
                Terran t = (Terran) e;

                if (PropiedadAMejorar.equalsIgnoreCase("edificio")) {

                    t.setNedificio(NuevoDato);

                } else if (PropiedadAMejorar.equalsIgnoreCase("arma")) {

                    t.setArma(NuevoDato);

                }else{
                    System.out.println("ERROR 006: Propiedad incorrecta");
                }
            }

            
            if (e instanceof Zerg) {
                Zerg z = (Zerg) e;

                if (PropiedadAMejorar.equalsIgnoreCase("esbirros")) {

                    z.setEsbirros(NuevoDato);

                } else if (PropiedadAMejorar.equalsIgnoreCase("overlords")) {

                    z.setOverlords(NuevoDato);

                }else{
                    System.out.println("ERROR 006: Propiedad incorrecta");
                }
            }
            

            if (e instanceof Protoss) {
                Protoss p = (Protoss) e;

                if (PropiedadAMejorar.equalsIgnoreCase("pilones")) {
                    
                    p.setPilones(NuevoDato);
                    
                }else{
                    System.out.println("ERROR 006: Propiedad incorrecta");
                }

            }

        } else {
            System.out.println("ERROR 005: No existe especie con ese nombre");
        }

    }

    private static void mostrarClasificacion(String[] array) {

        Collections.sort(escuadra);

        for (int i = 0; i < 3; i++) {

            System.out.println(escuadra.get(i));
        }

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
