import java.util.Scanner;

public class Main002 {
    public static void main(String[] args) {
        // 직각삼각형 출력하기
        // https://school.programmers.co.kr/learn/courses/30/lessons/120823
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(n);

        for( int i = 1; i <= n; i++ ) {
            for( int j = 0; j < i; j++ ) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
