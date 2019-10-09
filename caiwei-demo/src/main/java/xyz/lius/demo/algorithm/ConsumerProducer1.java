package xyz.lius.demo.algorithm;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 *
 * 使用“生产者-消费者模式”编写代码实现：线程A随机间隔（10~200ms）按顺序生成1到100的数字（共100个），
 * 放到某个队列中.3个线程B、C、D即时消费这些数据，线程B打印（向控制台）所有被2整除的数，
 * 线程C打印被3整除的数，线程D打印其它数据，要求数字的打印是有序的（从1到100）
 * 限时40分钟，可以使用IDE及第三方类库
 *
 */
public class ConsumerProducer1 {
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingDeque<>(100);

        xyz.lius.demo.algorithm.alibaba.ProducerA producerA = new xyz.lius.demo.algorithm.alibaba.ProducerA(blockingQueue);

        xyz.lius.demo.algorithm.alibaba.ConsumerB consumerB = new xyz.lius.demo.algorithm.alibaba.ConsumerB(blockingQueue);
        xyz.lius.demo.algorithm.alibaba.ConsumerC consumerC = new xyz.lius.demo.algorithm.alibaba.ConsumerC(blockingQueue);
        xyz.lius.demo.algorithm.alibaba.ConsumerD consumerD = new xyz.lius.demo.algorithm.alibaba.ConsumerD(blockingQueue);

        new Thread(producerA).start();

        new Thread(consumerB).start();
        new Thread(consumerC).start();
        new Thread(consumerD).start();


    }


}


class ProducerA implements Runnable {
    BlockingQueue<Integer> blockingQueue;

    public ProducerA(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run() {
        for (int i = 1; i < 100; i++) {
            try {
                blockingQueue.put(i);
                Thread.sleep((long) Math.floor(10 + Math.random()* 191));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ConsumerB implements Runnable {
    BlockingQueue<Integer> blockingQueue;

    public ConsumerB(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run() {
        while (true) {
            try {
                Integer ele = blockingQueue.take();
                if (ele % 2 == 0) {
                    System.out.println(ele);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}

class ConsumerC implements Runnable {
    BlockingQueue<Integer> blockingQueue;

    public ConsumerC(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run() {
        while (true) {
            try {
                Integer ele = blockingQueue.take();
                if (ele % 3 == 0) {
                    System.out.println(ele);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}

class ConsumerD implements Runnable{
    BlockingQueue<Integer> blockingQueue;

    public ConsumerD(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run() {
        while (true) {
            try {
                Integer ele = blockingQueue.take();
                if (ele % 2 != 0 && ele % 3 != 0) {
                    System.out.println(ele);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
