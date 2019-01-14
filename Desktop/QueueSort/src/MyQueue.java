/**
 * This class is used to create and manage a queue of objects
 * @param <E> E is any object
 * @author Mikhail Pyatakhin
 * @version 1.0
 * @since 2019-01-10
 */
public class MyQueue<E> {
    private int size;
    private MyNode head;
    private MyNode tail;

    public MyQueue(){
        size = 0;
    }

    /**
     * This method is used to add any object of set type to the queue
     * @param obj
     */
    public void add(E obj){
        MyNode newNode = new MyNode(obj);

        if (size == 0){
            head = newNode;
            tail = newNode;
        } else {
            tail.setNextNode(newNode);
            tail = newNode;
        }
        size++;
    }

    public E remove(){
        if (size > 0) {

            E returnedData = head.getData();

            head = head.getNextNode();

            size--;

            return returnedData;
        } else
            System.err.println("There are no elements in the queue");
            return null;
    }

    public E peek(){
        return head.getData();
    }

    public int size() {
        return size;
    }

    /**
     *
     */
    public void sort(){
        for (int i = 0; i < size; i++){
            E biggestNum = remove();
            for (int j = 0; j < size; j++) {
                E nextNum = remove();
                if ((Integer)biggestNum < (Integer) nextNum){
                    add(biggestNum);
                    biggestNum = nextNum;
                } else {
                    add(nextNum);
                }
            }
            add(biggestNum);
        }
    }

    @Override
    public String toString() {
        MyNode currentNode = head;
        StringBuilder queue = new StringBuilder();
        queue.append("Queue(In order): ");
        for (int i = 0; i < size; i ++) {
            queue.append(currentNode.getData());
            queue.append(", ");
            currentNode = currentNode.getNextNode();
        }
        return queue.toString();
    }

    private class MyNode{
        E data;
        MyNode nextNode;
        boolean isSorted;

        MyNode(E data) {
            this.data = data;
        }

        MyNode getNextNode(){
            return nextNode;
        }

        void setNextNode(MyNode previous){
            nextNode = previous;
        }

        E getData(){
            return data;
        }

    }
}
