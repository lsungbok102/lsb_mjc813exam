import java.util.ArrayList;
import java.util.Random;

public class ThisIsJavaChap04Exam {
    public static void main(String[] args) {
        ThisIsJavaChap04Exam tij = new ThisIsJavaChap04Exam();
        System.out.println("solve04: " + tij.solve04());
        System.out.println("solve05: " + tij.solve05());
    }

    public String solve04() {
        Random rand = new Random();
        int dice1, dice2;
        while (true) {
            dice1 = rand.nextInt(6) + 1; // 1~6
            dice2 = rand.nextInt(6) + 1; // 1~6
            System.out.println("주사위1: " + dice1 + ", 주사위2: " + dice2 + " => 합: " + (dice1 + dice2));

            if (dice1 + dice2 == 5) {
                System.out.println("합이 5이므로 종료합니다.");
                return "(" + dice1 + "," + dice2 + ")";
            }
        }
    }

    public String solve05() {
        ArrayList<int[]> result = new ArrayList<>();
        for (int x = 1; x <= 10; x++) {
            for (int y = 1; y <= 10; y++) {
                if (4 * x + 5 * y == 60) {
                    result.add(new int[]{x, y});
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int[] pair : result) {
            sb.append(getResultString(pair));
        }
        return sb.toString();
    }

    private String getResultString(int[] result) {
        return "(" + result[0] + "," + result[1] + ") ";
    }
}
