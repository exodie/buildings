package buildings.dwellingFloor;

import buildings.flat.Flat;

import java.util.Arrays;

public class Dwelling {
    private final DwellingFloor[] floors;

    public Dwelling(DwellingFloor[] floors) {
        this.floors = floors;
    }

    public Dwelling(int numOfFloors, int[] numOfApartments) {
        this(new DwellingFloor[numOfFloors]);

        for (int i = 0; i < numOfFloors; i++) {
            floors[i] = new DwellingFloor(numOfApartments[i]);
        }
    }

    public int getDwellingFloorQuantity() {
        return floors.length;
    }

    public int getFlatsQuantity() {
        int value = 0;

        for (DwellingFloor floor : floors) {
            value += floor.getTotalFlats();
        }

        return value;
    }

    public double getFlatsSquare() {
        double value = 0;

        for (DwellingFloor floor : floors) {
            value += floor.getFlatsSquare();
        }

        return value;
    }

    public int getRoomsQuantity() {
        int value = 0;

        for (DwellingFloor floor : floors) {
            value += floor.getFlatsQuantity();
        }

        return value;
    }

    public DwellingFloor[] getDwellingFloors() {
        return floors;
    }

    public DwellingFloor getDwellingFloor(int idx) {
        if (idx >= 0 && idx < floors.length) {
            return floors[idx];
        }

        return null;
    }

    public void setDwellingFloor(int idx, DwellingFloor newDwellingFloor) {
        if (idx >= 0 && idx < floors.length) {
            floors[idx] = newDwellingFloor;
        }
    }

    public Flat getFlat(int idx) {
        int currIdx = idx;

        for (DwellingFloor floor : floors) {
            int numOfFlatsOnFloor = floor.getTotalFlats();

            if (currIdx < numOfFlatsOnFloor) {
                return floor.getFlat(currIdx);
            } else {
                currIdx -= numOfFlatsOnFloor;
            }
        }

        return null;
    }

    /**
     * FIXME: Duplicate code with addFlat fc
     * @param idx
     * @param newFlat
     */
    public void setFlat(int idx, Flat newFlat) {
        int currIdx = idx;

        for (DwellingFloor floor : floors) {
            int numOfFlatsOnFloor = floor.getTotalFlats();

            if (currIdx < numOfFlatsOnFloor) {
                floor.setFlat(currIdx, newFlat);

                return;
            } else {
                currIdx -= numOfFlatsOnFloor;
            }
        }
    }

    public void addFlat(int idx, Flat newFlat) {
        int currIdx = idx;

        for (DwellingFloor floor : floors) {
            int numOfFlatsOnFloor = floor.getTotalFlats();

            if (currIdx <= numOfFlatsOnFloor) {
                floor.addFlat(currIdx, newFlat);

                return;
            } else {
                currIdx -= numOfFlatsOnFloor;
            }
        }
    }

    public void deleteFlat(int idx) {
        int currIdx = idx;

        for (DwellingFloor floor : floors) {
            int numOfFlatsOnFloor = floor.getTotalFlats();

            if (currIdx < numOfFlatsOnFloor) {
                floor.deleteFlat(currIdx);

                return;
            } else {
                currIdx -= numOfFlatsOnFloor;
            }
        }
    }

    public Flat getBestFlatBySquare() {
        Flat best = null;
        double maxSquare = 0;

        for (DwellingFloor floor : floors) {
            Flat bestFloor = floor.getBestSquare();

            if (bestFloor != null && bestFloor.getSquare() > maxSquare) {
                best = bestFloor;
                maxSquare = bestFloor.getSquare();
            }
        }

        return best;
    }

    public Flat[] getSortFlatsBySquare(int currentOrder) {
        int totalFlatsQuantity = getFlatsQuantity();
        int currIdx = 0;

        Flat[] flats = new Flat[totalFlatsQuantity];

        for (DwellingFloor floor : floors) {
            Flat[] floorFlat = floor.getFlats();

            // временное решение - переделаю
            System.arraycopy(floorFlat, 0, flats, currIdx, floorFlat.length);

            currIdx += floorFlat.length;
        }

        // временное решение - переделаю
        Arrays.sort(flats, (flat1, flat2) -> {
            if (currentOrder == 1) {
                return Double.compare(flat1.getSquare(), flat2.getSquare());
            }

            if (currentOrder == 0) {
                return Double.compare(flat2.getSquare(), flat1.getSquare());
            }

            return 1;
        });

        return flats;
    }
}
