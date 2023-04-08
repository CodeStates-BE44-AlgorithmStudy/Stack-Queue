import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SolutionHM {
    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> queue = new LinkedList<>(); //작업 일수 큐에 저장
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            if ((100 - progresses[i]) % speeds[i] == 0) {
                queue.add((100 - progresses[i]) / speeds[i]);
            } else {
                queue.add((100 - progresses[i]) / speeds[i] + 1);
            }
        }
        int qPoll = queue.poll(); // 앞에 먼저 나온 것
        int count = 1;

        while (!queue.isEmpty()) { // 큐가 빌 때까지 작업
            if (qPoll >= queue.peek()) {
                // 앞에 나온 것이 뒤에 나온 것보다 크거나 같으면 증가 그리고 queue.poll()
                count++;
                queue.poll();
            } else { // 아닐 시 count를 list에 추가하고 1로 초기화, qPoll = q.poll()
                list.add(count);
                count = 1;
                qPoll = queue.poll();
            }
        }
        list.add(count); // while 문 탈출 후 마지막 처리 count를 리스트에 추가

        int[] result = new int [list.size()]; // 리스트 사이즈 만큼 배열크기
        for (int i = 0; i < result.length; i++) { // list 출력
            result[i] = list.get(i);
        }
        return result;
    }
}
