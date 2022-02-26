package com.gonzo.example.cabstract;

public class Apple extends Tv {

    public Apple(String serialNum, int channel) {
        super(serialNum, channel);
    }

    @Override
    void upChannel() {
        int channel = this.getChannel() + 1;
        setChannel(channel);
    }

    @Override
    void downChannel() {
        int channel = this.getChannel() - 1;
        setChannel(channel);
    }

    @Override
    void callChannel() {
        System.out.println("Now Channel [" + this.getChannel() + "]");
    }
}
