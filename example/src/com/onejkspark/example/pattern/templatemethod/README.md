# 템플릿 메소드 패턴

## 목표 

```text
일정한 프로세스를 가진 요구사항을 템플릿 메소드 패턴을 이용해서 구현할 수 있다.
```

## 정의

```text
알고리즘의 `구조를 메소드로 정의` 하고 
하위 클래스에서 알고리즘의 구조를 변경없이 알고리즘을 `재정의` 하는 패턴 
```

## 언제?

* 구현하려는 알고리즘이 `일정한 프로세스` 가 있다
* 구현하려는 알고리즘이 `변경 가능성`이 있다

## 어떻게?

* 알고리즘을 `여러 단계` 로 나눈다.
* 나눠진 알고리즘의 단계를 `메소드로 선언` 한다.
* 알고리즘을 수행할 `템플릿 메소드` 를 만든다
* 하위 클래스에서 `나눠진 메소드들을 구현` 한다.

## 기본 설계

<img width="449" alt="스크린샷 2022-03-04 오후 10 44 32" src="https://user-images.githubusercontent.com/53357210/156774279-f5df982d-aa9b-4363-8280-f4cb3c452ad0.png">

## 요구 사항

* 신작 게임의 접속을 구현
    * requestConnection(String str):String
* 유저가 게임 접속시 다음을 고려하시오
    * 보안 과정: 보완 관련 부분을 처리
    * doSecurity(String str):String
    * 인증 과정: user name 과 password 가 일치하는지 확인
    * authentication(String id , String password) : boolean
    * 권환 과정: 점속자가 유로 회원인지 무료회원 인지 게임 마스터인지 확인
    * authorization(String userName) : int
    * 접속 과정: 접속자에게 커넥션 정보를 넘겨준다.
    * connection(String info):String

## 추가 요구 사항

* 보안 부분이 정부 정책에 의해서 강화 되었다. 강화된 방식으로 코드를 변경
* 여가부에서 밤 10시 이후에 접속이 제한 된다.
