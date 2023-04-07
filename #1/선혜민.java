import java.util.Scanner;
import java.util.Stack;

public class SoutionHM {
    public static void main(String[] args) {
        // 스택 수열
        // 입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력
        // push연산은 +로, pop 연산은 -로 표현하도록, 불가능한 경우 NO를 출력

        Scanner sc = new Scanner(System.in);
        StringBuilder finalString = new StringBuilder(); // 긴 문자열을 더하는 상황에 StringBuilder 적합하다고 함

        int num = sc.nextInt(); //  >> 수열의 갯수를 받는 num
        int start = 0; // 첫 스택은 비어있음 = 0

        Stack<Integer> stackBox = new Stack<>();

        while (num --> 0){
            // 새로 알게된 사실 ! (var--(증감 연산자)); var > 0) 를 합치면, var --> 0으로 줄여 쓸 수 있다고 함 !!
            // 곧 num-- 으로 0보다 클때까지
            int input = sc.nextInt(); // 숫자 입력받아옴

            if (start < input) { // 받아온 숫자가 지금 스택의 크기보다 크다면
                for (int i = start + 1; i <= input; i++) { // 숫자의 크기까지 스택의 크기를 늘려줘야함 push !
                    stackBox.push(i); // input이 4일시 1,2,3,4 번 ++++ 하게됨 (4가 젤 위에 있게 됨)
                    finalString.append("+\n"); // 문자열을 저장하는 fianlString에 + 저장 (4번만큼 push했기에 '+'도 4번 출력
                }
                start = input;  // 늘려진 스택의 크기를 저장해야함 (4)
            }
            if(stackBox.peek() != input){  // 스택에 마지막 과 입력값된 값이 다르면 만들 수 없음
                // peek(): 가장 나중에 추가된 데이터를 리턴해야함
                finalString.delete(0,finalString.length()).append("NO");
                // .delete(int start, int end) 처음부터 문자길이 끝까지
                // .append(): "NO" 문자열을 추가
                break;
            }
            stackBox.pop(); // stackBox의 나중에 추가된 데이터를 삭제후 그 데이터를 리턴
            finalString.append("-\n"); // 문자열 - 추가
        }
        System.out.println(finalString);
    }
}
