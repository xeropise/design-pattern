package structural.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 자바는 기본적으로 동적 프록시를 지원하고 있음
 * Spring AOP 의 기본 구현 원칙은 동적 프록시를 기반으로 함
 *
 * 프록시 클래스를 생성할 클래스를 구성하고, 원본 클래스의 주요 비즈니스 코드가 실행되기 전과 후에 수행할 추가 기능을 정의 한다.
 *
 * Spring 은 이러한 클래스에 대해 동적 프록시 클래스를 생성해주고, 원본 클래스의 객체를 JVM 의 동적 프록시 클래스 객체로 대체한다.
 *
 * 코드에서 원본 클래스를 실행해야 하는 메서드는 프록시 클래스를 실행하는 메서드로 대체 된다.
 */
public class MetricsCollectorProxy {
    private MetricsCollector metricsCollector;

    public MetricsCollectorProxy() {
        this.metricsCollector = new MetricsCollector();
    }

    public Object createProxy(Object proxiedObject) {
        Class<?>[] interfaces = proxiedObject.getClass().getInterfaces();

        DynamicProxyHandler handler = new DynamicProxyHandler(proxiedObject);

        return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(), interfaces, handler);
    }


    private class DynamicProxyHandler implements InvocationHandler {
        private Object proxiedObject;

        public DynamicProxyHandler(Object proxiedObject) {
            this.proxiedObject = proxiedObject;
        }


        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            long startTimestamp = System.currentTimeMillis();

            Object result = method.invoke(proxiedObject, args);

            long endTimestamp = System.currentTimeMillis();
            long responseTime = endTimestamp - startTimestamp;

            String apiName = proxiedObject.getClass().getName() + ":" + method.getName();

            metricsCollector.recordRequest(apiName, responseTime);

            return null;
        }
    }

}
