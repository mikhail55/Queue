import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyQueue<Integer> testQueue = new MyQueue<>();

        testQueue.add(5);
        testQueue.add(4);
        testQueue.add(9);
        testQueue.add(2);
        testQueue.add(8);
        testQueue.add(10);

        testQueue.sort();

        System.out.println(testQueue);

        //Creates a random queue to test the algorithm
        MyQueue<Integer> testQueue2 = new MyQueue<>();
        Random rand = new Random();
        for (int i = 0; i < rand.nextInt(10) + 7; i++){
            testQueue2.add(rand.nextInt(100));
        }
        testQueue2.sort();

        System.out.println(testQueue2);

        System.out.println();
        System.out.println();
    }
}
