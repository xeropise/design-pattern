package creation.singleton.doubleCheckedLocking;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 지연 적재 (lazy loading) 를 지원하며, 높은 동시성을 모두 지원하는 방식이다.
 * 인스턴스가 생성된 후, getInstance() 함수가 계속 호출되는 상황에서는 잠금이 발생하지 않는다.
 *
 * CPU 명령이 재정렬되면 초기화가 이루어지기 전에 다른 스레드에서 이 객체에 접근할 수도 있다.
 * volatile 키워드를 통해 명령어 재정렬을 방지할 수 있다.
 *
 * CPU 명령어 재정렬(Instruction Reordering)은 컴파일러나 CPU가 프로그램의 성능을 최적화하기 위해 명령어 실행 순서를 변경하는 것을 의미
 */
public class IdGenerator {
    private volatile AtomicLong id = new AtomicLong(0);
    private static IdGenerator instance;

    private IdGenerator() {
    }

    public static IdGenerator getInstance() {
        if (instance == null) {
            synchronized (IdGenerator.class) { // 클래스 레벨의 잠금 처리
                if (instance == null) {
                    instance = new IdGenerator();
                }
            }
        }

        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
