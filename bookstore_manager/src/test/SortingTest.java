package test;

import com.bookstoremanager.Sorting;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.LinkedHashMap;


public class SortingTest {

    ArrayList<LinkedHashMap<String, String>> testArrayListLinkedHashMap;

    @Test
    public void testAscendingSorting() {

        ArrayList<LinkedHashMap<String,String>> arrayList =
                new TestUtils().buildTestArrayList();

        new Sorting().ascSortArrayListOfHashMap(arrayList);

        ArrayList<LinkedHashMap<String,String>> expectedResult
                = new TestUtils().expectedAscending();

        Assert.assertEquals(expectedResult, arrayList);
    }

    @Test
    public void testDescendingSorting() {

        ArrayList<LinkedHashMap<String,String>> arrayList
                = new TestUtils().buildTestArrayList();

        new Sorting().descSortArrayListOfHashMap(arrayList);

        ArrayList<LinkedHashMap<String,String>> expectedResult
                = new TestUtils().expectedDescending();

        Assert.assertEquals(expectedResult, arrayList);
    }



}
