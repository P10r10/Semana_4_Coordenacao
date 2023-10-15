public class Boar {
    private int cookID;
    private int boarID;

    public Boar(int cookID, int boarID) {
        this.cookID = cookID;
        this.boarID = boarID;
    }

    @Override
    public String toString() {
        return "Boar #" + boarID + " made by cook " + cookID;
    }
}
