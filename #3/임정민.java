package problem3;

import java.util.PriorityQueue;

public class SolutionJM {

        /*스코빌 지수가 1인 음식과 2인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
    새로운 음식의 스코빌 지수 = 1 + (2 * 2) = 5
    가진 음식의 스코빌 지수 = [5, 3, 9, 10, 12]
    스코빌 지수가 3인 음식과 5인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
    새로운 음식의 스코빌 지수 = 3 + (5 * 2) = 13
    가진 음식의 스코빌 지수 = [13, 9, 10, 12]
    모든 음식의 스코빌 지수가 7 이상이 되었고 이때 섞은 횟수는 2회입니다.
    모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.*/


    // 스코빌 지수가 가장 낮은 것부터 섞어야 하기 때문에 우선순위 큐 사용(오름차순)
    // 예). 5 3 9 10 12, 10 입력받음
    // 우선순위 큐에 3 5 9 10 12 입력
    // 가장 낮은 스코빌 지수 두개를 섞고 큐에 입력(총 한번 섞음)  3 + (5 * 2) = 13
    // 9 10 12 13
    // 9는 10보다 작으니 9 + (10 * 2) = 29(총 두번 섞음)
    // 12 13 29
    // 모든 음식이 10보다 크니 break  총 두번 섞었으니 return 2
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i : scoville) {
            queue.offer(i);
        }

        while (true) {
            if (queue.peek() > K) {
                break;
            } else if (queue.size() < 2 && queue.peek() < K) {
                return -1;
            } else {
                queue.offer(queue.poll() + (queue.poll() * 2));
                answer++;
            }
        }

        return answer;
    }
}
