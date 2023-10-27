package buildings.impl.dwellingFloor;

import buildings.impl.flat.Flat;
import buildings.interfaces.Building;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;

public class Dwelling implements Building {
    private Floor[] floors;

    public int getFlatsQuantity() {
        int value = 0;

        for (Floor floor : floors) {
            value += floor.getTotalFlats();
        }

        return value;
    }

    public Dwelling(int numOfFloors, int[] numOfApartments) {
        this(new Floor[numOfFloors]);

        for (int i = 0; i < numOfFloors; i++) {
            floors[i] = new DwellingFloor(numOfApartments[i]);
        }
    }

    public Dwelling(Floor[] floors) {
        this.floors = floors;
    }

    public int getTotalFlats() {
        int totalQuantity = 0;
        for (Floor floor : floors) {
            totalQuantity += floor.getTotalFlats();
        }
        return totalQuantity;
    }

    public int getFloorQuantity() {
        return floors.length;
    }

    public double getFlatsSquare() {
        double value = 0;

        for (Floor floor : floors) {
            value += floor.getFlatsSquare();
        }

        return value;
    }

    public Floor[] getFloors() {
        return floors;
    }

    public Floor getFloor(int idx) {
        if (idx >= 0 && idx < floors.length) {
            return floors[idx];
        }

        return null;
    }

    public void setFloor(int idx, Floor newFloor) {
        if (idx >= 0 && idx < floors.length) {
            floors[idx] = newFloor;
        }
    }

    public Space getFlat(int idx) {
        int currIdx = idx;

        for (Floor floor : floors) {
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
    public void setFlat(int idx, Space newFlat) {
        int currIdx = idx;

        for (Floor floor : floors) {
            int numOfFlatsOnFloor = floor.getTotalFlats();

            if (currIdx < numOfFlatsOnFloor) {
                floor.setFlat(currIdx, newFlat);

                return;
            } else {
                currIdx -= numOfFlatsOnFloor;
            }
        }
    }

    public void addFlat(int idx, Space newFlat) {
        int currIdx = idx;

        for (Floor floor : floors) {
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

        for (Floor floor : floors) {
            int numOfFlatsOnFloor = floor.getTotalFlats();

            if (currIdx < numOfFlatsOnFloor) {
                floor.deleteFlat(currIdx);

                return;
            } else {
                currIdx -= numOfFlatsOnFloor;
            }
        }
    }

    public Space getBestSpaceBySquare() {
        Space best = null;
        double maxSquare = 0;

        for (Floor floor : floors) {
            Space bestFloor = floor.getBestSquare();

            if (bestFloor != null && bestFloor.getSquare() > maxSquare) {
                best = bestFloor;
                maxSquare = bestFloor.getSquare();
            }
        }

        return best;
    }

    public Space[] getSortSpacesBySquare(int currentOrder) {
        int totalFlats = getFlatsQuantity();
        Flat[] flats = new Flat[totalFlats];
        int flatsLen = flats.length;

        int currentIndex = 0;
        for (Floor floor : floors) {
            Space[] floorFlats = floor.getFlats();
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
