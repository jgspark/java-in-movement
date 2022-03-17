## 스레드의 상태

* wait()
* notify()
* notifyAll()

```text
    wait() 은 notify() or notifyAll() 이 호출될때 까지 기다림 
    매개변수가 있는 wait() 는 지정된 시간 까지만 기다린다.
```

- object에 정의가 되어 있다.
- 동기화 블록 (synchronized 블록) 내에서만 사용 가능
- 효율적인 동기화를 가능 


