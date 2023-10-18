package v1;

public class Boar {
    private final int cookID;
    private final int boarID;

    public Boar(int cookID, int boarID) {
        this.cookID = cookID;
        this.boarID = boarID;
    }

    @Override
    public String toString() {
        return "Boar #" + boarID + " made by cook #" + cookID;
    }
}
