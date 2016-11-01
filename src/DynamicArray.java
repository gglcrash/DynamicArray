/**
 * Created by gglcrash on 01.11.2016.
 */
public class DynamicArray {
    final static int DEFAULT_SIZE = 5;
    private int[] array;

    public DynamicArray(int[] mas){
        array = mas;
    }

    public DynamicArray(int count){
        array = new int[count];
    }

    public DynamicArray(){
        array = new int[DEFAULT_SIZE];
    }
}
