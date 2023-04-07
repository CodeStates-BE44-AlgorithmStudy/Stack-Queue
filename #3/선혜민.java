import java.util.PriorityQueue;

public class SolutionHM {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> prQue = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            prQue.add(scoville[i]); // 스코빌 지수들 prQue에 add (순서대로))
        }

        while(prQue.peek() < K) {
            if (prQue.size() == 1) // 다 섞었음에도 스코빌 지수를 K 이상으로 만들 수 없는 경우
                return -1;
            else {
                prQue.add(prQue.poll() + prQue.poll()*2);
                answer++;
            }
        }
        return answer;
    }
}
