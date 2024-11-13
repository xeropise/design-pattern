package creation.singleton.eagerInitialization;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 지연 적재 (lazy loading) 를 지원하지 않으며, 인스턴스는 사용되는 시점이 아니라 미리 생성된다.
 *
 */
public class IdGenerator {
    private AtomicLong id = new AtomicLong(0);
    private static final IdGenerator instance = new IdGenerator();

    private IdGenerator() {
    }

    public static IdGenerator getInstance() {
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
