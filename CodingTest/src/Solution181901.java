public class Solution181901 {
    // https://school.programmers.co.kr/learn/courses/30/lessons/181901
    public int[] solution(int n, int k) {
        int[] answer = new int[n/k];
        for(int i = 0; i < answer.length; i++){
            answer[i] = k * (i + 1);
        }
        return answer;
    }
}