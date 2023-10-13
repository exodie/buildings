package buildings.dwellingFloor;

import buildings.flat.Flat;

public class DwellingFloor {
    private Flat[] flats;

    public DwellingFloor(Flat[] flats) {
        this.flats = flats;
    }

    public DwellingFloor(int numOfFlats) {
        this(new Flat[numOfFlats]);

        for (int i = 0; i < numOfFlats; i++) {
            flats[i] = new Flat();
        }
    }

    public int getTotalFlats() {
        return flats.length;
    }

    public double getFlatsSquare() {
        double value = 0;

        for (Flat flat : flats) {
            value += flat.getSquare();
        }

        return value;
    }

    public int getFlatsQuantity() {
        int value = 0;

        for (Flat flat : flats) {
            value += flat.getQuantity();
        }

        return value;
    }

    public Flat[] getFlats() {
        return flats;
    }

    public Flat getFlat(int idx) {
        if (idx >= 0 && idx < flats.length) {
            return flats[idx];
        }

        return null;
    }

    public void setFlat(int idx, Flat newFlat) {
        if (idx >= 0 && idx < flats.length) {
            flats[idx] = newFlat;
        }
    }

    public void addFlat(int idx, Flat newFlat) {
        if (idx >= 0 && idx <= flats.length) {
            Flat[] newFlats = new Flat[flats.length + 1];

            for (int i = 0; i < idx; i++) {
                newFlats[i] = flats[i];
            }

            newFlats[idx] = newFlat;

            for (int i = idx; i < flats.length; i++) {
                newFlats[i + 1] = flats[i];
            }

            flats = newFlats;
        }
    }

    public void deleteFlat(int idx) {
        if (idx >= 0 && idx < flats.length) {
            Flat[] newFlats = new Flat[flats.length - 1];

            for (int i = 0, j = 0; i < flats.length; i++) {
                if (i != idx) {
                    newFlats[j++] = flats[i];
                }
            }

            flats = newFlats;
        }
    }

    public Flat getBestSquare() {
        if (flats.length == 0) {
            return null;
        }

        Flat best = flats[0];

        for (Flat flat : flats) {
            if (flat.getSquare() > best.getSquare()) {
                best = flat;
            }
        }

        return best;
    }
}
