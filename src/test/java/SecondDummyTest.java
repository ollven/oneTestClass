import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SecondDummyTest {

    @Test
    public void testThatAlwaysFails() throws InterruptedException {
        Thread.sleep(1400);
        Assertions.assertTrue(false);
    }

    @Test
    public void testThatAlwaysPasses() throws InterruptedException {
        Thread.sleep(2400);
        Assertions.assertTrue(true);
    }

    @Test
    public void testThatIsSlowButAlwaysFails() throws InterruptedException {
        Thread.sleep(2000);
        Assertions.assertTrue(false);
    }

    @Test
    public void testThatIsSlowButAlwaysPasses() throws InterruptedException {
        Thread.sleep(4500);
        Assertions.assertTrue(true);
    }
}
