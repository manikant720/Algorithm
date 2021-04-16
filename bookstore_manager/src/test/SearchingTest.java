package test;

import com.bookstoremanager.Searching;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class SearchingTest {

    // Should return result with designated publication name from searching
    @Test
    public void testPublicationNameSearching(){
        ArrayList<LinkedHashMap<String,String>> arrayList
                = new TestUtils().buildTestArrayList();

        ArrayList<LinkedHashMap<String,String>> expectedArrayList
                = new TestUtils().expectedPublicationSearchResult();

        ArrayList<LinkedHashMap<String,String>> actualArrayList
                = new Searching()
                .search(
                        arrayList,"",
                        "BK Books",
                        "");

        Assert.assertEquals(expectedArrayList, actualArrayList);

    }

    // Should return result with designated published year from searching
    @Test
    public void testPublishedYearSearching(){
        ArrayList<LinkedHashMap<String,String>> arrayList
                = new TestUtils().buildTestArrayList();

        ArrayList<LinkedHashMap<String,String>> expectedArrayList
                = new TestUtils().expectedPublishedYearSearchResult();

        ArrayList<LinkedHashMap<String,String>> actualArrayList
                = new Searching()
                .search(
                        arrayList,
                        "",
                        "",
                        "1949");

        Assert.assertEquals(expectedArrayList, actualArrayList);

    }

    // Should return designated book name result from searching
    @Test
    public void testBookNameSearching(){
        ArrayList<LinkedHashMap<String,String>> arrayList
                = new TestUtils().buildTestArrayList();

        ArrayList<LinkedHashMap<String,String>> expectedArrayList
                = new TestUtils().expectedBookNameSearchResult();

        ArrayList<LinkedHashMap<String,String>> actualArrayList
                = new Searching()
                .search(
                        arrayList,
                        "Summer love",
                        "",
                        "");

        Assert.assertEquals(expectedArrayList, actualArrayList);
    }

    // Should return blank array from searching
    @Test
    public void testFalseSearching(){
        ArrayList<LinkedHashMap<String,String>> arrayList
                = new TestUtils().buildTestArrayList();

        ArrayList<LinkedHashMap<String,String>> actualArrayList
                = new Searching()
                .search(
                        arrayList,
                        "Harry Potter",
                        "JK Rowling",
                        "2020");

        Assert.assertTrue(actualArrayList.isEmpty());
    }
}
