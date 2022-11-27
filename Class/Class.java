package Class;

public class Class {
    public static void main(String[] args) {
        example1();
        example2();
        example3();
        example4();
        example5();
        example6();
    }
    public static void example1() {
        // new 클래스() 형태로 인스턴스 생성
        // 클래스 -> 설계도
        // 인스턴스 -> 클래스를 사용해서 만든 객체
        // 1. 클래스 설계, 2. 인스턴스 생성, 3. 인스턴스 이용
        // 인스턴스는 힙 영역에 생성되며 클래스 변수는 인스턴스의 주소값을 가지고 있음

        // Student 클래스와 같은 패키지 내에 존재하기 때문에 객체 생성 가능
        // s1 은 Student 객체의 주소값을 가짐
        Student s1 = new Student();
        System.out.println("s1 변수가 Student 객체를 참조합니다.");

        // s2 는 다른 Student 객체의 주소값을 가짐
        Student s2 = new Student();
        System.out.println("s2 변수가 또 다른 Student 객체를 참조합니다.");
        System.out.println();
    }
    public static void example2() {
        // 필드(클래스 멤버 변수)
        // 필드는 객체의 고유 데이터, 객체가 가져야 할 부품, 객체의 현재 상태 데이터를 저장
        // 필드는 어디에 위치해도 상관없지만 메서드, 생성자 내부는 안됨
        // 타입 필드명 형태로 필드 선언. 초기화 가능
        // 초기값이 없을 시 타입의 기본값으로 초기화
        // 클래스 내부 생성자나 메서드에선 필드 접근 가능
        // 클래스 외부에선 반드시 인스턴스를 생성한 후에 필드 접근 가능
        // 인스턴스를 생성해야 필드, 생성자, 메서드가 존재하기 때문
        // 클래스변수.필드 로 필드를 불러올 수 있음
        // .(도트 연산자) -> 객체 접근 연산자. 객체가 가지고 있는 필드나 메서드를 사용할 때 사용

        // Car 클래스로 myCar 인스턴스 생성
        Car myCar = new Car();

        // 객체를 생성했기 때문에 필드, 메서드를 사용할 수 있음
        // 도트 연산자를 통해 객체의 필드 사용
        System.out.println("제작 회사 : " + myCar.company);
        System.out.println("모델명 : " + myCar.model);
        System.out.println("색깔 : " + myCar.color);
        System.out.println("최고 속도 : " + myCar.maxSpeed);
        System.out.println("현재 속도 : " + myCar.speed);

        // myCar 인스턴스의 speed 필드값 변경
        myCar.speed = 60;
        System.out.println("현재 속도 : " + myCar.speed);
        System.out.println();
    }
    public static void example3() {
        // 생성자
        // new 연산자와 함께 쓰이며 객체를 생성할 때 객체의 초기화를 담당
        // 생성자를 생략했을 때 기본 생성자를 추가
        // 생성자는 클래스 이름과 같으며 리턴 타입이 없음
        // 생성자를 명시적으로 선언했다면 기본 생성자 호출 불가능
        // 반드시 명시적으로 선언된 생성자로 호출해서 객체를 생성해야 함
        // 호출하면 외부의 값이 생성자 내부로 전달됨

        // 외부의 값들로 초기화를 하는 경우 외부의 값의 개수가 매번 다를수 있음
        // 하나의 생성자만으론 모든 객체를 생성할 수 없음
        // 따라서 매개변수 타입이나 매개변수 개수나 매개변수 순서가 다르면
        // 다른 생성자라고 인식 -> 생성자 오버로딩
        // 타입, 개수, 순서가 동일한데 매개변수 명만 다른건 생성자 오버로딩이 아님

        // 생성자 오버로딩을 많이 사용할수록 중복되는 코드가 발생할 가능성이 커짐
        // 매개변수의 개수만 다른 생성자일 경우가 대부분
        // 그래서 최대한 많은 필드를 초기화한 생성자 하나만 만든 후
        // 나머지 생성자는 그 생성자를 호출하는 방법을 사용
        // this() 코드를 통해 호출
        // this() 내부의 매개값은 호출되는 생성자의 매개 변수 타입에 맞게 제공해야함
        // 먼저 호출한 후에 원래 생성자로 돌아오는 과정이 있기 때문에
        // this() 코드는 항상 생성자 첫줄에 적어야 함

        Car2 mycar1 = new Car2();
        System.out.println(mycar1.company);
        System.out.println(mycar1.model);
        System.out.println(mycar1.color);
        System.out.println(mycar1.maxSpeed);
        System.out.println();

        Car2 mycar2 = new Car2("자가용");
        System.out.println(mycar2.company);
        System.out.println(mycar2.model);
        System.out.println(mycar2.color);
        System.out.println(mycar2.maxSpeed);
        System.out.println();

        Car2 mycar3 = new Car2("자가용", "빨강");
        System.out.println(mycar3.company);
        System.out.println(mycar3.model);
        System.out.println(mycar3.color);
        System.out.println(mycar3.maxSpeed);
        System.out.println();

        Car2 mycar4 = new Car2("택시", "검정", 200);
        System.out.println(mycar4.company);
        System.out.println(mycar4.model);
        System.out.println(mycar4.color);
        System.out.println(mycar4.maxSpeed);
        System.out.println();

    }
    public static void example4() {
        // 필드 초기화
        // 필드를 초기화 하는 방법은 두가지
        // 1. 필드를 선언할 때 초기값을 주는 방법
        // 2. 생성자를 통해서 초기값을 주는 방법
        // example2 같은 경우 1번 방법
        // 하지만 외부에서 들어오는 값들로 초기화를 해야한다면 2번 방법 사용
        // 필드를 선언한 후, 생성자를 호출할 때 들어오는 외부의 값을 받아 필드에 저장하면 됨
        Korean k1 = new Korean("홍석환", "000519-1234567");
        Korean k2 = new Korean("오지이", "010712-1234567");
        System.out.println(k1.name);
        System.out.println(k1.ssn);
        System.out.println();
        System.out.println(k2.name);
        System.out.println(k2.ssn);
        System.out.println();
    }
    public static void example5() {
        // 메서드
        // 메서드를 선언할때는 리턴 타입 메서드 이름(매개변수 이름...) {} 형태로 함
        // 리턴 타입은 없으면 void 있으면 타입을 적어줌
        // 리턴 타입이 있으면 반드시 return 문은 존재해야 함
        // 리턴값을 사용할 예정이라면 반드시 변수에 저장해야 함
        // 메서드 이름은 직관적으로 작성
        // 매개변수가 없으면 안 적어도 되지만 있으면 선언된 개수와 타입에 맞춰서 작성
        Calculator myCalc = new Calculator();
        myCalc.powerOn(); // 리턴 타입, 매개변수 X

        // 리턴 타입 int, 매개변수 타입 x -> int, y -> int
        // 따라서 int 형 변수에 리턴값 저장, 외부 값은 정수만 가능
        int result1 = myCalc.plus(5, 6);
        System.out.println(result1);

        // byte 형 값이 들어왔지만 byte 는 int 로 자동 형변환 되기 때문에 에러 없이 동작
        // 리턴 타입이 double 이라서 double 형 변수에 리턴값 저장
        byte x = 10;
        byte y= 4;
        double result2 = myCalc.divide(x, y);
        System.out.println(result2);

        myCalc.powerOff(); // 리턴 타입, 매개 변수 X
    }
    public static void example6() {
        // 메서드 매개변수 개수
        // 매개변수의 개수를 고정해서 메서드를 선언하면 항상 같은 개수의 값만 받을수 있음
        // 하지만 값이 몇개 전달되는지 모르는 경우도 존재
        // 따라서 매개변수를 배열 타입으로 선언하는 방법이 있음
        // int[] value
        // 이 방법은 메서드를 호출하기 전에 배열을 선언해야하는 단점이 있음
        // ... 을 사용하게 되면 메서드를 호출할 때 전달된 값으로 배열을 생성
        // int ... values
        // 전달된 값이 배열로 만들어지기 때문에 배열을 전달해도 무관
        Calculator myCalc = new Calculator();

        int[] value1 = {1, 2, 3};
        int result1 = myCalc.sum1(value1);
        System.out.println(result1);

        int result2 = myCalc.sum1(new int[] {1, 2, 3, 4, 5});
        System.out.println(result2);

        int result3 = myCalc.sum2(1,2,3);
        System.out.println(result3);

        int result4 = myCalc.sum2(1,2,3,4,5);
        System.out.println(result4);
    }
}