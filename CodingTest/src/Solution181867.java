public class Solution181867 {
    // https://school.programmers.co.kr/learn/courses/30/lessons/181867
    public int[] solution(String myString) {
        String[] a = myString.split("x", -1);
        int[] answer = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            answer[i] = a[i].length();
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution181867 sol = new Solution181867();
        int[] result = sol.solution("oxooxoxxox");;
        System.out.print("Solution181867 : ");
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}

