package h2;

public class Spielstein {
    private int currentRow;
    private int currentCol;
    private Spielbrett brett;

    public Spielstein(Spielbrett brett, int indexRow, int indexCol) {
        this.brett = brett;
        this.currentRow = indexRow;
        this.currentCol = indexCol;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }

    public void setCurrentCol(int currentCol) {
        this.currentCol = currentCol;
    }

    public Spielbrett getBrett() {
        return brett;
    }

    public void setBrett(Spielbrett brett) {
        this.brett = brett;
    }

    private boolean movesOut() {
        Feld[][] feldArray = brett.getBrett();
        int dim = brett.getDim();
        char dir = feldArray[currentRow][currentCol].getDirection();
        switch (dir) {
            case 'U':
                return currentRow == 0;
            case 'D':
                return currentRow == dim - 1;
            case 'L':
                return currentCol == 0;
            case 'R':
                return currentCol == dim - 1;
            default:
                return false;
        }
    }

        public void go(int n) {
            if (n <= 0) return;
            Feld[][] feldArray = brett.getBrett();
            int dim = brett.getDim();
            for (int i = 0; i < n; i++) {
                Feld feld = feldArray[currentRow][currentCol];
                if (feld.isBoese()) {
                    // Bleibt stehen, wenn boese
                    break;
                }
                char dir = feld.getDirection();
                int newRow = currentRow;
                int newCol = currentCol;
                switch (dir) {
                    case 'U':
                        newRow = currentRow - 1;
                        break;
                    case 'D':
                        newRow = currentRow + 1;
                        break;
                    case 'L':
                        newCol = currentCol - 1;
                        break;
                    case 'R':
                        newCol = currentCol + 1;
                        break;
                    default:
                        // Ungültige Richtung, bleibt stehen
                        break;
                }
                // Prüfen, ob neue Position gültig ist
                if (newRow >= 0 && newRow < dim && newCol >= 0 && newCol < dim) {
                    currentRow = newRow;
                    currentCol = newCol;
                } else {
                    // Wenn außerhalb des Bretts, bleibt stehen
                    break;
                }
            }
        }
}
