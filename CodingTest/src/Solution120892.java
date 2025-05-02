public class Solution120892 {
    // https://school.programmers.co.kr/learn/courses/30/lessons/120892
    public String solution(String cipher, int code) {
        String answer = "";
        for(int i = code-1; i<cipher.length(); i+=code){
            answer += cipher.charAt(i);
        }
        return answer;
    }
}
