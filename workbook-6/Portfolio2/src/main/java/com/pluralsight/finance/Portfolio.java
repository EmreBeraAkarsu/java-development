package com.pluralsight.finance;

import java.util.List;

public class Portfolio {

    private String name;
    private String owner;
    private List<Valuable> assets;

    public Portfolio(String name, String owner) {
        this.name = name;
        this.owner = owner;
    }

    public void add(Valuable asset){


    }

    public double getValue(){

        double value = 0;
        for (Valuable asset : assets) {
            value += asset.getValue();
        }
        return value;
    }

    public Valuable getMostValuable(){

        Valuable maxValuable = null;

        for (Valuable asset : assets) {
            if (asset.getValue() > maxValuable.getValue()){
                maxValuable = asset;
            }
        }
        return maxValuable;
    }

    public Valuable getLeastValuable(){

        Valuable minValuable = null;

        for (Valuable asset : assets) {
            if (asset.getValue() < minValuable.getValue()){
                minValuable = asset;
            }
        }
        return minValuable;

    }
}
