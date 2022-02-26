package com.gonzo.example.cabstract;

public abstract class Tv {

    private String serialNum;

    private int channel;

    abstract void upChannel();

    abstract void downChannel();

    abstract void callChannel();

    public Tv(String serialNum, int channel) {
        this.serialNum = serialNum;
        this.channel = channel;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

}
