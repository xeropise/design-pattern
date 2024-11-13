package creation.singleton.lazyInitialization;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 즉시 초기화 (eager initialization) 와 달리 지연 적재를 지원 한다.
 * 인스턴스의 생성과 초기화가 실제로 사용되기전까지 일어나지 않는다.
 * 그렇다고 반드시 좋은 것은 아니다. 인스턴스의 초기화에 많은 자원이 필요하다면 빨리 노출 시키는 fail-fast 설계 원칙에 따라 즉시 초기화 하는 것도 맞다.
 *
 * 이 방식은 높은 동시성을 지원하지는 않는다. 아래 참조
 */
public class IdGenerator {
    private AtomicLong id = new AtomicLong(0);
    private static IdGenerator instance;

    private IdGenerator() {
    }

    // synchronized 키워드를 사용하여 thread-safe 하게 만들었다.
    // 동시성 문제를 해결하기 위해 synchronized 를 사용하였지만, 성능상의 이슈가 있을 수 있다.
    // synchronized 는 메소드 전체에 lock 을 걸기 때문에, 다른 스레드가 getInstance() 메소드를 호출하면 lock 이 풀릴 때까지 기다려야 한다.
    // 호출이 여러번 된다면, 다른 방법을 고려해 봐야 한다.

    public static synchronized IdGenerator getInstance() {
        if (instance == null) {
            instance = new IdGenerator();
        }
        return instance;
    }
}
