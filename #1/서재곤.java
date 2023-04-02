package problem1;
import java.util.Scanner;
import java.util.Stack;
public class SolutionJK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder(); // 출력할 문자열
        Stack<Integer> stack = new Stack<>(); // 스택
        int count = sc.nextInt();   // 길이 설정
        for (int i = 0; i < count; i++) {
            sb.append(sc.nextInt());   // 입력받은 수를 sb에 저장
        }
        // sb의 첫번째 수를 꺼내서
        int num = Character.getNumericValue(sb.charAt(0)); // sb의 문자를 숫자로 변환
        // 그 수만큼 +를 출력할 result에 저장하고 스택에 넣음
        for(int i = 0; i < num; i++) {
            // 첫번째 수는 그냥 stack에 추가
            stack.push(i);
            result.append("+\n");
            if(i == num) {
                stack.pop();
                result.append("-\n");
            }
        }
        System.out.println(result);
    }
}
