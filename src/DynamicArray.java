import java.util.Comparator;

/**
 * Created by gglcrash on 01.11.2016.
 */
public class DynamicArray {
    final static int DEFAULT_SIZE = 5;
    private int currentCount = 0;
    private int[] array;

    public int getCurrentCount(){
        return currentCount;
    }
    public void printArray(){
        for(int i = 0; i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public DynamicArray(int[] mas){
        array = mas;
        currentCount = checkCurrentCountOfElements(mas);
    }

    public DynamicArray(int count){
        array = new int[count];
        currentCount = 0;
    }

    public DynamicArray(){
        array = new int[DEFAULT_SIZE];
        currentCount = 0;
    }

    public void add(int value){
        if(currentCount==array.length) {
            extendArray();
        }
        currentCount++;
        array[currentCount-1] = value;

    }

    public void insert(int position, int value){
        if(currentCount==array.length) {
            extendArray();
        }
        currentCount++;
        insertion(position,value);

    }

    private void insertion(int position,int value){
        for(int i = currentCount-1; i>position-2;i--){
            array[i+1] = array[i];
        }
        array[position-1]=value;
    }

    public void delete(int position){
        for(int i = position-1; i<currentCount-1;i++){
            array[i] = array[i+1];
        }
        array[currentCount-1]=0;
    }

    public void sort(Comparator<Integer> comparator){

    }

    private int checkCurrentCountOfElements(int[] mas){
        int currCount = 0;
        for (int i:mas){
            if (i!=0){
                currCount++;
            }
        }
        return currCount;
    }

    private void extendArray(){
        int[] tmpArray = new int[array.length*3/2];
        for(int i = 0; i < array.length;i++){
            tmpArray[i]=array[i];
        }
        array = null;
        array = tmpArray;
    }
}
