import java.io.IOException;
import java.util.Arrays;

/**
 * User: luke
 * Date: 7/05/13
 * Time: 6:50 AM
 */
public class EntryPoint {
    public static void main(String[] args) throws IOException {
        DoSomething doSomething = new DoSomething();
        doSomething.execute(Arrays.asList("test123", "test2", "test31238"));
    }
}
