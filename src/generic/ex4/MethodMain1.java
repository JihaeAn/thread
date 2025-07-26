package generic.ex4;

public class MethodMain1 {

    /**
     * 제네릭 메서드는 인스턴스 메서드와 static 메서드에 모두 적용할 수 있다.

     * 💡참고
     * 제네릭 타입은 static 메서드에 타입 매개변수를 사용할 수 없다. 제네릭 타입은 객체를 생성하는 시점에 타입이 정해진다.
     * 그런데 static 메서드는 인스턴스 단위가 아니라 클래스 단위로 작동하기 때문에 제네릭 타입과는 무관하다.
     * 따라서 static 메서드에 제네릭을 도입하려면 제네릭 메서드를 사용해야 한다.
     */
    public static void main(String[] args) {
        Integer i = 10;
        Object object = GenericMethod.objectMethod(i);

        // 타입 인자(Type Argument) 명시적 전달
        System.out.println("명시적 타입 인자 전달");
        Integer result = GenericMethod.<Integer>genericMethod(i);
        Integer integerValue = GenericMethod.<Integer>numberMethod(10);
        Double doubleValue = GenericMethod.<Double>numberMethod(20.5);

        // 타입 인자 생략 가능 - 제네릭 메서드 타입 추론 가능
        System.out.println("타입 추론");
        Integer result1 = GenericMethod.genericMethod(i);
        Integer integerValue1 = GenericMethod.numberMethod(10);
        Double doubleValue1 = GenericMethod.numberMethod(20.5);
    }
}
