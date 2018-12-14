
public class MyQueue<E> {
    int size;
    MyNode head;
    MyNode tail;

    public MyQueue(){
        size = 0;
    }

    public void add(E obj){
        MyNode newNode = new MyNode(obj);

        if (size == 0){
            head = newNode;
            tail = newNode;
        } else {
            tail.setNextNode(newNode);
            tail = newNode;
        }
    }

    public E remove(){
        if (size > 0) {

            E returnedData = head.getData();

            head = head.getNextNode();

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
