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

    public int aumentaAtaquePilon() {

        return (int) (getNivelataque() * 1.50);

    }
   public int aumentaDefensaPilon() {

        return (int) (getNiveldefensa() * 1.50);

    }
}
