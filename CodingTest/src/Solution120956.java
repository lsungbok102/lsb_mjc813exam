public class Solution120956 {
    // https://school.programmers.co.kr/learn/courses/30/lessons/120956
    public static void main(String[] args) {
        Solution120956 sol = new Solution120956();
        int result = sol.solution(new String[] {"aya", "yee", "u", "maa", "wyeoo"});
        System.out.println("Solution120956 : " + result);
        result = sol.solution(new String[] {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"});
        System.out.println("Solution120956 : " + result);
    }
    public int solution(String[] babbling) {
        int answer = 0;
        for( String item : babbling ) {
            String result = this.findReplace(item);
            System.out.println(result);
            if ( this.checkNumber(result) != 0 ) {
                answer++;
            }
        }
        return answer;
    }
    public String findReplace(String item) {
        String[] baby = new String[] {"aya", "ye", "woo", "ma"};
        for( int i = 0; i < baby.length; i++ ) {
            item = item.replace(baby[i], "1");
            // "aya", "ye", "woo", "ma" 글자를 1로 변환
        }
        return item;
    }
    public int checkNumber(String str) {
        int result = 0;
        for( int i = 0; i < str.length(); i++ ) {
            if ( str.charAt(i) >= '0'
                    && str.charAt(i) <= '9' ) {
                result++;   // 숫자이면 다음글자도 숫자인지
            } else {
                return 0;   // 숫자아니면 무조건 0을 리턴
            }
        }
        return result;
    }
}
