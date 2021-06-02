import java.util.LinkedList;


public class LinkedStack implements IStackable  {
    private LinkedList<Integer> list = new LinkedList<Integer>();

    
    
    public int size() {
        return list.size();
    }


    public void push(int v) {
        list.addFirst(v);
    }

    public int pop() {
        return list.removeFirst();
    }

}
