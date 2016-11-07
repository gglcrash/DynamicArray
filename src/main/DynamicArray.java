package main;

import java.util.Comparator;


public class DynamicArray<T> {
    private final static int DEFAULT_SIZE = 5;
    private int currentCount;
    private T[] array;


    public DynamicArray(T[] mas){
        array = mas;
        currentCount = mas.length;
    }

    public DynamicArray(int count){
        array = (T[])new Object[count];
        currentCount = 0;
    }

    public DynamicArray(){
        array = (T[])new Object[DEFAULT_SIZE];
        currentCount = 0;
    }

    public void add(T value){
        if(currentCount==array.length) {
            extendArray();
        }
        currentCount++;
        array[currentCount-1] = value;

    }

    public void insert(int position, T value){
        if(position>array.length){
            add(value);
        }else {
            if(currentCount==array.length) {
                extendArray();
            }
            currentCount++;
            insertion(position,value);
        }
    }

    private void insertion(int position,T value){
        for(int i = currentCount-1; i>position-2;i--){
            array[i+1] = array[i];
        }
        array[position-1]=value;
    }

    public void delete(int position){
        for(int i = position-1; i<currentCount-1;i++){
            array[i] = array[i+1];
        }
        array[currentCount-1]=null;
        currentCount--;
        checkResizingOfArray();
    }

    public void clear(){
        T[] tmpArray = (T[])new Object[DEFAULT_SIZE];
        array = null;
        array = tmpArray;
    }

    public void quickSort(Comparator<T> comparator){
        int startIndex = 0;
        int endIndex = array.length - 1;
        doSort(startIndex, endIndex,comparator);
    }

    private void doSort(int start, int end,Comparator<T> comparator) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (comparator.compare(array[i],array[cur])!=-1)) {
                i++;
            }
            while (j > cur && (comparator.compare(array[cur],array[j])!=-1)) {
                j--;
            }
            if (i < j) {
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSort(start, cur,comparator);
        doSort(cur+1, end,comparator);
    }

    private void extendArray(){
        T[] tmpArray = (T[])new Object[array.length*3/2];
        for(int i = 0; i < array.length;i++){
            tmpArray[i]=array[i];
        }
        array = null;
        array = tmpArray;
    }

    private void checkResizingOfArray(){
        if(2*currentCount<array.length){
            reduceArray();
        }
    }

    private void reduceArray(){
        T[] tmpArray = (T[])new Object[array.length*2/3];
        for(int i = 0; i < tmpArray.length;i++){
            tmpArray[i]=array[i];
        }
        array = null;
        array = tmpArray;
    }

    public T getValueByIndex(int index){
        if(index>array.length-1){
            return null;
        } else {
            return array[index];
        }
    }

    public T[] getArray(){
        return array;
    }
}
