package main;

import java.util.Comparator;


public class DynamicArray {
    final static int DEFAULT_SIZE = 5;
    private int currentCount;
    private int[] array;

    public int getValueByIndex(int index){
        if(index>array.length-1){
            return 0;
        } else {
            return array[index];
        }
    }

    public int[] getArray(){
        return array;
    }

    public DynamicArray(int[] mas){
        array = mas;
        currentCount = mas.length;
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
        currentCount--;
        checkResizingOfArray();
    }

    public void quickSort(Comparator<Integer> comparator){
        int startIndex = 0;
        int endIndex = array.length - 1;
        doSort(startIndex, endIndex,comparator);
    }

    private void doSort(int start, int end,Comparator<Integer> comparator) {
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
                int temp = array[i];
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
        int[] tmpArray = new int[array.length*3/2];
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
        int[] tmpArray = new int[array.length*2/3];
        for(int i = 0; i < tmpArray.length;i++){
            tmpArray[i]=array[i];
        }
        array = null;
        array = tmpArray;
    }

    public void clear(){
        int[] tmpArray = new int[DEFAULT_SIZE];
        array = null;
        array = tmpArray;
    }
}
