##Main package diagram:
```
@startuml
interface Comparator{

}
class main.comparators.Ascending{
public int compare (Integer value1, Integer value2);
}
class main.comparators.Descending{
public int compare (Integer value1, Integer value2);
}
Comparator <|-- main.comparators.Ascending

Comparator <|-- main.comparators.Descending

class main.DynamicArray {

private final static int DEFAULT_SIZE = 5;
private int currentCount = 0;
private int[] array;

public DynamicArray(int[] mas);
public DynamicArray(int count);
public DynamicArray();
public void add(int value);
public void insert(int position, int value);
private void insertion(int position,int value);
public void delete(int position);
public void clear();
public void quickSort(Comparator<Integer> comparator);
private void doSort(int start, int end,Comparator<Integer> comparator);
private void extendArray();
private void checkResizingOfArray();
private void reduceArray();
public int getValueByIndex(int index);
public int[] getArray();
}
@enduml
```

##Test package diagram:
```
@startuml
class test.TestListener{
public void testStarted(Description desc);
public void testFinished(Description desc);
public void testFailure(Failure fail);
}

RunListener <|-- test.TestListener

class test.ParametrizedClassTest{
private int value1;
private int value2;
private int res;
private boolean ascend;

public static void allTestsStarted();
public static void allTestsFinished();
public ParametrizedClassTest(int val1, int val2, int result, boolean ascending);
public static Collection<Object[]> data();
public void testComparator();
}


class test.NonParametrizedClassTest{
public static void main(String[] args);
public static void allTestsStarted();
public static void allTestsFinished();
public void addTest();
public void addTest2();
public void addTest3();
public void insertTest();
public void insertTest2();
public void deleteTest();
public void extendTest();
public void ascendSortTest();
public void descendSortTest();
public void reduceArrayTest();
public void clearTest();
}
@enduml
```

