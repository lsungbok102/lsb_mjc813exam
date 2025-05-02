public class Solution181884 {
    // https://school.programmers.co.kr/learn/courses/30/lessons/181884
    public int solution(int[] numbers, int n) {
        int answer = 0;
        for(int i = 0; i < numbers.length; i++){
            if(answer <= n){
                answer += numbers[i];
            }
            else if (answer > n){
                break;
            }
        }
        return answer;
    }
}