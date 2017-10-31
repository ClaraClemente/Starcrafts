package herencia_starcraft;

public abstract class Escuadron implements Comparable<Escuadron> {

    private String nombre;
    private int nvictorias;
    int nivelataque;
    private int niveldefensa;

    public Escuadron() {
    }

    public Escuadron(String nombre, int nvictorias, int nivelataque, int niveldefensa) {
        this.nombre = nombre;
        this.nvictorias = nvictorias;
        this.nivelataque = nivelataque;
        this.niveldefensa = niveldefensa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNvictorias() {
        return nvictorias;
    }

    public void setNvictorias(int nvictorias) {
        this.nvictorias = nvictorias;
    }

    public int getNivelataque() {
        return nivelataque;
    }

    public void setNivelataque(int nivelataque) {
        this.nivelataque = nivelataque;
    }

    public int getNiveldefensa() {
        return niveldefensa;
    }

    public void setNiveldefensa(int niveldefensa) {
        this.niveldefensa = niveldefensa;
    }

    public abstract double calcularAtaque();

    public abstract double calcularDefensa();

    @Override
    public int compareTo(Escuadron o) {

        if (this.nvictorias > o.getNvictorias()) {
            return -1;

        } else if (this.nvictorias > o.getNvictorias()) {
            return 1;

        } else {
            return 0;
        }
    }

}
