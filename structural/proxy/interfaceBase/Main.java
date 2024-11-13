package structural.proxy.interfaceBase;

public class Main {
    public static void main(String[] args) {
        IUserController userController = new UserControllerProxy(new UserController());
        userController.login("telephone", "password");
        userController.register("telephone", "password");
    }
}
