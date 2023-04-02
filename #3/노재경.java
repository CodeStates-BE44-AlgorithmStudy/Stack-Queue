package problem3;

import java.util.PriorityQueue;

public class SolutionJK {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        // 여러 값이 정렬되지 않고 섞여있는 배열에서 가장 낮은 값을 가장 효율적인 시간복잡도로 구할 수 있는 자료구조
        PriorityQueue<Integer> tmp = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) { // 우선순위 큐에 스코빌 값을 하나씩 넣어준다.
            tmp.add(scoville[i]);
        }

        /*
         * 큐에 원소가 두 개 이상 남아 있어야 한다 -> 섞을 수 있어야 한다.
         * 가장 낮은 스코빌 값이 K보다 작아야 한다.
         */
        while (tmp.size() > 1 && tmp.element() < K) {
            int a = tmp.poll(); //스코빌 값이 가장 작은 음식
            int b = tmp.poll(); // 스코빌 값이 두 번째로 작은 음식
            if (tmp.size() == 0) { //두 가지를 뽑았는데, 더 이상 음식이 남아있지 않으면 -> 마지막으로 석는 경우
                if (a + 2 * b >= K) {
                    return 1;
                }
                return -1;
            }
            tmp.add(a + 2 * b);
            answer++;
        }

        return answer;
    }
}
