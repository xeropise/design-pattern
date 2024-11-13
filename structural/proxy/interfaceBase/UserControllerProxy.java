package structural.proxy.interfaceBase;

/**
 * UserControllerProxy는 UserController의 프록시 클래스이다.
 * UserControllerProxy는 UserController의 메서드를 호출하기 전후에 추가적인 로직을 수행한다.
 *
 * 프록시 클래스는 주요 비즈니스 코드를 실행하기 위해 위임(Delegation)을 통해 원본 클래스를 호출한다.
 * 프록시는 원본 클래스와 동일한 인터페이스를 구현하고 있다.
 *
 */
public class UserControllerProxy implements IUserController {
    private MetricsCollector metricsCollector;
    private UserController userController;

    public UserControllerProxy(UserController userController) {
        this.userController = userController;
        this.metricsCollector = new MetricsCollector();
    }

    @Override
    public UserVO login(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();

        UserVO userVo = userController.login(telephone, password);

        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        String apiName = "login";
        metricsCollector.recordRequest(apiName, responseTime);

        return userVo;
    }

    @Override
    public UserVO register(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();

        UserVO userVo = userController.register(telephone, password);

        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        String apiName = "register";
        metricsCollector.recordRequest(apiName, responseTime);

        return userVo;
    }
}
