import java.util.Scanner;

public final class AppView {
    // Java에서는 문법적으로 static class를 제공하지 않기 때문에 final을 이용하여 상속을 막아준다.
    // 이와 같이 final을 이용하여 static class(존재하지 않는 문법)을 생각했을때와 같은 효과를 낸다.

    private static Scanner scanner = new Scanner(System.in);
    // 입력을 받기 위한 Scanner 객체 선언 static으로 선언한다.

    private AppView(){}
    // 생성자는 private으로 선언한다. -> 다른 클래스에서 인스턴스 변수를 만들지 않기 위함.

    public static void outputLine(String aString){
        System.out.println(aString);
    }
    public static void output(String aString){
        System.out.print(aString);
    }
    // 다른 클래스에서 호출할때 객체를 생성하지 않는 Class 이므로 모든 함수들은 static 으로 선언된다.
}
