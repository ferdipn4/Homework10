package h2;

public class Spielbrett {
    private Feld[][] brett;
    private int dim;

    public Spielbrett(int dim) {
        this.dim = dim;
        this.brett = new Feld[dim][dim];
    }

    public Feld[][] getBrett() {
        return brett;
    }

    public void setBrett(Feld[][] brett) {
        this.brett = brett;
    }

    public int getDim() {
        return dim;
    }

    public void setDim(int dim) {
        this.dim = dim;
    }
}
