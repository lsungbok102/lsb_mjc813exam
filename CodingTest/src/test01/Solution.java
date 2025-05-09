import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        if(num_list.size() >= 11){
            for(int i = 0; i < num_list.size(); i++){
                answer += num_list.get(i);
            }
        }
        else if(num_list.size() <= 10){
            for(int j = 0; i < num_list.size(); i++){
                answer *= num_list.get(i);
            }
        }
        return answer;
    }
}