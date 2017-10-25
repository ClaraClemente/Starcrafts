
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia_starcraft;

/**
 *
 * @author DAM
 */
public class Zerg extends Escuadron {

    private int esbirros;
    private int overlords;

    public Zerg(int esbirros, int overlords) {
        this.esbirros = esbirros;
        this.overlords = overlords;
    }

    public Zerg(int esbirros, int overlords, String nombre, int nvictorias, int nivelataque, int niveldefensa) {
        super(nombre, nvictorias, nivelataque, niveldefensa);
        this.esbirros = esbirros;
        this.overlords = overlords;
    }

    public int getOverlords() {
        return overlords;
    }

    public void setOverlords(int overlords) {
        this.overlords = overlords;
    }

    public int getEsbirros() {
        return esbirros;
    }

    public void setEsbirros(int esbirros) {
        this.esbirros = esbirros;
    }

    @Override
    public double calcularAtaque() {

        double u = (esbirros * 1.15) + getNivelataque();
        return u + (overlords * 1.40);
    }

    @Override
    public double calcularDefensa() {

        return (esbirros * 1.30) + getNiveldefensa();

    }

}
