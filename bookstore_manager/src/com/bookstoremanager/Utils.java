package com.bookstoremanager;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Utils {
    public ArrayList<String> getColumnName(LinkedHashMap<String, String> item) {
        ArrayList<String> columnArray = new ArrayList<String>();

        for (String key : item.keySet()) {
            columnArray.add(key);
        }

        return columnArray;
    }

    public ArrayList<ArrayList<String>> getAllColumnData(ArrayList<LinkedHashMap<String, String>> data) {
        ArrayList<ArrayList<String>> columnData = new ArrayList<>();

        for (int i = 0; i < data.toArray().length; i++) {
            LinkedHashMap<String, String> currentMap = data.get(i);
            ArrayList<String> tempArray = new ArrayList<>();

            for (String value : currentMap.values()) {
                tempArray.add(value);
            }
            columnData.add(tempArray);
        }

        return columnData;

    }

    public Object[] getObject(ArrayList<String> row) {
        String bookId = row.get(0);
        String bookName = row.get(1);
        String bookAuthor = row.get(2);
        String bookGenre = row.get(3);
        String publishedYear = row.get(4);

        Object[] data = {bookId, bookName, bookAuthor, bookGenre, publishedYear};

        return data;
    }
}
