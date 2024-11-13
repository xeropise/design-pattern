package creation.singleton.enums;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 열거 (enumeration) 타입을 사용하여 싱글톤을 구현할 수 있다.
 *
 */
public enum IdGenerator {
    INSTANCE;
    private AtomicLong id = new AtomicLong();

    public long getId() {
        return id.incrementAndGet();
    }
}
