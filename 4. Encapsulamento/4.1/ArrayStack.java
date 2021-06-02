import java.util.ArrayList;


public class ArrayStack implements IStackable  {
    private ArrayList<Integer> lista = new ArrayList<Integer>();

    
    
    public int size() {
        return lista.size();
    }


    public void push(int v) {
        lista.add(v);
    }

    public int pop() {
        return lista.remove(lista.size() - 1);
    }

}
