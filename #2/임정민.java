package problem2;
import java.util.ArrayList;
import java.util.List;
public class SolutionJM {
    /**
     * https://www.youtube.com/watch?v=IxrMbl1w4RA 영상 참고했습니다.
     *
     * 1. 제일 앞에 위치한 기능을 개발하는데 소요되는 날짜 계산
     * 2. 제일 앞의 기능과 함께 개발하여 배포할 수 있는 기능 계산
     */
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        int pointer = 0; // 앞에 기능 포인터
        //  [93, 30, 55]
        //  [1, 30, 5]
        for (int i = 0; i < progresses.length; i++) {
            // 날짜 계산
            int day = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);
            if (pointer >= day) {
                // 두번째 기능은 앞에 기능보다 일찍 끝남 같이 나갈 수 있으니 +1 [3, 1]
                list.set(list.size() - 1, list.get(list.size() - 1) + 1);
            } else {
                list.add(1); // 같이 배포할수없는 새로운 배포일이 오면 1추가
                pointer = day; // 포인터를 변환
            }
        }
        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray(); // 결과 배열 반환
    }
}
