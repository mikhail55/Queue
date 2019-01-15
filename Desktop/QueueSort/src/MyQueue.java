/**
 * This class is used to create and manage a queue of objects
 * @param <E> E is any object
 * @author Mikhail Pyatakhin
 * @version 1.0
 * @since 2019-01-10
 */
public class MyQueue<E> {
    private int size;
    private MyNode head; //first node
    private MyNode tail; //last node

    public MyQueue(){
        size = 0;
    }

    /**
     * This method is used to add any object of set type to the queue to the end of it
     * @param obj element that will be added to the queue
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

    /**
     * This method is used to remove and return the next element from the queue
     * @return returns the next element just removed from the queue
     */
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

    /**
     * Just returns the element of the queue without removing it
     * @return returns the next element in the queue
     */
    public E peek(){
        return head.getData();
    }

    /**
     * Returns the size of the queue
     * @return int representing the size of the queue
     */
    public int size() {
        return size;
    }

    /**This method sorts the queue in order from big to small
     */
    public void sort(){
        for (int i = 0; i < size; i++){
            E smallestNum = remove(); //assumes that the next number is the smallest
            for (int j = 0; j < size; j++) {
                E nextNum = remove();
                if ((Integer)smallestNum > (Integer) nextNum){ //compares the next number with the assumed smallest
                    add(smallestNum);
                    smallestNum = nextNum;
                } else {
                    add(nextNum);
                }
            }
            add(smallestNum);
        }
    }

    /**
     * Prints the queue in order
     * @return String returns a String representing the queue in order from big to small
     */
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

    /**
     * This class is used to store data and create a structure for the queue
     */
    private class MyNode{
        E data;
        MyNode nextNode;


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
