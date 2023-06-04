package com.jhhim99.myapplication;

public class Data {

    private static Data instance;

    private int total_Kal =0;
    private double total_carb=0; //탄수화물
    private double total_fat=0; //지방
    private double total_prot=0; //단백질


    //getter

    public int getTotal_Kal() {
        return total_Kal;
    }

    public double getTotal_carb() {
        return total_carb;
    }

    public double getTotal_fat() {
        return total_fat;
    }

    public double getTotal_prot() {
        return total_prot;
    }


    //setter


    public static void setInstance(Data instance) {
        Data.instance = instance;
    }

    public void setTotal_Kal(int total_Kal) {
        this.total_Kal = total_Kal;
    }

    public void setTotal_carb(double total_carb) {
        this.total_carb = total_carb;
    }

    public void setTotal_fat(double total_fat) {
        this.total_fat = total_fat;
    }

    public void setTotal_prot(double total_prot) {
        this.total_prot = total_prot;
    }

    private Data() {
        // Private constructor to prevent instantiation
    }

    public static synchronized Data getInstance() {
        if (instance == null) {
            instance = new Data();
        }
        return instance;
    }
}
