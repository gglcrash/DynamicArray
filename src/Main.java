/**
 * Created by gglcrash on 03.11.2016.
 */
public class Main {
    public static void main(String [ ] args)
    {

        int[] c = new int[10];
        c[0]=10;
        c[1]=9;
        c[2]=8;
        c[3]=7;
        c[4]=6;
        c[5]=5;
        c[6]=4;
        c[7]=3;
        c[8]=2;

        DynamicArray myArray = new DynamicArray(c);

        System.out.println(myArray.getCurrentCount());

        myArray.printArray();
        myArray.add(66);
        myArray.add(77);
        myArray.add(88);
        myArray.printArray();
        myArray.insert(8,12);
        myArray.printArray();
        myArray.delete(7);
        myArray.printArray();
    }
}
