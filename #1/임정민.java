package problem1;
import java.util.*;
public class SolutionJM {
    // 문제정리
    // 1부터 입력받은 n까지의 수를 스택에 넣고 pop하면서 입력받은 수열 만들기
    // push(+) pop(-) 연산 출력
    // 무조건 오름차순
    //      예). n이 8이고 1 2 3 4 5 6 7 8
    //           n이 5이고 1 2 5 3 4
    // 8 개의 숫자를 입력받고 4 3 6 8 7 5 2 1 저장
    // 스택에 오름차순으로 1부터 n까지의 숫자를 push(+)
    // push 할때마다 마지막에 들어간 값을 입력받은 수열과 비교해서 같으면 pop(-)
    // 1 2 5 3 4를 예시로
    // 스택에 1push 하고 수열과 같으니 pop
    // 스택에 2push 하고 수열과 같으니 pop
    // 스택에 3push 하고 수열과 다르니 패스  [3]
    // 스택에 4push 하고 수열과 다르니 패스  [3, 4]
    // 스택에 5push 하고 수열과 같으니 pop
    // 반복문이 끝나고 입력받은 수열을 못만들어 NO 출력
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        int index = 0;
        for (int i = 1; i <= n; i++) {
            stack.push(i);
            result.append("+\n");
            while (true) {
                if (!stack.isEmpty() && stack.peek() == array[index]) {
                    stack.pop();
                    result.append("-\n");
                    index++;
                } else break;
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("NO");
        } else {
            System.out.println(result);
        }
    }
}
