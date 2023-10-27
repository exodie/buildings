package buildings.impl.office;

import buildings.interfaces.Space;
import buildings.impl.space.AbstractSpace;

public class Office extends AbstractSpace implements Space {
    public Office() {
        super();
    }

    public Office(double square) {
        super(square);
    }

    public Office(double square, int quantity) {
        super(square, quantity);
    }
}
