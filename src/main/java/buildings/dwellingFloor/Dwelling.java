package buildings.dwellingFloor;

import buildings.flat.Flat;

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
        int totalFlats = getFlatsQuantity();
        Flat[] flats = new Flat[totalFlats];
        int flatsLen = flats.length;

        int currentIndex = 0;
        for (DwellingFloor floor : floors) {
            Flat[] floorFlats = floor.getFlats();
            System.arraycopy(floorFlats, 0, flats, currentIndex, floorFlats.length);
            currentIndex += floorFlats.length;
        }

        for (int i = 0; i < flatsLen - 1; i++) {
            for (int j = 0; j < flatsLen - i - 1; j++) {
                double flatsLowPrev = flats[j].getSquare(), flatsHighNext = flats[j + 1].getSquare();

                if (currentOrder == 1 && flatsLowPrev > flatsHighNext) {
                    Flat temp = flats[j];
                    flats[j] = flats[j + 1];
                    flats[j + 1] = temp;
                } else if (currentOrder == 0 && flatsLowPrev < flatsHighNext) {
                    Flat temp = flats[j];
                    flats[j] = flats[j + 1];
                    flats[j + 1] = temp;
                }
            }
        }

        return flats;
    }
}
