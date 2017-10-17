/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia_starcraft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author DAM
 */
public class Herencia_Starcraft {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    }

    public static String pedirCadena(String mensaje) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String texto = "";
        boolean error = true;
        do {
            System.out.println(mensaje);
            try {
                texto = br.readLine();
                if (texto.equals("")) {
                    System.out.println("No puedes dejar en blanco el dato");
                } else {
                    error = false;
                }
            } catch (IOException ex) {
                System.out.println("Error de entrada y salida");
            }

        } while (error);
        return texto;
    }

    public static int pedirEnteroMayorCero(String mensaje) {
        int numero;
        do {
            numero = pedirEntero(mensaje);
            if (numero <= 0) {
                System.out.println("Debes introducir un número mayor a 0");
            }
        } while (numero <= 0);
        return numero;
    }

    public static int pedirEntero(String mensaje) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numero = 0;
        boolean error = true;
        do {
            try {
                System.out.println(mensaje);
                numero = Integer.parseInt(br.readLine());
                error = false;
            } catch (IOException ex) {
                System.out.println("Error de entrada y salida");
            } catch (NumberFormatException ex) {
                System.out.println("Debes escribir un número.");
            }
        } while (error);
        return numero;
    }

}
