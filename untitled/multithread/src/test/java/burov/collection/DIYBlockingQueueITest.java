package burov.collection;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class DIYBlockingQueueITest {

    public static final int ITEMS_TO_ADD = 10;
    public static final int DELAY = 500;
    private Random random = new Random();
    private BlockingQueue<Integer> testedInstance = new DIYBlockingQueue<>(3);
    private Thread producer;
    private Thread consumer;

    @Before
    public void setUpOfProducerAndConsumer() {
        producer = new Thread(produce(testedInstance, ITEMS_TO_ADD));
        consumer = new Thread(consumeWithDelay(testedInstance, ITEMS_TO_ADD, DELAY));
    }

    @Test()
    public void shouldConsumeAllValuesProducedByAnotherThread() throws InterruptedException {

        producer.start();
        consumer.start();
        producer.join();
        consumer.join();

        assertThat("Queue is not empty", testedInstance.size(), is(0));
    }

    private Runnable consumeWithDelay(final BlockingQueue<Integer> queue, final int consumerNumber, final int timeToWait) {

        return () -> {
            waitForFullQueue(timeToWait);
            int consumedValues = 0;
            while (consumerNumber != consumedValues) {

                waitForFullQueue(timeToWait);
                Integer consumedValue = consume(queue);
                System.out.println("Consumed value: " + consumedValue + ", queue size is " + queue.size());
                consumedValues++;
            }
        };
    }

    private Integer consume(BlockingQueue<Integer> queue) {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void waitForFullQueue(int timeInMillis) {
        try {
            Thread.sleep(timeInMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Runnable produce(final BlockingQueue<Integer> queue, int itemsToAdd) {

        return () -> IntStream.range(0, itemsToAdd).forEach(i -> putNextValue(queue));
    }

    private void putNextValue(BlockingQueue<Integer> queue) {
        try {
            queue.put(random.nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}