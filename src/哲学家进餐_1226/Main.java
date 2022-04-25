package 哲学家进餐_1226;

import com.sun.prism.RenderTarget;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers {

    private ReentrantLock[] forkLock;
    private Semaphore eatLimit = new Semaphore(4);

    public DiningPhilosophers() {
        forkLock = new ReentrantLock[5];
        for(int i = 0; i < 5; i++){
            forkLock[i] = new ReentrantLock();
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        forkLock[(philosopher + 1) % 5].lock();
        forkLock[philosopher].lock();
        pickLeftFork.run();
        pickRightFork.run();
        eatLimit.acquire();

        eat.run();

        putRightFork.run();
        putLeftFork.run();
        forkLock[(philosopher + 1) % 5].unlock();
        forkLock[philosopher].unlock();
        eatLimit.release();
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
