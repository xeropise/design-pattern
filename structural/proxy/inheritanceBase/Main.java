package structural.proxy.inheritanceBase;
public class Main {
    public static void main(String[] args) {
        IUserController userController = new UserControllerProxy(new MetricsCollector());
        userController.login("telephone", "password");
        userController.register("telephone", "password");
    }
}
