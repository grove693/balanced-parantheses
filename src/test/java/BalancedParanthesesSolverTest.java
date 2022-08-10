import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.*;

public class BalancedParanthesesSolverTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "{{}}",
            "[({})]",
            "{}([])",
            "{()}[[{}]]"
    })
    void shouldBeBalanced(String input) {
        assertTrue(BalancedParanthesesSolver.areBalanced(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "",
            " ",
            "{{}}a",
            "{a}",
            "{{)(}}",
            "({)}"
    })
    void shouldNotBeBalanced(String input) {
        assertFalse(BalancedParanthesesSolver.areBalanced(input));
    }
}