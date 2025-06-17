import java.util.Arrays;
import java.util.List;

public class Lamda {

    // 문제1, 문제2 공통 인터페이스
    public interface INumberProc {
        void process(String str, Integer age);
    }

    // 문제3, 문제4 공통 인터페이스
    public interface IArrayProc {
        Long process(List<Integer> list);
    }

    // 문제1: 사람 출력
    public static void printHuman(INumberProc inp) {
        inp.process("홍길동", 25);
    }

    // 문제2: 자동차 출력
    public static void printCar(INumberProc inp) {
        inp.process("소나타", 2020);
    }

    // 문제3: 합계 출력
    public static void sum() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        IArrayProc proc = (arr) -> arr.stream().mapToLong(Integer::longValue).sum();
        Long sum = proc.process(list);
        System.out.printf("합은 {%d} 입니다.%n", sum);
    }

    // 문제4: 평균 출력
    public static void avg() {
        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);
        IArrayProc proc = (arr) -> {
            long sum = arr.stream().mapToLong(Integer::longValue).sum();
            return sum / arr.size();
        };
        Long avg = proc.process(list);
        System.out.printf("평균은 {%d} 입니다.%n", avg);
    }

    // 메인 메서드에서 모두 실행
    public static void main(String[] args) {
        printHuman((str, age) -> {
            System.out.printf("%s 님의 나이는 %d 입니다.%n", str, age);
        });

        printCar((str, age) -> {
            System.out.printf("자동차 %s 의 년식은 %d 입니다.%n", str, age);
        });

        sum();
        avg();
    }
}
