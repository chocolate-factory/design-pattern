# Singleton

## 의도
오직 한 개의 클래스 인스턴스를 갖도록 보장하고, 전역적으로 사용할 수 있게 제공한다.

## 동기
개발을 하다보면 어떤 클래스는 인스턴스를 한 개만 생성해야 할 때가 있다. `프린터 스풀`, `윈도우 관리자`, `파일 시스템` 등을 예로 들 수 있다.
단일 인스턴스의 생성과 그 인스턴스로의 접근을 클래스 스스로에게 위임하는 것이 가장 좋은 방법이다.

## 활용성
1. 클래스의 인스턴스가 오직 하나여야 함을 보장하고, access point를 통해 모든 사용자가 접근할 수 있또록 해야할 떄
2. 유일한 인스턴스가 서브클래싱으로 확장되어야 하며, 사용자는 코드의 수정 없이 서브클래스의 인스턴스를 사용할 수 있어야 할때

## 코드
1. 단독으로 사용하는 경우
``` python
class Singleton
  _instance = None
  
  def __new__(cls):
    # 사람들이 __init__가 객체를 생성하는 것으로 알고 있는데, __new__가 객체생성 __init__이 초기화다.
    # Singleton() Statement를 사용하면 __new__와 __init__이 순서대로 호출되는 것이다.
    if cls._instance is None:
       cls._instance = super().__new__(cls)
     
     return cls._instance
```

2. 서브 클래스를 사용하고 환경 변수로 단일 인스턴스를 조작하는 경우
``` python
import os

class Singleton:
  _instance = None
  
  def __new__(cls):
    if cls._instance is None:
      cls._instance = super().__new__(cls)
    return cls._instance
  
  @staticmethod
  def get_instance():
    # instance의 고유성은 각자의 __new__에서 보장
    singleton_type = os.environ.get('SINGLETON_TYPE')

    if singleton_type == 'SINGLETON_A':
      return SingletonA()
    else if singleton_type == 'SINGLETON_B':
      return SingletonB()
    else:
      return Singleton()
```

3. Pythonic Singleton
- 파이썬의 경우 한번 import한 패키지를 바이트코드로 컴파일하여 `sys.modules`에 캐싱해두기 때문에 아래의 코드의 경우 file2와 file3에서 출력하는 id가 같은 객체를 본다.

``` python
# file1.py
class _Singleton:
  pass
  
singleton = _Singleton()

# file2.py
from file1 import singleton
print(id(singleton))

# file3.py
from file1 import singleton
print(id(singleton))
```

## 느낀점
싱클톤을 종종 사용하긴 하지만 중요한건 정말 필요한 곳에 잘 사용하는 것다. 개발시 싱글톤을 대체 가능하고 그 비용이 크지 않다면 가능하면 안쓰는게 좋다.
싱글톤을 사용하면 전역변수의 Namespace문제는 어느정도 해결한다고는 하지만 마찬가지로 멀티쓰레딩환경에서의 안정성, 대규모 서비스에서의 객체간 커플링등 문제는 여전히 남는다고 생각한다. 추가로 진리의 케바케겠지만 레지스트리 방식을 사용해야하는 지는 잘 모르겠다. 이유는 위와 같다..
