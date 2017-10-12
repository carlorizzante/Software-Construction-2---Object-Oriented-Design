public class Cake {

    private int pieces;
    private double pieceSize;

    public Cake() {
        pieces = 1;
        pieceSize = 1;
    }

    public double serveCake(int people) {

        pieces = pieces * 2;
        pieceSize = pieceSize / 2;

        if (pieces >= people) {
            double leftover = (pieces - people) * pieceSize;
            assert(leftover <= 1);
            return leftover;

        } else {
            return serveCake(people);
        }
    }
}
