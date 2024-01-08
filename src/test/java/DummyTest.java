import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class DummyTest {

    @Test
    public void testThatAlwaysFails() throws InterruptedException {
        Thread.sleep(1000);
        Assertions.assertTrue(true);
    }

    @Test
    public void testThatAlwaysPasses() throws InterruptedException {
        Thread.sleep(400);
        Assertions.assertTrue(true);
    }

    @Test
    public void testThatIsSlowButAlwaysFails() throws InterruptedException {
        Thread.sleep(300);
        Assertions.assertTrue(true);
    }

    @Test
    public void testThatIsSlowButAlwaysPasses() throws InterruptedException {
        Thread.sleep(500);
        Assertions.assertTrue(true);
    }
}
