package com.bookstoremanager;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Sorting {
    /**
     * The method bubble sorts the arraylist of hashmaps in
     * ascending order according to their id
     *
     * @param data - Unsorted array list
     * @return data - Sorted array list
     */
    public ArrayList<LinkedHashMap<String, String>>
    ascSortArrayListOfHashMap(ArrayList<LinkedHashMap<String, String>> data) {

        int arrayListLength = data.size();
        LinkedHashMap tempHashMap = new LinkedHashMap();
        for (int i = 0; i < (arrayListLength - 1); i++) {
            for (int j = 0; j < (arrayListLength - i - 1); j++) {
                // Sorting is done on the ids
                if (Integer.parseInt(data.get(j).get("Book Id"))
                        > Integer.parseInt(data.get(j + 1).get("Book Id"))) {
                    // Swap Elements
                    tempHashMap.putAll(data.get(j));
                    data.get(j).putAll(data.get(j+1));
                    data.get(j+1).putAll(tempHashMap);
                }
            }
        }

        return data;
    }

    /**
     * The method bubble sorts the arraylist of hashmaps
     * in descending order according to their id
     *
     * @param data - Unsorted array list
     * @return data - Sorted array list
     */
    public ArrayList<LinkedHashMap<String, String>>
    descSortArrayListOfHashMap(ArrayList<LinkedHashMap<String, String>> data) {

        int arrayListLength = data.size();
        LinkedHashMap tempHashMap = new LinkedHashMap();
        System.out.println(arrayListLength);
        for (int i = 0; i < (arrayListLength - 1); i++) {
            for (int j = 0; j < (arrayListLength - 1 - i); j++) {
                // Sorting is done on the ids
                if (Integer.parseInt(data.get(j).get("Book Id"))
                        < Integer.parseInt(data.get(j + 1).get("Book Id"))) {
                    // Swap Elements
                    tempHashMap.putAll(data.get(j));
                    data.get(j).putAll(data.get(j+1));
                    data.get(j+1).putAll(tempHashMap);
                }
            }
        }

        return data;
    }
}
