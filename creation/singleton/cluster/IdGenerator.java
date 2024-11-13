package creation.singleton.cluster;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 분산 클러스터 환경, 여러 프로세스의 모음에 대한 싱글톤을 구현
 * 공유 싱글턴 클래스의 객체를 직렬화하고 파일과 같은 외부 공유 저장 영역에 저장할 수 있다.
 *
 * 프로세스가 이 싱글턴 클래스의 객체를 사용하려면 외부 공유 저장 영역에서 메모리로 읽어 사용하기 전에 객체로 직렬화 해야 한다.
 * 마지막으로 사용을 마치면 다시 직렬화를 통해 외부 공유 저장 장치에 다시 젖ㅇ하는 과정을 거쳐야 한다.
 *
 * 프로세스 사이에 항상 객체가 하나만 존재하도록 하려면 프로세스가 객체를 획득한 후, 다른 프로세스가 객체를 획득하지 못하도록 객체르 잠굴 필요가 있다.
 *
 * 프로세스가 객체 사용을 마쳤다면 메모리에서 객체를 명시적으로 삭제하고 객체에 대한 자금을 해제해야 한다.
 */
public class IdGenerator {
    private AtomicLong id = new AtomicLong(0);
    private static IdGenerator instance;

    // private static SharedObjectStorage storage = FileShareedObjectStorage

    // private static DistributedLock lock = new DistributedLock();

    private IdGenerator() {
    }

    public synchronized static IdGenerator getInstance() {
        if (instance == null) {
            // lock.lock();
            // instance = storage.load(IdGenerator.class);
        }
        return instance;
    }

    public synchronized void freeInstance() {
        // storage.save(this, IdGenerator.class);
        // instance = null;
        // lock.unlock();
    }

    public long getId() {
        return id.incrementAndGet();
    }
}

// 사용 예제
// IdGenerator idGen = IdGenerator.getInstance();
// long id = idGen.getId();
// IdGenerator.getInstance().freeInstance();
