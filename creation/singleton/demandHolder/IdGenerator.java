package creation.singleton.demandHolder;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 홀더에 의한 초기화 (Initlization on demand holder idiom) 방식은 이중 잠금 (double-checked locking) 방식의 단점을 보완하고 있다.
 * 정적 내부 클래스 (static inner class) 로, 외부 클래스가 적재 되는 시점에는 적재 되지 않는다.
 * getInstance() 메소드가 호출되는 시점에 비로소 적재되며, 이때 클래스 초기화 과정을 통해 객체를 생성한다.
 * 인스턴스의 유일성과 생성 프로세스의 스레드 안전성이 JVM 에 의해 보장된다.
 *
 * 적재? : 자바 프로그램이 실행될 때 JVM(Java Virtual Machine)이 필요한 클래스 파일을 메모리에 로드하는 과정
 * 1. Loading : 클래스 로더를 통해 클래스 파일을 읽어들여 JVM 메모리에 적재
 * 2. Linking : Verify, Prepare, Resolve의 세 단계로 나뉜다.
 * 3. Initialization : 클래스 초기화 블록과 static 변수를 초기화하고, 클래스의 static 초기화 블록을 실행
 *
 */
public class IdGenerator {
    private AtomicLong id = new AtomicLong(0);

    private IdGenerator() {
    }

    private static class SingletonHolder {
        private static final IdGenerator instance = new IdGenerator();
    }

    public static IdGenerator getInstance() {
        return SingletonHolder.instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
