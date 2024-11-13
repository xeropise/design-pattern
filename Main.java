import creation.singleton.eagerInitialization.IdGenerator;

public class Main {
    public static void main(String[] args) {
        // Single
        long id = IdGenerator.getInstance().getId();
    }
}
