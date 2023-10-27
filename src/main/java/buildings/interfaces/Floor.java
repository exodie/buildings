package buildings.interfaces;

public interface Floor {
    int getTotalFlats();
    double getFlatsSquare();
    int getFlatsQuantity();
    Space[] getFlats();
    Space getFlat(int index);
    void setFlat(int index, Space newFlat);
    void addFlat(int index, Space newFlat);
    void deleteFlat(int index);
    Space getBestSquare();
}
