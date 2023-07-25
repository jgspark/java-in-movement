package com.onejkspark.example.pattern.templatemethod.game;

public class DefaultGameConnectionHelper extends AbstGameConnectionHelper {
    @Override
    protected String doSecurity(String str) {
        System.out.println("강화된 알고리즘을 디코드작업");
        return str;
    }

    @Override
    protected boolean authentication(String id, String password) {
        System.out.println("아이디 암호 확인 과정");
        return true;
    }

    @Override
    protected int authorization(String userName) {
        System.out.println("권환 확인");
        System.out.println("유저의 나이를 가지고 와서 미성년자라면 10시 이후로 제한 , 성인일시 그냥 통과");
        return 0;
    }

    @Override
    protected String connection(String info) {
        System.out.println("접속단계");
        return info;
    }
}
