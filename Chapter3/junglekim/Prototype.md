# Prototype

## 의도
원형이 되는 인스턴스를 사용하여 생성할 객체의 종류를 명시하고, 인스턴스를 복사해서 새로운 객체를 만듭니다.

## 동기
그래픽 편집기 제작용 프레임워크를 사용해서 음악 제작 프로그램을 만든다고 가정해보자.
프레임워크에서 `Graphic`객체를 화면에 그리는 `GraphicTool`을 제공한다고 했을 때, 음악 제작에 사용되는 수 많은 음표들을 화면에 그리기 위해서는 `GraphicTool`의 서브클래스가 매우 많이 필요하다. 이때 객체의 합성을 이용해서 서브클래싱 문제를 해결하고 일반화되어있는 `GraphicTool`을 사용할 수 있게 된다.

## 활용성
1. 인스턴스화할 클래스를 런타임에 지정할 때
2. 제품 클래스 계통과 병렬적으로 만드는 팩토리 클래스를 피하고 싶을때
3. 클래스의 인스턴스들이 서로 다른 상태 조합중에 어느 하나일 때 (매번 상태 값을 셋팅해서 초기화 하는 것보다 간단하다.)

## 코드

``` python
import abc
import copy

class Clonable(abc.ABC):
  @abstractmethod
  def clone(self):
    pass

class PersonRecord(Clonable):
  def __init__(self, time):
    self.time = time
    
  def clone(self):
    return copy.deepcopy(self)
  
  def __str__(self):
    return "Person: %d" % (self.time)
    

class BikeRecord(Clonable):
  def __init__(self, time):
    self.time = time
    
  def clone(self):
    return copy.deepcopy(self)
  
  def __str__(self):
    return "Bike: %d" % (self.time)


class RecordFactory:
  def __init__(self):
    self._record_map = {
      'bike': BikeRecord(10),
      'person': PersonRecord(100),
    }
    
  def get_record(self, type):
    return self._record_map[type].clone()
```

## 느낀점
한번도 다뤄보지 못한 패턴이다. 책에서 설명하는 내용으로는 썩 와닿진 않아서 실제로 사용한 코드를 한번 보고싶다.
`javascript`의 Prototype은 이 Prototype인 건가?? 그렇다면 deepcopy가 아닌 Object 내부의 `__proto__` 값을 통해서 링크된 상위 Prototype을 참조하는데.. 흠.. shallow copy를 이용한 clone의 일종이라고 봐야하는 건가..?


## 참고
https://medium.com/@bluesh55/javascript-prototype-%EC%9D%B4%ED%95%B4%ED%95%98%EA%B8%B0-f8e67c286b67
