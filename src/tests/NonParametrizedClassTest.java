package tests;
import main.comparators.Ascending;
import main.comparators.Descending;
import main.DynamicArray;
import org.junit.*;
import org.junit.runner.JUnitCore;

import java.util.Iterator;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class NonParametrizedClassTest {

    public static void main(String[] args) {
        JUnitCore core = new JUnitCore();
        core.addListener(new TestListener());
        core.run(NonParametrizedClassTest.class);

        JUnitCore core2 = new JUnitCore();
        core2.addListener(new TestListener());
        core2.run(ParametrizedClassTest.class);
    }

    @BeforeClass
    public static void allTestsStarted() {
        System.out.println("All non-parametrized tests started");
    }

    @AfterClass
    public static void allTestsFinished() {
        System.out.println("All non-parametrized tests finished");
        System.out.println();
    }

    @Test
    public void addTest(){
        System.out.println("Add method test.\n"+"Add '2' into new empty array.");
        DynamicArray<Integer> myArray = new DynamicArray<>();
        myArray.add(2);

        assertEquals(2,myArray.getValueByIndex(0).intValue());
    }

    @Test
    public void addTest2(){
        System.out.println("Add method test.\n"+"Add '2,3,4' into new array of size 15.");
        DynamicArray<Integer> myArray = new DynamicArray<>(15);
        myArray.add(2);
        myArray.add(3);
        myArray.add(4);

        assertEquals(4,myArray.getValueByIndex(2).intValue());
    }

    @Test
    public void addTest3(){

        System.out.println("Add method test.\n"+"Create dynamic array from the existing array.");
        Integer[] array = new Integer[10];
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        DynamicArray<Integer> myArray = new DynamicArray<>(array);

        assertEquals(3,myArray.getValueByIndex(2).intValue());
    }

    @Test
    public void insertTest(){
        System.out.println("Insert method test.\n"+"Insert '14' into 3 position in the array.");
        DynamicArray<Integer> myArray = new DynamicArray<>(15);
        myArray.add(2);
        myArray.add(3);
        myArray.add(4);
        myArray.add(5);
        myArray.insert(3,14);

        assertEquals(14,myArray.getValueByIndex(2).intValue());
    }

    @Test
    public void insertTest2(){
        System.out.println("Add method test.\n"+"Insert '20' into position, that is greater than array length." +
                "excepting result - adding in the end of the array.");
        DynamicArray<Integer> myArray = new DynamicArray<>(10);
        myArray.add(2);
        myArray.add(3);
        myArray.add(4);
        myArray.add(5);
        myArray.insert(20,14);

        assertEquals(14,myArray.getValueByIndex(4).intValue());
    }

    @Test
    public void deleteTest(){

        System.out.println("Delete method test.\n"+"Delete value from 3 position in the array.");
        DynamicArray<Integer> myArray = new DynamicArray<>(15);
        myArray.add(2);
        myArray.add(3);
        myArray.add(4);
        myArray.add(5);
        myArray.delete(3);

        assertEquals(5,myArray.getValueByIndex(2).intValue());
    }

    @Test
    public void extendTest(){
        System.out.println("Extend array method test.\n"+"Adding 7 elements into array of size 5.");
        DynamicArray<Integer> myArray = new DynamicArray<>(5);
        myArray.add(1);
        myArray.add(2);
        myArray.add(3);
        myArray.add(4);
        myArray.add(5);
        myArray.add(6);
        myArray.add(7);

        assertEquals(7,myArray.getValueByIndex(6).intValue());
    }

    @Test
    public void ascendSortTest(){
        System.out.println("Ascend sort method test.\n"+"Ascending sort of the {6,3,7,2,5,4,1} array.");
        DynamicArray<Integer> myArray = new DynamicArray<>(7);
        myArray.add(6);
        myArray.add(3);
        myArray.add(7);
        myArray.add(2);
        myArray.add(5);
        myArray.add(4);
        myArray.add(1);
        myArray.quickSort(new Ascending());

        assertArrayEquals(new Integer[]{1,2,3,4,5,6,7}, myArray.getArray());
    }

    @Test
    public void descendSortTest(){
        System.out.println("Descend sort method test.\n"+"Descending sort of the {6,3,7,2,5,4,1} array.");
        DynamicArray<Integer> myArray = new DynamicArray<>(7);
        myArray.add(6);
        myArray.add(3);
        myArray.add(7);
        myArray.add(2);
        myArray.add(5);
        myArray.add(4);
        myArray.add(1);
        myArray.quickSort(new Descending<Integer>());

        assertArrayEquals(new Integer[]{7,6,5,4,3,2,1}, myArray.getArray());
    }

    @Test
    public void reduceArrayTest(){
        System.out.println("Reduce array method test.\n"+"Deleting 5 elements from array of size 9.");
        Integer[] tmpArray = new Integer[]{1,2,3,4,5,6,7,8,9};
        DynamicArray myArray = new DynamicArray<>(tmpArray);
        myArray.delete(1);
        myArray.delete(2);
        myArray.delete(3);
        myArray.delete(4);
        myArray.delete(5);

        assertEquals(6,myArray.getArray().length);
    }

    @Test
    public void clearTest(){
        System.out.println("Clear method test.\n"+"Clearing of the existing dynamic array.");
        Integer[] tmpArray = new Integer[]{1,2,3,4,5,6,7,8,9,10,11};
        DynamicArray myArray = new DynamicArray<>(tmpArray);
        myArray.clear();

        assertEquals(5,myArray.getArray().length);
    }

    @Test
    public void iteratorTest(){
        System.out.println("Iterator method test.\n"+"Checking iterator of the dynamic array.");
        Integer[] tmpArray = new Integer[]{1,2,3,4,5,6,7,8,9,10,11};
        DynamicArray myArray = new DynamicArray<>(tmpArray);
        Iterator<Integer> iter =  myArray.iterator();
        Integer a = null;
        for(int i = 0; i<4; i++){
            a = iter.next();
        }
        assertEquals(4,a.intValue());
    }
}


