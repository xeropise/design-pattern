package structural.proxy.inheritanceBase;

public class UserController implements IUserController {
    @Override
    public UserVO login(String telephone, String password) {
        System.out.println("login...");
        return new UserVO(telephone, password);
    }

    @Override
    public UserVO register(String telephone, String password) {
        System.out.println("register...");
        return new UserVO(telephone, password);
    }
}
