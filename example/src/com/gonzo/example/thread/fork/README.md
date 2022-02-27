# Fork Join Pool

* Java7 에서 부터 지원하는 fork-join Pool 은 기본적으로 큰 업무를 작은 단위로 나누어 분배한다.
* 일을 한 후에 일을 취합하는 형태입니다.
* 분할 정복 알고리즘과 같은 형태를 띄는 점이 특징입니다.

<img width="616" alt="스크린샷 2022-02-27 오전 11 09 48" src="https://user-images.githubusercontent.com/53357210/155865524-5f2698dc-faa3-4769-8b7f-209f7bab38ae.png">

* fork-join Pool 의 경우 내부에 inbound queue 라는 편지함이 하나있다.
* 그걸 두고 일을 하기에는 벅차서 fork-join pool 의 경우 개별적으로 큐를 만들어 준다
* 하나의 작업을 보내면 인바운드 큐에서 누적이 되고 그걸 A, B 스레드가 가져다가 일을 처리를 한다.
* 각각의 스레드들의 하나의 큐를 가지고 있으며 자신의 큐의 작업이 없으면 다른 스레드의 큐에서 작업을 가지고 온다.
* 최대한 노는 스레드가 없게 하기 위한 알고리즘이다.

<img width="611" alt="스크린샷 2022-02-27 오전 11 21 35" src="https://user-images.githubusercontent.com/53357210/155865668-35547b7a-712c-4f2d-95ac-908247e761d1.png">

## 선언 과 사용법 

1. 기본적으로 Fork Join Pool 객체를 인스턴스로 하나 만들어 놓는다.
2. 인스턴스에 스래드 갯수를 인자로 넣어준다.
3. `invoke` 메소드를 통해서 task 또는 action 을 실행을 해준다.
4. `awaitTermination` 메소드를 선언을 해주나다. 기본적으로 선언된 시간이 지나게 경과 하면 false 를 아니면 true 를 반환 한다.

<img width="638" alt="스크린샷 2022-02-27 오전 11 31 53" src="https://user-images.githubusercontent.com/53357210/155865847-29dba88d-9ec2-4db3-9b17-446293344526.png">

<img width="612" alt="스크린샷 2022-02-27 오전 11 32 39" src="https://user-images.githubusercontent.com/53357210/155865851-12aa421e-cbcb-4e34-9680-ce0e00323950.png">

> **정리:** </br>
> awaitTermination </br>
> ForkJoinPool 클래스의 awaitTermination() 메서드는 종료 요청 후 종료 또는 매개 변수로 지정된 시간 초과를 기다리는 데 사용됩니다. </br>
> 프로그램이 종료될 때까지 시간 초과가 경과한다. </br>
> 커먼 풀로 호출될 때, 그것은 awaitQuiescence() 메소드 역할을 한다. </br>
> 실행기가 종료되면 true를 반환하고 시간 초과로 지정된 시간이 경과하면 false를 반환합니다. </br>

## RecursiveAction & RecursiveTask 

스레드의 병렬 처리를 위하여 RecursiveTask 와 RecursiveAction 을 사용을 한다. 

두가지 모드 병렬 처리 작업이 라는 공통점을 가지고 있지만 차이점이 존재를 한다. 

RecursiveAction 의 경우 단순하게 병렬 처리를 한다. return 값을 사용을 하지 않는다. 

그에 비해 RecursiveTask 의 경우 상속을 받을때 제네릭에 리턴 값을 선언을 해준다. 리턴 값을 가지고 

값을 합산 혹은 값을 반환하는 작업을 처리를 할 수 있다. 

<img width="442" alt="스크린샷 2022-02-27 오전 11 36 42" src="https://user-images.githubusercontent.com/53357210/155865937-4137b3fc-6b04-4339-aa78-05c0e55010ec.png">

선언 부에서 `invoke` 메소드 를 통해서 작업을 넣어주면 compute 메소드를 호출을 한다. 

이때 우리는 작업에 대한 분할을 해주어야 되기때문에 분할 조건을 넣어준다. 

RecursiveTask 으로 설명을 하자면 

<img width="789" alt="스크린샷 2022-02-27 오전 11 38 23" src="https://user-images.githubusercontent.com/53357210/155865981-579add2c-e701-4e66-b263-bd0a3e213d1e.png">

기본적인 메소드 흐름의 경우 

리스트를 분할 처리 하기 위해서 코드를 보면 100 개 초과일시 분할을 시키고 100 이하 일시 count 치는 로직을 구현을 해주었다. 

하지만 리스트 분할을 처리를 해주어야 하기 때문에 리스트 배열에 작업을 할당을 시켜주고 그후에 fork 로 다시 작업을 진행을 해준다. 

fork 가 끝나면 join 으로 작업을 다시 모야준다. 

<img width="508" alt="스크린샷 2022-02-27 오전 11 39 24" src="https://user-images.githubusercontent.com/53357210/155866029-34b4cebd-211e-42b3-967a-2a3756f95c0a.png">

분할의 경우 하나의 테스크는 2개로 만 쪼개지게 하였다. 1 -> 2 -> 4 -> 8  계속해서 n^2 만큼 조건에 부합하게 분할을 해준다. 

그렇기 때문에 하나의 테스크에 모든것을 분할 하는 것이 아니라 균등한 분할을 할 수 있다. 여기서 키포인트는 하나의 테스크의 큐가 없다면 다른 테스크의 큐에서 

작업을 자기고 간다는 점이다. 


RecursiveAction 의 경우 사실 RecursiveTask 와의 차이점은 위에서 언급했듯이 return 값 유무이다. 

<img width="781" alt="스크린샷 2022-02-27 오전 11 45 52" src="https://user-images.githubusercontent.com/53357210/155866081-b85669ce-f65b-4e12-82bc-cb41f8ce6f9d.png">

fork 만 선언을 해주고 join 은 하지 않는다 그만큼 join 을 안하기 때문에 task 의 비해 효율성은 높다고 할 수 있다. 


