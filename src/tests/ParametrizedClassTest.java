package tests;

import main.comparators.Ascending;
import main.comparators.Descending;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParametrizedClassTest {

    private int value1;
    private int value2;
    private int res;
    private boolean ascend;

    public ParametrizedClassTest(int val1, int val2, int result, boolean ascending) {
        value1 = val1;
        value2 = val2;
        res = result;
        ascend = ascending;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { { 10 , 20, 1, true }, { 20, 10, -1, true }, { 20, 20, 0, true },
                { 10 , 20, -1, false }, { 20, 10, 1, false }, { 20, 20, 0, false }};
        return Arrays.asList(data);
    }

    @Test
    public void testComparator() {
        Comparator<Integer> testComp;
        if(ascend){
            testComp = new Ascending();
        } else {
            testComp = new Descending();
        }
        assertEquals(res, testComp.compare(value1, value2));
    }

    @BeforeClass
    public static void allTestsStarted() {
        System.out.println("All parametrized tests started");
    }

    @AfterClass
    public static void allTestsFinished() {
        System.out.println("All parametrized tests finished");
    }
}
