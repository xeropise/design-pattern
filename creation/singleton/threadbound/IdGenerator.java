package creation.singleton.threadbound;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * ThreadLocal 을 사용하는 것이 널리 알려져 있다. ThreadLocal 도 HashMap data structure 를 사용하고 있지만, ThreadLocal 은 각 스레드 별로 별도의 저장 공간을 가지고 있다.
 *
 */
public class IdGenerator {
    private AtomicLong id = new AtomicLong(0);
    private static final ConcurrentHashMap<Long, IdGenerator> instances = new ConcurrentHashMap<>();

    private IdGenerator() {
    }

    public static IdGenerator getInstance() {
        Long currentThreadId = Thread.currentThread().threadId();

        instances.putIfAbsent(currentThreadId, new IdGenerator());

        return instances.get(currentThreadId);
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
