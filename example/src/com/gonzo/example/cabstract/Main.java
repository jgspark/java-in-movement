package com.gonzo.example.cabstract;

public class Main {

    public static void main(String[] args) {

        Tv tv = new Lg("LG01010", 1);

        tv.upChannel();

        tv.upChannel();

        tv.upChannel();

        tv.callChannel();

        Tv appleTv = new Apple("AP0010101", 100);

        appleTv.downChannel();
        appleTv.downChannel();
        appleTv.downChannel();

        appleTv.callChannel();
    }
}
