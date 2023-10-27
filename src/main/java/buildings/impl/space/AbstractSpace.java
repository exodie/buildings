package buildings.impl.space;

import lombok.Data;

@Data
public abstract class AbstractSpace {
    private double square;
    private int quantity;

    private static final double DEFAULT_SQUARE = 50;
    private static final int DEFAULT_QUANTITY = 2;

    public AbstractSpace() {
        this(DEFAULT_SQUARE, DEFAULT_QUANTITY);
    }

    public AbstractSpace(double square) {
        this(square, DEFAULT_QUANTITY);
    }

    public AbstractSpace(double square, int quantity) {
        if (square <= 0 || quantity <= 0) {
            throw new Error("Square or Quantity cannot be equal to or less 0.");
        }

        this.square = square;
        this.quantity = quantity;
    }
}
