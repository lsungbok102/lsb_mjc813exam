import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution120825 {
    // https://school.programmers.co.kr/learn/courses/30/lessons/120825
    public static void main(String[] args) {
        Solution120825 sol = new Solution120825();
        String result = sol.solution2("hello", 3);
        System.out.println("Solution120825 : " + result);
    }
    public String solution(String my_string, int n) {
        String answer = "";
        for( int i = 0; i < my_string.length(); i++ ) {
            // 문자열을 한 글자씩 처리
            for( int j = 0; j < n; j++ ) {
                // 한글자를 n 번 출력
                answer += my_string.charAt(i);
            }
        }
        return answer;
    }
    public String solution2(String my_string, int n) {
        String[] array = this.getStringArray(my_string);
        List<String> list = Arrays.stream(array)
                .collect(Collectors.toList());
        // String 을 List<String> 데이터 형으로 변환
        String result = list
                .stream()   // List 데이터형에서 stream 을 사용
                .map(Object::toString)  // 각 원소를 문자열
                .reduce(""  // 초기값
                , (a, b) ->
                    a + b.repeat(n) //  한문장은 자동 리턴, 뒷글자의 * n번 출력
                );
        return result;
    }
    public String[] getStringArray(String str) {
        String[] array = new String[str.length()];
        for( int i = 0; i < str.length(); i++ ) {
            array[i] = str.charAt(i) + "";
        }
        return array;
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
    public String printArrayList(String[] arr) {
        String result = ""; // 문자열 초기화
        for (String item : arr) {  // javascript : for (x of arr)
            result += item + ", ";  // 배열원소 0 ~ n 번째까지 문자열 연결
        }
        return result.substring(0, result.length() - 2);
        // 맨마지막 ", " 2글자 삭제해서 리턴
    }
}
