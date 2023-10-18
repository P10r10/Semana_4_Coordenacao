package goldIngots;

public class Main {
    public static void main(String[] args) {
        Scale scale = new Scale();
        Digger digger = new Digger(scale);
        digger.start();
    }
}
