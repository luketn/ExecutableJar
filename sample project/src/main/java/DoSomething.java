import com.google.common.base.Charsets;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class DoSomething {
    private static final Logger log = Logger.getLogger(DoSomething.class);

    public void execute(List<String> testStrings) throws IOException {
        checkNotNull(testStrings, "Test strings was null.");

        File file = new File("test.txt");
        log.debug(String.format("Writing test file '%s'", file.getAbsolutePath()));

        Ordering<String> byLengthOrdering = new Ordering<String>() {
            public int compare(String left, String right) {
                return Ints.compare(left.length(), right.length());
            }
        };

        List<String> sortedStrings = byLengthOrdering.sortedCopy(testStrings);

        FileOutputStream fileOutputStream = FileUtils.openOutputStream(file);
        try{
            for (String test : sortedStrings) {
                if (StringUtils.isNotEmpty(test)) {
                    try {
                        log.debug(String.format("Writing test string: %s", test));
                        byte[] bytes = test.getBytes(Charsets.UTF_8);
                        fileOutputStream.write(bytes);
                        fileOutputStream.write('\n');
                    } catch (IOException e) {
                        log.error(e);
                    }
                }
            }
        } finally {
            fileOutputStream.close();
        }
    }
}
