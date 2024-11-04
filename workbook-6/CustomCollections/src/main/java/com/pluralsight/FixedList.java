package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class FixedList<T>{
    private List<T> items;
    private int maxSize;


    public FixedList(int maxSize) {
        this.maxSize = maxSize;
        this.items = new ArrayList<>();
    }

    public void add(T item){
        if (items.size() < maxSize){
            items.add(item);
        }else {

            System.out.println("Cannot add more items!");
        }

    }

    public List<T> getItems(){

        return items;
    }
}
