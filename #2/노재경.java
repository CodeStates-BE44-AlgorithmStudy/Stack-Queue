package problem2;

import java.util.ArrayList;
import java.util.List;

public class SolutionJK {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        List<Integer> result = new ArrayList<>(); // 결과를 담을 List
        List<Integer> pro = new ArrayList<>(); // 진행 정도를 담을 List -> 진행이 완료되면 값을 뺴야 하고, 진행에 따라 값을 변환하기 위해 List 사용
        List<Integer> spd = new ArrayList<>(); // 진행 속도를 담을 List -> 진행이 완료되면 값을 빼기 위해 List 사용

        for (int i = 0; i < progresses.length; i++) { // 결과를 제외한 각 List를 채워준다.
            pro.add(progresses[i]);
            spd.add(speeds[i]);
        }

        int cnt = 0;
        while (!pro.isEmpty()) { // 모든 progress가 끝나면 종료
            for (int i = 0; i < pro.size(); i++) { //각 progress에 speeds를 더해 진행시킨다.
                pro.set(i, pro.get(i) + spd.get(i));
            }
            /**
             * pro의 가장 앞 값이 100이상이면
             * pro와 spd의 가장 앞 값 제거 반복
             * 제거가 되면서 돌아가기 때문에 비었을 때 index out of bounds 예외 처리를 위해 !pro.isEmpty() 조건 추가
             */
            while (!pro.isEmpty() && pro.get(0) >= 100) {
                pro.remove(0);
                spd.remove(0);
                cnt++;
            }
            /**
             * 하나라도 빠졌으면 결과에 빠진 갯수 추가하고 0으로 초기화
             */
            if (cnt != 0) {
                result.add(cnt);
                cnt = 0;
            }
        }

        answer = result.stream().mapToInt(num -> num)
                .toArray();
        return answer;
    }
}
