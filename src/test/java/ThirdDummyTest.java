import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ThirdDummyTest {

    @Test
    public void testThatAlwaysFails() throws InterruptedException {
        Thread.sleep(1000);
        Assertions.fail();
    }

    @Test
    public void testThatAlwaysPasses() throws InterruptedException {
        Thread.sleep(1000);
        Assertions.assertTrue(true);
    }

    @Test
    public void testThatIsSlowButAlwaysFails() throws InterruptedException {
        Thread.sleep(1000);
        Assertions.fail();
    }

    @Test
    public void testThatIsSlowButAlwaysPasses() throws InterruptedException {
        Thread.sleep(1000);
        Assertions.assertTrue(true);
    }
}