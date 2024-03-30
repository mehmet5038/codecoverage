import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;

public class TestCompute {
    private Compute c;
    private MessageQueue mq;

    @Before
    public void setUp() {
        mq = mock(MessageQueue.class);
        c = new Compute(mq);
    }
    @Test
    public void test_zero_length() {
        when(mq.size()).thenReturn(0);
        assertEquals(-1, c.countNumberOfOccurrences("208OpelAstraH1.3CDTI"));
    }
    @Test
    public void testElementNotInQueue() {
        when(mq.size()).thenReturn(10);
        when(mq.contains("1998NissanSkylineGTR")).thenReturn(false);
        assertEquals(0, c.countNumberOfOccurrences("2000FordFiesta1.25"));
    }
    @Test
    public void testElementOccursMultipleTimes() {
        when(mq.size()).thenReturn(6);
        when(mq.contains("car")).thenReturn(true);
        when(mq.getAt(0)).thenReturn("car");
        when(mq.getAt(1)).thenReturn("tank");
        when(mq.getAt(2)).thenReturn("car");
        when(mq.getAt(3)).thenReturn("plane");
        when(mq.getAt(4)).thenReturn("car");
        when(mq.getAt(5)).thenReturn("car");
        assertEquals(4, c.countNumberOfOccurrences("car"));
    }
}
