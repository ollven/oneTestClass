import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SecondNewDummyTest {

    @Test
    public void testThatAlwaysFails() throws InterruptedException {
        Thread.sleep(2000);
        Assertions.assertTrue(false);
    }

    @Test
    public void testThatAlwaysPasses() throws InterruptedException {
        Thread.sleep(2300);
        Assertions.assertTrue(true);
    }

    @Test
    public void testThatIsSlowButAlwaysFails() throws InterruptedException {
        Thread.sleep(1000);
        Assertions.assertTrue(false);
    }

    @Test
    public void testThatIsSlowButAlwaysPasses() throws InterruptedException {
        Thread.sleep(2000);
        Assertions.assertTrue(true);
    }
}
