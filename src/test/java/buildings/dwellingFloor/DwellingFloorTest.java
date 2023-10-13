package buildings.dwellingFloor;
import buildings.flat.Flat;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

public class DwellingFloorTest {

    private final Flat flat1 = new Flat(50, 2);
    private final Flat flat2 = new Flat(100);
    private final Flat[] DwellingFloors = new Flat[] { flat1, flat2 };
    private final DwellingFloor Floor = new DwellingFloor(DwellingFloors);

    @Test
    public void testGetTotalFlats() {
        var result = Floor.getTotalFlats();

        System.out.println("GetTotalFlats: " + result);

        Assertions.assertEquals(DwellingFloors.length, result);
    }

    @Test
    public void testGetFlatsSquare() {
        var result = Floor.getFlatsSquare();

        System.out.println("getFlatsSquare: " + result);

        Assertions.assertEquals(flat1.getSquare() + flat2.getSquare(), result);
    }

    @Test
    public void testGetFlatsQuantity() {
        var result = Floor.getFlatsQuantity();

        System.out.println("getFlatsQuantity: " + result);

        Assertions.assertEquals(flat1.getQuantity() + flat2.getQuantity(), result);
    }

    @Test
    public void testGetFlats() {
        var result = Floor.getFlats();

        System.out.println("getFlats: " + Arrays.toString(result));

        Assertions.assertEquals(DwellingFloors, result);
    }

    @Test
    public void testGetFlat() {
        var result = Floor.getFlat(1);

        System.out.println("getFlat [1]: " + Arrays.toString(new double[]{result.getSquare(), result.getQuantity()}));

        Assertions.assertEquals(flat2, result);
    }

    @Test
    public void testSetFlat() {
        int idx = 1; // CheckoutMe

        Floor.setFlat(idx, flat2);

        // Duplicate code with testAddFlat {}
        var result = Floor.getFlat(idx);

        System.out.println("setFlat - get: " + Arrays.toString(new double[]{result.getSquare(), result.getQuantity()}));

        Assertions.assertEquals(flat2, result);
    }

    @Test
    public void testAddFlat() {
        int idx = 2;

        Floor.addFlat(idx, flat1);

        var result = Floor.getFlat(idx);

        System.out.println("addFlat - get: " + Arrays.toString(new double[]{result.getSquare(), result.getQuantity()}));

        Assertions.assertEquals(flat1, result);
    }

    @Test
    public void testDeleteFlat() {
        int idx = 0;

        Floor.deleteFlat(idx);

        var result = Floor.getFlat(idx);

        System.out.println("deleteFlat - get: " + Arrays.toString(new double[]{result.getSquare(), result.getQuantity()}));

        Assertions.assertEquals(flat2, result);
    }

    @Test
    public void testGetBestSquare() {
        var result = Floor.getBestSquare();

        System.out.println("getBestSquare: " + Arrays.toString(new double[]{result.getSquare(), result.getQuantity()}));

        // FIXME: find auto max on expected params
        Assertions.assertEquals(100, result.getSquare());
    }
}