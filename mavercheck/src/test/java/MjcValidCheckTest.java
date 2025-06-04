import org.example.MjcValidCheck;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MjcValidCheckTest {

    MjcValidCheck mvc = new MjcValidCheck();

    @Test
    public void testValidPhoneNumber() {
        assertThat(mvc.isValidPhoneNumber(null)).isEqualTo(false);
        assertThat(mvc.isValidPhoneNumber("")).isEqualTo(false);
        assertThat(mvc.isValidPhoneNumber("010-3992")).isEqualTo(false);
        assertThat(mvc.isValidPhoneNumber("02-7487-0203")).isEqualTo(false);
        assertThat(mvc.isValidPhoneNumber("02-d35a-1s32")).isEqualTo(false);
        assertThat(mvc.isValidPhoneNumber("010-1111-2222")).isEqualTo(true);
    }

    @Test
    public void testValidZipNumber() {
        assertThat(mvc.isValidZipNumber(null)).isEqualTo(false);
        assertThat(mvc.isValidZipNumber("")).isEqualTo(false);
        assertThat(mvc.isValidZipNumber("01234")).isEqualTo(false);
        assertThat(mvc.isValidZipNumber("123456")).isEqualTo(false);
        assertThat(mvc.isValidZipNumber("abcde")).isEqualTo(false);
        assertThat(mvc.isValidZipNumber("12345")).isEqualTo(true);
        assertThat(mvc.isValidZipNumber("10349")).isEqualTo(true);
    }

    @Test
    public void testValidEmail() {
        //assertThat(mvc.isValidEmail(null)).isEqualTo(false);
        assertThat(mvc.isValidEmail("")).isEqualTo(false);
        assertThat(mvc.isValidEmail("user@.com")).isEqualTo(false);
        assertThat(mvc.isValidEmail("user@domain")).isEqualTo(false);
        assertThat(mvc.isValidEmail("test@example.com")).isEqualTo(true);
        assertThat(mvc.isValidEmail("test@example.net")).isEqualTo(true);
        //assertThat(mvc.isValidEmail("user.name123@domain.co.kr")).isEqualTo(true);
    }
}