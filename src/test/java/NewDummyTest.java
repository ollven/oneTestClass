import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NewDummyTest {

    @Test
    public void testThatAlwaysFails() throws InterruptedException {
        Thread.sleep(200);
        Assertions.assertTrue(true);
    }

    @Test
    public void testThatAlwaysPasses() throws InterruptedException {
        Thread.sleep(2000);
        Assertions.assertTrue(false);
    }

    @Test
    public void testThatIsSlowButAlwaysFails() throws InterruptedException {
        Thread.sleep(2000);
        Assertions.assertTrue(true);
    }

    @Test
    public void testThatIsSlowButAlwaysPasses() throws InterruptedException {
        Thread.sleep(2000);
        Assertions.assertTrue(true);
    }
}
