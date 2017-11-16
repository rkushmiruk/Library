package util;

import com.ateam.util.GitService;
import org.apache.log4j.Logger;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class GitTest {
    private static Logger LOGGER = Logger.getLogger(GitTest.class);

    @Test
    public void testGitTagVersionIsGetCorrect() {
        String expectedValue = "v1.1.1";
        String actualValue = GitService.getGitTagVersion();
        LOGGER.info(actualValue);

        assertNotNull(actualValue);
        assertThat(expectedValue, is(actualValue));
    }
}
