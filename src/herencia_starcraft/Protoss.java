package herencia_starcraft;

public class Protoss extends Escuadron {

    private int pilones;

    public Protoss(int pilones) {
        this.pilones = pilones;
    }

    public Protoss(int pilones, String nombre, int nvictorias, int nivelataque, int niveldefensa) {
        super(nombre, nvictorias, nivelataque, niveldefensa);
        this.pilones = pilones;
    }

    public int getPilones() {
        return pilones;
    }

    public void setPilones(int pilones) {
        this.pilones = pilones;
    }

    @Override
    public double calcularAtaque() {
        return (pilones * 1.50) + getNivelataque();

    }

    @Override
    public double calcularDefensa() {
        return (pilones * 1.50) + getNiveldefensa();

    }
}
