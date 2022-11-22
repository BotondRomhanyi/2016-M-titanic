package org.example;

public class Categories {
    public String name;
    public int survivor;
    public int missing;

    public Categories(String dataLine) {
        String[] Data = dataLine.split(";");
        this.name = Data[0];
        this.survivor = Integer.parseInt(Data[1]);
        this.missing = Integer.parseInt(Data[2]);
    }

}
