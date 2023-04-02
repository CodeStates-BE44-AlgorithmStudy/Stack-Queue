package problem3;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
public class SolutionJK {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(solution(scoville, K));
    }
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        int s = 0;
        int cnt = 0;
        // 가장 작은값 두개를 뽑아야함. -> 정렬 후 인덱스 순서대로 연산가능
        Arrays.sort(scoville);
        // ArrayList -> 인덱스 삭제후 정렬, 삭제후 정렬, 추가 후 정렬 ->  메모리 효율성 떨어짐
        // LinkedList -> 인덱스 삭제후 정렬, 삭제후 정렬, 추가 후 정렬 -> 메모리 효율성 좋음 근데 효율성테스트와 테스트케이스 일부 통과불가..
        List<Integer> scov = new LinkedList<>(Arrays.stream(scoville).boxed().collect(Collectors.toList()));
        // 첫번째 인덱스가 K보다 작다면
        while(scov.get(0) < K) {
            // 가장 작은 값 두개의 연산이 K보다 작을때, scov의 길이가 2보다 작다면 -1을 리턴 -> 스코빌 지수를 K이상으로 만들 수 없음
            if(scov.size() < 2) {
                answer = -1;
                break;
            }
            // 가장 작은 값 두개 연산 후 min에 저장
            s = scov.get(0) + (scov.get(1) * 2);
            // 연산한 값이 K보다 크다면 cnt + 1을 리턴
            if(s >= K) {
                answer = ++cnt;
                break;
            } else {
            }
            // K보다 작다면 index 0, 1을 삭제
            scov.remove(0);
            scov.remove(0);
            // min을 index 0에 추가
            scov.add(s);
            cnt++;
        }
        return answer;
    }
}
