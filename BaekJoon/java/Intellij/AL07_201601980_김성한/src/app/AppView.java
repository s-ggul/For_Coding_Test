package app;

import java.util.Scanner;

public final class AppView {
    // Java에서는 문법적으로 static class를 제공하지 않기 때문에 final을 이용하여 상속을 막아준다.
    // 이와 같이 final을 이용하여 static class(존재하지 않는 문법)을 생각했을때와 같은 효과를 낸다.

    private static Scanner scanner = new Scanner(System.in);
    // 입력을 받기 위한 Scanner 객체 선언 static으로 선언한다.

    private AppView() {
    }
    // 생성자는 private으로 선언한다. -> 다른 클래스에서 인스턴스 변수를 만들지 않기 위함.

    private static final boolean DEBUG_MODE = true;
    public static void outputDebugMessage(String aString){
        if(DEBUG_MODE){
            System.out.print(aString);
        }
    }

    public static int inputSourceVertex(){
        int sourceVertex;
        String scannedToken;
        while(true){
            AppView.output("? 출발 vertex를 입력하시오 : ");
            scannedToken = AppView.scanner.next();
            try{
                sourceVertex = Integer.parseInt(scannedToken);
                return sourceVertex;
            }
            catch(NumberFormatException e){
                AppView.outputLine("[오류] 출발 vertex 입력에 오류가 있습니다: "+scannedToken);
            }
        }
    }

    public static void outputLine(String aString) {
        System.out.println(aString);
    }

    public static void output(String aString) {
        System.out.print(aString);
    }
    // 다른 클래스에서 호출할때 객체를 생성하지 않는 Class 이므로 모든 함수들은 static 으로 선언된다.

    public static int inputNumberOfVertices() {
        int numberOfVertices;
        String scannedToken;
        while (true) {
            AppView.output("? vertex 수를 입력하시오. : ");
            scannedToken = AppView.scanner.next();
            try {// try - catch 블록
                numberOfVertices = Integer.parseInt(scannedToken);//Integer.parsrInt()를 통해 입력받은 String을 int 형태로 바꿔준다.
                return numberOfVertices;
            } catch (NumberFormatException e) {//예외 처리 구문 parseInt()에 의해 문자열을 int형으로 변환할 경우 입력값이 숫자로 이루어져 있지 않으면 예외처리문 실행.
                AppView.outputLine("(오류) Vertex 수 입력에 오류가 있습니다. : " + scannedToken);// int형으로 변환하기 전 값을 출력해준다.
            }
        }
    }

    public static int inputNumberOfEdges() {
        int numberOfEdges;
        String scannedToken;
        while (true) {
            AppView.output("? edge 수를 입력하시오. : ");
            scannedToken = AppView.scanner.next();
            try {// try - catch 블록
                numberOfEdges = Integer.parseInt(scannedToken);//Integer.parsrInt()를 통해 입력받은 String을 int 형태로 바꿔준다.
                return numberOfEdges;
            } catch (NumberFormatException e) {//예외 처리 구문 parseInt()에 의해 문자열을 int형으로 변환할 경우 입력값이 숫자로 이루어져 있지 않으면 예외처리문 실행.
                AppView.outputLine("(오류) edge 수 입력에 오류가 있습니다. : " + scannedToken);// int형으로 변환하기 전 값을 출력해준다.
            }
        }
    }

    public static int inputTailVertex() {
        int tailVertex;
        String scannedToken;
        while (true) {
            AppView.output("? tail vertex 를 입력하시오. : ");
            scannedToken = AppView.scanner.next();
            try {// try - catch 블록
                tailVertex = Integer.parseInt(scannedToken);//Integer.parsrInt()를 통해 입력받은 String을 int 형태로 바꿔준다.
                return tailVertex;
            } catch (NumberFormatException e) {//예외 처리 구문 parseInt()에 의해 문자열을 int형으로 변환할 경우 입력값이 숫자로 이루어져 있지 않으면 예외처리문 실행.
                AppView.outputLine("(오류) tail vertex 입력에 오류가 있습니다. : " + scannedToken);// int형으로 변환하기 전 값을 출력해준다.
            }
        }
    }

    public static int inputHeadVertex() {
        int headVertex;
        String scannedToken;
        while (true) {
            AppView.output("? head vertex 를 입력하시오. : ");
            scannedToken = AppView.scanner.next();
            try {
                headVertex = Integer.parseInt(scannedToken);//Integer.parsrInt()를 통해 입력받은 String을 int 형태로 바꿔준다.
                return headVertex;
            } catch (NumberFormatException e) {//예외 처리 구문 parseInt()에 의해 문자열을 int형으로 변환할 경우 입력값이 숫자로 이루어져 있지 않으면 예외처리문 실행.
                AppView.outputLine("(오류) head vertex 입력에 오류가 있습니다. : " + scannedToken);// int형으로 변환하기 전 값을 출력해준다.
            }
        }
    }
//간단히 설명하여 input 함수들은 함수명에 대응하는 변수특성에 맞는 정수를 입력받은 후 int형이면 반환하고 아니면 예외처리를 통해 오류를 출력한다.

    public static int inputCost() {
        int cost;
        String scannedToken;
        while (true) {
            AppView.output("? cost를 입력하시오 : ");
            scannedToken = AppView.scanner.next(); //String 타입으로 Cost를 입력받는다.
            try {
                cost = Integer.parseInt(scannedToken); // 입력받은 String을 int형으로 변환하여 cost에 할당한다.
                return cost;//cost를 반환한다.
            } catch (NumberFormatException e) { //예외처리구문 parseInt()에 의해 문자열을 int형으로 변환할 때 입력값이 숫자로 이루어져 있지 않으면 예외처리문을 실행한다.
                AppView.outputLine("[오류] cost 입력에 오류가 있습니다 : " + scannedToken);// String으로 입력된 값이 정수형이 아니면 오류를 출력
            }
        }
    }
}

