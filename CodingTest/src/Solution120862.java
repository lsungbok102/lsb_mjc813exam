public class Solution120862 {
    // https://school.programmers.co.kr/learn/courses/30/lessons/120862
    public int solution(int[] numbers) {
        int answer = 0;
        for ( int i = 0; i < numbers.length; i++ ) {
            // 배열 모든 원소에 대해서 루프 실행
            for ( int j = 0; j < numbers.length; j++ ) {
                // 배열 모든 원소에 대해서 루프 실행
                if ( i != j ) {
                    // number[1] * number[1], number[2] * number[2] 는 계산에 포함시키면 안된다.
                    int nTemp = numbers[i] * numbers[j];
                    // 배열의 두 원소를 곱한 결과
                    if ( answer < nTemp ) {
                        // 현재 answer 보다 결과가 크면 answer 에 결과를 저장
                        answer = nTemp;
                    }
                }
            }
        }
            return answer;
    }
    public static void main(String[] args) {
        Solution120862 sol = new Solution120862();
        System.out.println("[1, 2, -3, 4, -5] => " + sol.solution(new int[] {1, 2, -3, 4, -5}));
        System.out.println("[0, -31, 24, 10, 1, 9] => " + sol.solution(new int[] {0, -31, 24, 10, 1, 9}));
        System.out.println("[10, 20, 30, 5, 5, 20, 5] => " + sol.solution(new int[] {10, 20, 30, 5, 5, 20, 5}));
    }
}
