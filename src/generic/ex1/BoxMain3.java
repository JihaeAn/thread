package generic.ex1;

public class BoxMain3 {
    public static void main(String[] args) {
        // 참조형만 가능함!

        GenericBox<Integer> integerBox = new GenericBox<Integer>();
        integerBox.set(10);
//        integerBox.set("문자 100"); // Integer 타입만 허용. 컴파일 오류
        Integer integer = integerBox.get();
        System.out.println("integer = " + integer);

        GenericBox<String> stringBox = new GenericBox<String>();
        stringBox.set("hello");
        String str = stringBox.get();
        System.out.println("str = " + str);

        // 원하는 모든 타입 사용 가능
        // 타입 추론: 생성하는 제네릭 타입 생략 가능
        GenericBox<Double> doubleBox = new GenericBox<>();
//        GenericBox<> doubleBox = new GenericBox<Double>(); // 이건 안 돼. 자바 컴파일러가 추론 가능해야함
        doubleBox.set(10.5);
        Double d = doubleBox.get();
        System.out.println("d = " + d);
    }
}
