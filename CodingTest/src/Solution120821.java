import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution120821 {
    // https://school.programmers.co.kr/learn/courses/30/lessons/120821
    public static void main(String[] args) {
        Solution120821 sol = new Solution120821();
        sol.solution2(new int[] {1, 2, 3, 4, 5});
        sol.solution2(new int[] {1, 1, 1, 1, 1, 2});
        sol.solution2(new int[] {1, 0, 1, 1, 1, 3, 5});
    }
    public int[] solution(int[] num_list) {
        List<Integer> numList = Arrays.stream(num_list)
                .boxed().collect(Collectors.toList());
        // int[] 데이터형을 ArrayList<Integer> 변환
        Collections.reverse(numList);
        // Java 에서 ArrayList의 원소를 역순 시킨다.
        System.out.println("Solution120821 : " + this.printArrayList(numList));
        int[] answer = numList.stream().mapToInt(Integer::intValue).toArray();
        // ArrayList<Integer> 데이터형을 int[] 배열 로 변환
        return answer;
    }
    public String printArrayList(List al) {
        Object result = al.stream() // List Stream
                .map(Object::toString)  // 각원소를 String 처리
                .reduce(
                ""  // 초기값
                , (first, second) // List 배열의 앞의 원소, 뒤의 원소
                -> {
                    return ("".equals(first.toString()) // 앞의원소가 "" 이면
                            ?
                            second.toString()
                            // 앞의원소가 "" 이면 뒤의 원소만 String 변환
                            :
                            first.toString() + ", " + second.toString());
                            // 앞의원소가 "" 아니면 앞의원소 + ", " + 뒤의 원소로 String 변환
                }
        );
        return result.toString();
    }
    public int[] solution2(int[] num_list) {
        int[] result = new int[num_list.length];
        // num_list 배열의 길이 만큼 result 배열의 길이를 생성한다.
        for ( int i = 0; i < num_list.length; i++ ) {
            // i => n-1, n-2, ... 3, 2, 1, 0;
            // j => 0, 1, 2, 3, ... n-2, n-1;
            result[i] = num_list[num_list.length - i - 1];
        }
        System.out.println("solution2 : " + this.printArrayList(result));
        return result;
    }
    public String printArrayList(int[] arr) {
        String result = ""; // 문자열 초기화
        for (int item : arr) {  // javascript : for (x of arr)
            result += item + ", ";  // 배열원소 0 ~ n 번째까지 문자열 연결
        }
        return result.substring(0, result.length() - 2);
        // 맨마지막 ", " 2글자 삭제해서 리턴
    }
}
