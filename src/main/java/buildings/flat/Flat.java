package buildings.flat;

public class Flat {
    private double square;
    private int quantity;

    private static final double DEFAULT_SQUARE = 50;
    private static final int DEFAULT_QUANTITY = 2;

    public Flat() {
        this(DEFAULT_SQUARE, DEFAULT_QUANTITY);
    }

    public Flat(double square) {
        this(square, DEFAULT_QUANTITY);
    }

    public Flat(double square, int quantity) {
        if (square <= 0 || quantity <= 0) {
            throw new Error("Square or Quantity cannot be equal to or less 0.");
        }

        this.square = square;
        this.quantity = quantity;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
