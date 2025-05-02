public class Solution181895 {
    // https://school.programmers.co.kr/learn/courses/30/lessons/181895
    public int[] solution(int[] arr, int[][] intervals) {
        int count = 0;
        int a1 = intervals[0][0];
        int b1 = intervals[0][1];
        int a2 = intervals[1][0];
        int b2 = intervals[1][1];
        int[] answer = new int[b1+b2-a1-a2+2];
        for(int i = a1; i <= b1; i++){
            answer[count++] = arr[i];
        }
        for(int j = a2; j <= b2; j++){
            answer[count++] = arr[j];
        }
        return answer;
    }
}