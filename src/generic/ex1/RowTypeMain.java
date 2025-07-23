package generic.ex1;

public class RowTypeMain {
    public static void main(String[] args) {
        GenericBox integerBox = new GenericBox();
//        GenericBox<Integer> integerBox = new GenericBox<>(); // 권장
        integerBox.set(10); // 이건 매개변수가 Object형이야
        Integer integer = (Integer) integerBox.get();
        System.out.println("integer = " + integer);
    }

    /**
     * 제네릭 타입을 사용할 때는 항상 <>를 사용해서 사용 시점에 원하는 타입을 지정해야 한다.
     * 그런데 다음과 같이 <>을 지정하지 않을 수 있는데, 이런 것을 로 타입(row type), 또는 원시 타입이라 한다.
     * 원시 타입을 사용하며 내부의 타입 매개변수가 Object로 사용된다고 이해하면 된다.

     * 과거 자바 코드와 호환되기 위해 어쩔 수 없이 이런 로 타입을 지원하는 거다. 사용하지 말자.
     */
}
