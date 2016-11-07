package main;

import java.util.Iterator;
import java.util.NoSuchElementException;

class DynamicArrayIterator<T> implements Iterator<T> {

    private DynamicArray<T> array;
    private int index;

    public DynamicArrayIterator(DynamicArray<T> arr){
        index = 0;
        this.array = arr;
    }
    @Override
    public boolean hasNext() {
        return array.getLength()!=index;
    }

    @Override
    public T next() {
        if(hasNext()) {
            return array.getValueByIndex(index++);
        } else {
            throw new NoSuchElementException("You have reached the end of the array (" + array.getLength()+" index.");
        }
    }
}