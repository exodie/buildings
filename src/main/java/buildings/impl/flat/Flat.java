package buildings.impl.flat;

import buildings.interfaces.Space;
import buildings.impl.space.AbstractSpace;

public class Flat extends AbstractSpace implements Space {
    public Flat() {
        super();
    }

    public Flat(double square) {
        super(square);
    }

    public Flat(double square, int quantity) {
        super(square, quantity);
    }
}
