import buildings.dwellingFloor.Dwelling;
import buildings.dwellingFloor.DwellingFloor;
import buildings.flat.Flat;

public class Main {
    public static void main(String[] args) {
        showFlats();
        showDwellingFloor();
    }

    private static void showFlats() {
        Flat defaultFlat = new Flat();
        Flat customFlatSquare = new Flat(100);
        Flat customFlat = new Flat(100, 3);

        System.out.println("Default flat-constructor [square]: " + defaultFlat.getSquare());
        System.out.println("Default flat-constructor [quantity]: " + defaultFlat.getQuantity());

        System.out.println();

        System.out.println("Custom flatSquare-constructor: " + customFlatSquare.getSquare());
        System.out.println("Custom flatSquare-constructor: " + customFlatSquare.getSquare());

        System.out.println();

        System.out.println("Custom flat-constructor [square]: " + customFlat.getSquare());
        System.out.println("Custom flat-constuctor [quantity]: " + customFlat.getQuantity());
    }

    private static void showDwellingFloor() {
        int[] numOfFlats = new int[] {1, 2, 3, 4};
        Flat FlatOne = new Flat(100);
        Flat FlatTwo = new Flat(10.5);

        DwellingFloor floor = new DwellingFloor(10);
        Dwelling house = new Dwelling(4, numOfFlats);

        System.out.println();

        System.out.println("Общее колличество этажей [getDwellingFloorQuantity]: " + house.getDwellingFloorQuantity());
        System.out.println("Общее колличество квартир [getFlatsQuantity]: " + house.getFlatsQuantity());
        System.out.println("Общая площадь [getFlatsSquare]: " + house.getFlatsSquare());
        System.out.println("Общее колличество комнат [getRoomsQuantity]: " + house.getRoomsQuantity());

        System.out.println(house.getDwellingFloor(1).getClass());
        house.setDwellingFloor(0, floor);
        System.out.println("Общее колличество квартир после изменения [getFlatsQuantity]: " + house.getFlatsQuantity());

        System.out.println(house.getFlat(2).getClass());

        house.setFlat(2, FlatOne);
        System.out.println("Общая площадь после изменения квартиры [getFlatsSquare]: " + house.getFlatsSquare());

        house.addFlat(3, FlatTwo);
        System.out.println("Общее колличество квартир после добавления [getFlatsQuantity]: " + house.getFlatsQuantity());

        house.deleteFlat(3);
        System.out.println("Общее колличество квартир после удаления [getFlatsQuantity]: " + house.getFlatsQuantity());

        System.out.println("Самая большая площадь [getSquare-sort]: " + house.getBestFlatBySquare().getSquare());

        System.out.print("Общее состояние этажа [currentOrder = 1]: ");
        Flat[] FlatArray = house.getSortFlatsBySquare(1);
        for (Flat Flats: FlatArray) {
            System.out.print(Flats.getSquare() + " ");
        }
    }
}