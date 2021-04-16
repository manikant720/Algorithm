package com.bookstoremanager;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Searching {
    public ArrayList<LinkedHashMap<String,String>>
    search(ArrayList<LinkedHashMap<String,String>> searchFrom,
           String bookName, String bookPublisher,
           String publishedDate){
        ArrayList<LinkedHashMap<String,String>> searchResult = new ArrayList<>();

        if(!bookName.equals("")){
            searchResult.addAll(searchByBookName(searchFrom,bookName));
        }

        if(!bookPublisher.equals("")){
            searchResult.addAll(searchByBookPublisher(searchFrom,bookPublisher));
        }

        if(!publishedDate.equals("")){
            searchResult.addAll(searchByPublishedDate(searchFrom,publishedDate));
        }

        return searchResult;
    }

    public ArrayList<LinkedHashMap<String,String>>
    searchByBookName(
            ArrayList<LinkedHashMap<String,String>> searchFrom, String bookName)
    {
        return  searchByKey(searchFrom, "Book Name", bookName);
    }

    public ArrayList<LinkedHashMap<String,String>>
    searchByBookPublisher(
            ArrayList<LinkedHashMap<String,String>> searchFrom, String bookPublisher)
    {
        return  searchByKey(searchFrom, "Book Publisher", bookPublisher);
    }

    public ArrayList<LinkedHashMap<String,String>>
    searchByPublishedDate(
            ArrayList<LinkedHashMap<String,String>> searchFrom, String publishedDate)
    {
        return  searchByKey(searchFrom, "Published Date", publishedDate);
    }


    public ArrayList<LinkedHashMap<String,String>>
    searchByKey(
            ArrayList<LinkedHashMap<String,String>> searchFrom, String searchHashKey, String key
    ){
        ArrayList<LinkedHashMap<String,String>> searchResult = new ArrayList<>();

        for(int i=0; i < searchFrom.size(); i++){
            LinkedHashMap tempHashMap = searchFrom.get(i);
            if(tempHashMap.get(searchHashKey).equals(key)){
                searchResult.add(tempHashMap);
            }
        }

        return  searchResult;
    }


}
