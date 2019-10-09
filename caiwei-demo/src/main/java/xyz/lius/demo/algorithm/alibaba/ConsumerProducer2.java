package xyz.lius.demo.algorithm.alibaba;

import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 使用“生产者-消费者模式”编写代码实现：线程A随机间隔（10~200ms）按顺序生成1到100的数字（共100个），
 * 放到某个队列中.3个线程B、C、D即时消费这些数据，线程B打印（向控制台）所有被2整除的数，
 * 线程C打印被3整除的数，线程D打印其它数据，要求数字的打印是有序的（从1到100）
 * 限时40分钟，可以使用IDE及第三方类库
 *
 */
public class ConsumerProducer2 {

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>(100);
        Sync sync = new Sync(new ReentrantLock(), 0,
                new CyclicBarrier(3));

        ProducerA producerA = new ProducerA(array);

        ConsumerB consumerB = new ConsumerB(array, sync);
        ConsumerC consumerC = new ConsumerC(array);
        ConsumerD consumerD = new ConsumerD(array);

        new Thread(producerA).start();

        new Thread(consumerB).start();
        new Thread(consumerC).start();
        new Thread(consumerD).start();


    }


}


class ProducerA implements Runnable {
    ArrayList<Integer> array;

    public ProducerA(ArrayList<Integer> array) {
        this.array = array;
    }

    public void run() {
        for (int i = 1; i < 100; i++) {
            try {
                array.add(i);
                Thread.sleep((long) Math.floor(10 + Math.random()* 191));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ConsumerB implements Runnable {
    ArrayList<Integer> array;
    Sync sync;

    public ConsumerB(ArrayList<Integer> array, Sync sync) {
        this.array = array;
        this.sync = sync;
    }

    public void run() {
        while (true) {
            try {
                // 当前消费位置
                int stat = sync.getStat();
                Integer ele = array.get(stat);
                // 消费掉
                if (ele % 2 == 0) {
                    sync.setStat(stat++);
                    System.out.println(ele);
                }
                sync.getCyclicBarrier().await();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

}

class ConsumerC implements Runnable {
    ArrayList<Integer> array;

    public ConsumerC(ArrayList<Integer> array) {
        this.array = array;
    }

    public void run() {
        while (true) {
            try {
                Integer ele = array.get(0);
                if (ele % 3 == 0) {
                    System.out.println(ele);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}

class ConsumerD implements Runnable {
    ArrayList<Integer> array;

    public ConsumerD(ArrayList<Integer> array) {
        this.array = array;
    }

    public void run() {
        while (true) {
            try {
                Integer ele = array.get(0);
                if (ele % 2 != 0 && ele % 3 != 0) {
                    System.out.println(ele);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}

class Sync {
    private ReentrantLock lock;
    private volatile int stat;
    private CyclicBarrier cyclicBarrier;

    public Sync(ReentrantLock lock, int stat, CyclicBarrier cyclicBarrier) {
        this.lock = lock;
        this.stat = stat;
        this.cyclicBarrier = cyclicBarrier;
    }

    public ReentrantLock getLock() {
        return lock;
    }

    public void setLock(ReentrantLock lock) {
        this.lock = lock;
    }

    public int getStat() {
        return stat;
    }

    public void setStat(int stat) {
        this.stat = stat;
    }

    public CyclicBarrier getCyclicBarrier() {
        return cyclicBarrier;
    }

    public void setCyclicBarrier(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }
}
