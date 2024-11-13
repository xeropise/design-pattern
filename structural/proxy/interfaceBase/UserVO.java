package structural.proxy.interfaceBase;

public class UserVO {
    private String telephone;
    private String password;

    public UserVO(String telephone, String password) {
        this.telephone = telephone;
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getPassword() {
        return password;
    }
}
