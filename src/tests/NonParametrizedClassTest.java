package tests;
import main.comparators.Ascending;
import main.comparators.Descending;
import main.DynamicArray;
import org.junit.*;
import org.junit.runner.JUnitCore;

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
        DynamicArray<Integer> myArray = new DynamicArray<>();
        myArray.add(2);

        assertEquals(2,myArray.getValueByIndex(0).intValue());
    }

    @Test
    public void addTest2(){
        DynamicArray<Integer> myArray = new DynamicArray<>(15);
        myArray.add(2);
        myArray.add(3);
        myArray.add(4);

        assertEquals(4,myArray.getValueByIndex(2).intValue());
    }

    @Test
    public void addTest3(){
        Integer[] array = new Integer[10];
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        DynamicArray<Integer> myArray = new DynamicArray<>(array);

        assertEquals(3,myArray.getValueByIndex(2).intValue());
    }

    @Test
    public void insertTest(){
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
        Integer[] tmpArray = new Integer[]{1,2,3,4,5,6,7,8,9,10,11};
        DynamicArray myArray = new DynamicArray<>(tmpArray);
        myArray.clear();

        assertEquals(5,myArray.getArray().length);
    }
}


