package structural.proxy.inheritanceBase;

public interface IUserController {
    UserVO login(String telephone, String password);
    UserVO register(String telephone, String password);
}
