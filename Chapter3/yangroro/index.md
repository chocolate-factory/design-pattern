# Chapter3. Creational Pattern

## Creational Pattern

### 생성패턴을 사용하는 이유
- 캡슐화
- 인스턴스들이 어떻게 맞물리는지를 완전히 가려준다
    - 인스턴스가 어떻게 생성되는지 언제 생성할 것인지에 대해 유연성을 확보할 수 있게 된다.
## 1. Abstract Factory(추상 팩토리)
### 의도
상세화된 서브 클래스를 정의하지 않고 서로 연관성이 있거나 독립적인 객체의 군을 생성하기 위한 인터페이스를 생성한다.

### 동기
사용자 인터페이스 툴킷을 보면 서로 다른 룩앤필을 가지고 있고 동작도 다르지만 이식성 확보를 위해서 각 위젯을 응용프로그램에서 직접 사용하지 못하게 한다.

### 활용성
- 객체가 생성되거나 구성 표현되는 방식과 무관하게 시스템을 독립적으로 만들때
- 여러 제품군중 하나를 선택해서 시스템을 설정하고 나중에 변경이 가능할때
- 관련된 제품객체들이 함께 쓰이도록 설계된 경우
- 제품에 대한 클래스 라이브러리를 제공하고 구현이 아닌 인터페이스를 노출하고 싶을때  

### 사용될법한 제품
주로 MS Office 제품군이나 Jetbrain 제품군같은 여러제품에서 공유하는 UI인터페이스가 있는 제품에 유용해보인다.

코드
```python
class MazeFactory:
    @staticmethod
    def make_maze():
        return Maze()
    @staticmethod
    def make_wall():
        return Wall()
    @staticmethod
    def make_room():
        return Room()
    @staticmethod
    def make_door(room1: Room, room2: Room):
        return Door(room1, room2)
        
def create_maze(factory: MazeFactory):
    maze = factory.make_maze()
    room1 = factory.make_room()
    room2 = factory.make_room()
    door = factory.make_door(room1, room2)
    
    maze.add_room(room1)
    maze.add_room(room2)
    
    return maze
```


## 2. Builder 패턴
### 의도 
복잡한 객체를 생성하는 방법과 표현하는 방법을 정의하는 클래스를 별도로 분리한다. 서로 다른 표현이라도 같은 절차를 통해 생성할 수 있도록 한다.

### 활용성
- 복합 객체의 생성알고리즘이 이를 합성하는 요소 객체들이 무엇인지 조립 방법에 독립적일때
- 합성할 객체의 표현이 다르더라도 생성절차에서 이를 지원해야할 때

코드
```python
class MazeBuilder:
    def __init__(self):
        self.maze = None
    def build_maze(self):
        self.maze = Maze()
    def build_room(self, room_number: int):
        self.maze.room[room_number] = Room()
    def build_door(self, room_number1, room_number2):
        room1 = self.room.get(room_number1)
        room2 = self.room.get(room_number2)
        self.maze.door = Door(room1, room2)
    def get_maze(self):
        return self.maze
```
