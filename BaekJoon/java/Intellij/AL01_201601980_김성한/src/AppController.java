public class AppController {

    public AppController(){}
    // AppController의 생성자

    public void run(){
        AppView.outputLine("<<< 그래프 만들기를 시작합니다 >>>");
        AppView.outputLine("");
        AppView.outputLine("<<< 그래프 만들기를 종료합니다 >>>");
    }
    // AppView가 final 클래스 이므로 객체를 생성할 필요가 없이 바로 AppView 클래스의 함수를 불러올 수 있다.


}
