import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class TestUtil {
    Util u;
    @Before
    public void setUp() {
         u = new Util();
    }
    @Test
    public void test_only_one_element() {
        assertFalse(u.compute(97));
    }
    @Test
    public void test_even_number_of_elements() {
        assertFalse(u.compute(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }
    @Test
    public void test_sum_has_divisor() {
        assertTrue(u.compute(1, 2, 3, 4, 10));
    }
    @Test
    public void test_sum_does_not_have_divisor() {
        assertFalse(u.compute(3, 5, 9));
    }
    @Test
    public void test_one_of_elements_is_zero() {
        try {
            u.compute(42, 78, 20, 0, 63);
            fail("Exception not thrown");
        } catch (RuntimeException exception) {}
    }
}
