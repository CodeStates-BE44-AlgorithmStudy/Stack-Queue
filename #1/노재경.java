package problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class SolutionJK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> sequenceList = new ArrayList<>(); // 수열을 입력 받을 List
        Stack<Integer> stack = new Stack<>(); // 스택 수열 구현을 위한 스택
        List<String>operators = new ArrayList<>(); //최종 출력할 연산자들을 담을 List
        boolean isAnswer = true; // 스택 수열을 만들 수 있는지 확인할 boolean

        int count = sc.nextInt(); // 총 수열의 길이를 입력받는다. 결국 입력 횟수가 길이이기 때문에 count라고 변수명을 설정했다.

        for (int i = 0; i < count; i++) {   // 수열을 입력 받는다.
            sequenceList.add(sc.nextInt());
        }

        /**
         *   4 3 6 8 7 5 2 1
         *   1. 스택의 마지막 값이 수열의 첫 숫자가 될 때까지 스택에 숫자를 증가시켜 집어넣는다. (1, 2, 3, 4)
         *   2. 스택의 마지막 값이 수열의 첫 값과 일치하므로 스택에서 마지막 값을 빼고 수열의 첫 값을 제거한다.
         *    2-1. 제거한 뒤에도 2의 결과가 반복되면 이를 반복한다.
         *   3. 이 과정을 반복해 최종적으로 수열을 담은 List에 값이 없으면 스택 수열이 완성된 것이다.
         */

        int number = 1; // 스택에 들어갈 숫자
        while(sequenceList.size()!=0){ // 수열의 모든 숫자가 제거되면 수열이 완성된 것이다.
            if(stack.isEmpty()){ //스택이 비어있으면 일단 스택에 숫자를 집어넣고(+) 숫자 값을 1 증가시킨다.
                stack.add(number);
                operators.add("+");
                number++;
            }
            /**
             * 수열의 첫 번째 값과 스택의 마지막 값이 일치하면
             * 해당 값을 스택에서 pop하고(-) 수열에서도 제거시킨다.
             * 다음 값을 찾아야 하니 continue를 통해 이번 회차의 반복문을 벗어난다.
             * 만일 스택 수열의 첫 값이 1이여도 이 부분에서 걸러낼 수 있다.
             */
            if(sequenceList.get(0).equals(stack.peek())){
                stack.pop();
                sequenceList.remove(0);
                operators.add("-");
                continue;
            }
            /**
             * 아직 수열이 완성되지 않았는데(sequenceList에 남은 값 있음) 스택에 들어갈 값이 스택 길이를 초과하면
             * 스택 수열을 만들 수 없으므로 isAnswer를 false로 바꾸고 반복문을 break 한다.
             */
            if(sequenceList.size()!=0&&number>count){
                isAnswer=false;
                break;
            }
            /**
             * 스택의 마지막 값이 수열의 첫 번째 값과 다르면
             * 스택에 숫자를 집어넣고(+) 숫자를 1 증가시킨다.
             */
            stack.push(number);
            number++;
            operators.add("+");
        }

        if(!isAnswer){ //정답이 아니면 NO를 출력한다.
            System.out.println("NO");
        }
        else{ //정답이면 연산자들을 출력한다.
            for(String operator : operators){
                System.out.println(operator);
            }
        }
    }
}
