package tests;
import main.DynamicArray;
import org.junit.*;
import org.junit.runner.JUnitCore;

import static org.junit.Assert.assertEquals;

public class TestingClass {
    public static void main(String[] args) {
        JUnitCore core = new JUnitCore();
        core.addListener(new TestListener());
        core.run(TestingClass.class);
    }

    @BeforeClass
    public static void allTestsStarted() {
        System.out.println("All tests started");
    }

    @AfterClass
    public static void allTestsFinished() {
        System.out.println("All tests finished");
    }

    @Test
    public void addTest(){
        DynamicArray myArray = new DynamicArray();
        myArray.add(2);

        assertEquals(2,myArray.getValueByIndex(0));
    }

    @Test
    public void addTest2(){
        DynamicArray myArray = new DynamicArray(15);
        myArray.add(2);
        myArray.add(3);
        myArray.add(4);

        assertEquals(4,myArray.getValueByIndex(2));
    }

    @Test
    public void addTest3(){
        int[] array = new int[10];
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        DynamicArray myArray = new DynamicArray(array);

        assertEquals(3,myArray.getValueByIndex(2));
    }

    @Test
    public void insertTest(){
        DynamicArray myArray = new DynamicArray(15);
        myArray.add(2);
        myArray.add(3);
        myArray.add(4);
        myArray.add(5);
        myArray.insert(3,14);

        assertEquals(14,myArray.getValueByIndex(2));
    }

    @Test
    public void insertTest2(){
        DynamicArray myArray = new DynamicArray(10);
        myArray.add(2);
        myArray.add(3);
        myArray.add(4);
        myArray.add(5);
        myArray.insert(20,14);

        assertEquals(14,myArray.getValueByIndex(4));
    }

    @Test
    public void deleteTest(){
        DynamicArray myArray = new DynamicArray(15);
        myArray.add(2);
        myArray.add(3);
        myArray.add(4);
        myArray.add(5);
        myArray.delete(3);

        assertEquals(5,myArray.getValueByIndex(2));
    }

    @Test
    public void extendTest(){
        DynamicArray myArray = new DynamicArray(5);
        myArray.add(1);
        myArray.add(2);
        myArray.add(3);
        myArray.add(4);
        myArray.add(5);
        myArray.add(6);
        myArray.add(7);

        assertEquals(7,myArray.getValueByIndex(6));
    }
}


