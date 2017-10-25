package herencia_starcraft;

public class Terran extends Escuadron {

    private int nedificio;
    private int arma;

    public Terran(int nedificio, int arma) {
        this.nedificio = nedificio;
        this.arma = arma;
    }

    public Terran(int nedificio, int arma, String nombre, int nvictorias, int nivelataque, int niveldefensa) {
        super(nombre, nvictorias, nivelataque, niveldefensa);
        this.nedificio = nedificio;
        this.arma = arma;
    }

    public int getArma() {
        return arma;
    }

    public void setArma(int arma) {
        this.arma = arma;
    }

    public int getNedificio() {
        return nedificio;
    }

    public void setNedificio(int nedificio) {
        this.nedificio = nedificio;
    }

    public int aumentaDefensaEdificio() {

        return (int) (getNivelataque() * 1.25);

    }

    public int aumentaDefensaArma() {

        return (int) (getNivelataque() * 1.50);

    }

    @Override
    public double calcularAtaque() {

        return (arma * 1.50) + getNivelataque();

    }

    @Override
    public double calcularDefensa() {
        return (nedificio * 1.25) + getNiveldefensa();

    }

}
