package com.gonzo.example.pattern.templatemethod;

import com.gonzo.example.pattern.templatemethod.game.AbstGameConnectionHelper;
import com.gonzo.example.pattern.templatemethod.game.DefaultGameConnectionHelper;

public class Main {

    public static void main(String[] args) {
        AbstGameConnectionHelper helper = new DefaultGameConnectionHelper();
        helper.requestConnection("아이디 암호등 접속 정보");
    }
}
