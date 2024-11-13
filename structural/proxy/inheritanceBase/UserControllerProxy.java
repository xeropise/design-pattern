package structural.proxy.inheritanceBase;

/**
 * 상속을 추가하고, super.methodcall() 을 통해 부모 클래스의 메소드를 호출하여 인터페이스 기반의 프록시 패턴을 대체하였다.
 *
 * 프록시 클래스가 원본 클래스의 모든 메서드를 다시 구현하고, 각 메서드의 유사한 코드 논리를 첨부해야 한다.
 * 기능을 추가해야 하는 원본 클래스가 50개라면 프록시 클래스도 50개 추가 해야 한다.
 *
 * 프로젝트의 클래스 수가 증가하고, 코드의 유지 관리 비용이 증가하게 된다.
 * 프로젝트의 클래스 수가 증가하고, 코드의 유지 관리 비용이 증가하게 된다.
 *
 */
public class UserControllerProxy extends UserController {
    private MetricsCollector metricsCollector;

    public UserControllerProxy(MetricsCollector metricsCollector) {
        this.metricsCollector = metricsCollector;
    }

    public UserVO login(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();
        UserVO userVO = super.login(telephone, password);
        long endTimeStamp = System.currentTimeMillis();

        long responseTime = endTimeStamp - startTimestamp;

        metricsCollector.recordRequest("login", responseTime);

        return userVO;
    }

    public UserVO register(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();
        UserVO userVO = super.register(telephone, password);
        long endTimeStamp = System.currentTimeMillis();

        long responseTime = endTimeStamp - startTimestamp;

        metricsCollector.recordRequest("register", responseTime);

        return userVO;
    }
}
