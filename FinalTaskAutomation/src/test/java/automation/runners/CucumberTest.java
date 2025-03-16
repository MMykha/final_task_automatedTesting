package automation.runners;

import org.junit.jupiter.api.parallel.Execution;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

@Suite
@SelectClasspathResource("src/test/automation/resources/features")
@Execution(CONCURRENT)
public class CucumberTest {
}
