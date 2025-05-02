import test01.AgeBox;
import test01.GroupA;
import test01.Person;

import java.util.ArrayList;

import static java.util.Arrays.*;

public class Main001 {
    public static void main(String[] args) {
        System.out.println("Start");
        Main001 m001 = new Main001();
        int[] result = m001.solution(12, new int[] {2, 100, 120, 600, 12, 12});
        m001.printArray(result);

        int[] result2 = m001.solution(3, new int[] {4, 5, 6, 7, 8, 9, 10, 11, 12});
        m001.printArray(result2);

        GroupA aaa = new GroupA();
        Person p = aaa.getPerson('c');
        AgeBox ab = p.getAgeBox();
        int nn = ab.getAge();

        int mmm = aaa.getPerson('a').getAgeBox().getAge();

        System.out.println("{1, 2, 7, 10, 100} : " + m001.solution120811(new int[] {1, 2, 7, 10, 11}));
        System.out.println("{9, -1, 0} : " + m001.solution120811(new int[] {9, -1, 0}));

        System.out.print("{1, 2, 100, -99, 1, 2, 3} : ");
        m001.printArray(m001.solution120809(new int[] {1, 2, 100, -99, 1, 2, 3}));

        System.out.println("{1, 2, 3} : " + m001.solution120889(new int[] {1, 2, 3}));
        System.out.println("{199, 72, 222} : " + m001.solution120889(new int[] {199, 72, 222}));

    }

    private void printArray(int[] result) {
        for(int i = 0; i < result.length; i++ ) {
            System.out.printf("[%d] ", result[i]);
        }
        System.out.println();
    }

    public int[] solution(int n, int[] numlist) {
        // n의 배수 고르기
        // https://school.programmers.co.kr/learn/courses/30/lessons/120905
        // numlist 배열에서 n 배수가 몇개인지 알아보자.
        int count = 0;
        for( int i = 0; i < numlist.length; i++ ) {
            if ( numlist[i] % n == 0 ) {
                count++;
            }
        }
        int[] answer = new int[count];
        // numlist 배열에서 n 배수인 수를 answer 배열에 추가한다.
        int ndx = 0;
        for( int i = 0; i < numlist.length; i++ ) {
            if ( numlist[i] % n == 0 ) {
                answer[ndx++] = numlist[i];
            }
        }
        return answer;
    }

    public int[] solution2(int n, int[] numberlist) {
        // n의 배수 고르기
        // https://school.programmers.co.kr/learn/courses/30/lessons/120905
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for ( int i = 0; i < numberlist.length; i++ ) {
            if ( numberlist[i] % n == 0 ) {
                arr.add(numberlist[i]);
            }
        }
        int[] answer = arr
                .stream()
                .mapToInt(g -> g)
                .toArray();
        return answer;
    }

    public int sol111(int n) {
        int answer = 0;
        String nStr = String.valueOf(n);
        for( int i = 0; i < nStr.length(); i++ ) {
            answer += Integer.parseInt( String.valueOf( nStr.charAt(i) ) );
        }
        //while ( n >= 1 ) {
        //    answer += (n % 10);
        //    n /= 10;
        //}
        return answer;
    }


    public int solution120908(String str1, String str2) {
        // 문자열안에 문자열
        // https://school.programmers.co.kr/learn/courses/30/lessons/120908
        if ( str1.indexOf(str2) >= 0 ) {
            return 1;
        }
        return 2;
    }

    public int solution120811(int[] array) {
        // 중앙값 구하기
        // https://school.programmers.co.kr/learn/courses/30/lessons/120811
        int answer = 0;
        sort(array);
        int nMid = array.length / 2;
        return answer = array[nMid];
    }

    public int[] solution120809(int[] numbers) {
        // 배열 두 배 만들기
        // https://school.programmers.co.kr/learn/courses/30/lessons/120809
//        List<Integer> intArrayList = Arrays.stream(numbers).boxed().toList();
        // 고정형 int 배열을 가변형 배열 ArrayList 로 변환, 원소도 int -> Integer
//        int[] answer = intArrayList
//                .stream()
//                .mapToInt(n -> n * 2) // 각 원소를 * 2 씩 했다.
//                .toArray();

        int[] answer = new int[numbers.length];
        for( int i = 0; i < numbers.length; i++ ) {
            answer[i] = numbers[i] * 2;
        }
        return answer;
    }

    public int solution120889(int[] sides) {
        // 삼각형의 완성조건 (1)
        // https://school.programmers.co.kr/learn/courses/30/lessons/120889
        int nMax = findMax(sides);
        int nSum = sumArray(sides);
        if ( nMax < nSum ) {
            return 1;
        }
        return 2;
    }

    public int findMax(int[] array) {
        // 정수 배열의 가장 큰 값을 리턴한다.
        // 가장 큰 값이 있는 원소는 0 로 설정한다.
        int nMax = array[0];
        int ndx = 0;
        for( int i = 1; i < array.length; i++ ) {
            if (nMax < array[i]) {
                nMax = array[i];
                ndx = i;
            }
        }
        array[ndx] = 0;
        return nMax;
    }

    public int sumArray(int[] array) {
        // 정수 배열의 합을 리턴한다.
        int nSum = 0;
        for( int i = 0; i < array.length; i++ ) {
            nSum += array[i];
        }
        return nSum;
    }

    public String solution12939(String s) {
        String answer = "";
        String[] arrStr = s.split(" ");
        int[] arrNumber = new int[arrStr.length];
        for( int i = 0; i < arrStr.length; i++ ) {
            arrNumber[i] = Integer.parseInt(arrStr[i]);
        }
        return answer;
    }
}
