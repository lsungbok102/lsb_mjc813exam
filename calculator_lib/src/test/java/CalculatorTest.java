//import com.example.calculator.Calculator;
import com.sghcalculator.lib.Calculator;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {
    @Test
    public void testAdd() {
        Calculator cal = new Calculator();
        assertThat(cal.add(1,3)).isEqualTo(4);
        assertThat(cal.sub(8,3)).isEqualTo(5);
        assertThat(cal.mul(4,7)).isEqualTo(28);
        assertThat(cal.div(12,6)).isEqualTo(2);
        assertThat(cal.mod(16,5)).isEqualTo(1);
        assertThat(cal.pow(3,4)).isEqualTo(81);
        assertThat(cal.allsum(new int[] {3, 2, 6, 4, 7})).isEqualTo(22);
    }
}