package Singleton;

public class CommandeSingleton {
    private static CommandeSingleton instance;

    private CommandeSingleton() {}

    public static CommandeSingleton getInstance() {
        if (instance == null) {
            instance = new CommandeSingleton();
        }
        return instance;
    }

    public void montrer() {
        System.out.println("Commande Singleton");
    }
}
