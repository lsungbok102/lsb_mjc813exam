import com.mjc.mjc813.cal.MyCalculator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }

        MyCalculator mCal = new MyCalculator();
//        int i = mCal.myAdd(10, 30);
//        System.out.println("두 수(" + 10 + ", " + 20 + ")의 값은 " + i + " 입니다.");
//        System.out.printf("두 수(%d, %d)의 값은 %d 입니다.\n", 10, 30, i);
        System.out.printf("두 수(%d, %d)의 값은 %d 입니다.\n", 10, 30, mCal.myAdd(10, 30));
        System.out.printf("두 수(%d, %d)의 값은 %d 입니다.\n", 123456789012345L, 98765432198765L, mCal.myAdd(123456789012345L, 98765432198765L));

        int v = 0;
        int r = v + 5;
        String str = """
이것은 문자열 여러 행입니다.1
이것은 문자열 여러 행입니다.2
이것은 문자열 여러 행입니다.3
""";
        System.out.println(str);
    }
}