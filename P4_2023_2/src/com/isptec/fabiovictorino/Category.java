package com.isptec.fabiovictorino;

public class Category {
    private static int time = 0;
    private static int prorrogation = 0;

    public Category(int i){
        if(i==0) {
            this.time = 1;
        }else{
            this.prorrogation = 1;
        }
    }

    public static int getTime() {
        return time;
    }
    public static int getProrrogation() {
        return prorrogation;
    }
    public int typeOfCategory(){
        return this.time == 1 ?  1 : 2;
    }
}
