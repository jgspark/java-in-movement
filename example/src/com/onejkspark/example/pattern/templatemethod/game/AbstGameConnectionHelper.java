package com.onejkspark.example.pattern.templatemethod.game;

public abstract class AbstGameConnectionHelper {

    protected abstract String doSecurity(String str);

    protected abstract boolean authentication(String id, String password);

    protected abstract int authorization(String userName);

    protected abstract String connection(String info);

    public String requestConnection(String encodedInfo) {

        // 보안 작업 -> 암호화된 문자열을 복호화
        String decondedInfo = doSecurity(encodedInfo);

        String id = "aaa";

        String pwd = "1234";

        if (!authentication(id, pwd)) {
            throw new Error("암호 불일치");
        }

        String userName = "userName";

        switch (authorization(userName)) {
            case -1:
                throw new Error("셧다운");
            case 0:
                System.out.println("게임 매니저");
                break;
            case 1:
                System.out.println("유료 회원");
                break;
            case 2:
                System.out.println("무료 회원");
                break;
            case 3:
                System.out.println("권한 없음");
                break;
            default:
                System.out.println("기타 사항");
                break;
        }

        return connection(decondedInfo);
    }
}
