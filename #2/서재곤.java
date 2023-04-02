package problem2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class SolutionJK {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        System.out.println(Arrays.toString(new SolutionJK().solution(progresses, speeds)));
    }
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        // List<Integer> p = new ArrayList<Integer>(Arrays.asList(progresses)); 됐었는데 왜 안되는지 모르겠음,,
        List<Integer> p = new ArrayList<Integer>(Arrays.asList(Arrays.stream(progresses).boxed().toArray(Integer[]::new)));
        List<Integer> s = new ArrayList<Integer>(Arrays.asList(Arrays.stream(speeds).boxed().toArray(Integer[]::new)));
        int cnt = 0;
        while(!p.isEmpty()) {
            for(int i = 0; i < p.size(); i++) {
                p.set(i, p.get(i) + s.get(i));  // p.get(i)에 s.get(i)를 더한 값을 다시 p.get(i)에 넣음
            }
            // P.get(0)의 인덱스를 찾아서 100 이상일 때 제거하면 제거된 이후 인덱스의 값도 바로 비교할 수 있어서 한번에 Queue에서 출력할 수 있는 값을 찾을 수 있음
            // p.get(0)의 마지막 인덱스가 100 이상일 때 제거 후 다음 p.get(0)을 찾을 수 없어서 IndexOutOfBoundsException 발생하는 건가?
            // 그래서 !p.isEmpty()를 추가했더니 통과됨 -> while의 조건절이 따로 적용되기 때문에 !p.isEmpty()를 추가해야 함
            while(!p.isEmpty() && p.get(0) >= 100) {
                p.remove(0);
                s.remove(0);
                cnt++;
            }
            if(cnt != 0) {
                answer = Arrays.copyOf(answer, answer.length + 1); // 배열의 길이를 1 늘림
                answer[answer.length - 1] = cnt; // 마지막 인덱스에 cnt를 넣음
                cnt = 0; // cnt 초기화 -> 다음 Queue의 출력를 위해
            }
        }
        return answer;
    }
}
