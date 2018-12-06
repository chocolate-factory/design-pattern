# Chapter3. Creational Pattern

## Creational Pattern

- 인스턴스를 만드는 절차를 추상화하는 패턴.
- 무엇이 생성되고, 누가 생성하고, 어떻게 생성 되는지, 언제 생성 할 것인지 결정하는데에 대한 유연성을 확보 할 수있다.
- 어떤 한 객체가 다른 요소들과의 연관 관계를 가질 때, 유연성을 확보 할 수있다.

## 1. Abstract Factory

## 언제 쓰냐?

- 상세화된 서브 클래스를 정의하지 않고도 서로 관련이 있거나 독립적인 여러 객체의 군을 생성하기 위한 인터페이스를 정의합니다.
- 객체가 생성되거나 구성 표현되는 방식과 무관하게 시스템을 독립적으로 만들고자 할 때
- 관련된 제품 객체들이 함께 사용되도록 설계 되었고 한번 구성한 제품을 다른 것으로 구성 하고자 할때
- 제품에 대한 클래스 라이브러리를 제공하고 그들의 구현이 아닌 인터페이스를 노출 시키고 싶을 때

## 장/단

- 구체적인 클래스를 분리 할 수있다.
    - 생성할 객체의 클래스를 제어할 수 있다. 제품 객체를 생성하는 과정과 책임을 캡슐화 한것
- 쉽게 대체 할 수 있게 한다.
    - 구체 팩토리의 클래스는 한번만 나타내기 때문에, 응용 프로그램이 사용할 구체 팩토리를 변경하는것은 쉽다.
- 새로운 종류의 제품을 제공하기가 어렵다
    - 생성되는 제품은 추상 팩토리가 생성할 수있는 제품 집합에만 고정되어있음.

## 구현 하면서 느낀 것

- 시그니쳐가 정말 명확해야 한다.
    - 제품 군의 인터페이스가 잘 도출된 상황에서 써야 효과적임.
    - 시그니쳐가 명확하지 않다면 상세 구현을 갈아 엎기에 큰 비용을 소모 할것같음.

## 2. Builder

- 객체를 생성하는 방법과 표현하는 방법을 분리한다.
- 서로 다른 표현이라도 생성할 수있는 동일한 절차(builder)를 제공한다.

- 복합 객체의 생성 로직 / 합성 하는 로직이 독립적 일 때
- 합성한 객체들의 표현이 서로 다르더라도 생성 절차에서 이를 지원 할때
- 제품마다 그 제품을 표현하는 방법이 달라서 공통적인 기본 클래스가 필요 없을 때

## 장/단

- 제품에 대한 내부 표현에 대해 자유로움
    - 어떤 요소에서 복합 되는지, 요소들의 표현방법이 무엇인지 가릴 수 있음
- 생성과 표현에 필요한 코드를 분리
    - 내부 구조를 정의한 클래스는 전혀 모른채, 빌더와의 상호작용들 통해 필요한 객체를 생성한다.

## 구현 하면서 느낀 것

- 복잡한 객체의 표현에 대해서 유연하게 대처 할 수 있다.
    - 객체를 정말 작은 원자 단위로 표현 해야..
    - Director를 적절한 단위로 설계하는것이 중요 할 것 같다.
    - builder의 depth가 깊어지면 알아보기 어렵게 될 듯.