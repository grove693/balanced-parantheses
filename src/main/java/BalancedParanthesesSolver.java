import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class BalancedParanthesesSolver {

    public static final char OPEN_PARANTHESIS = '(';
    public static final char CLOSED_PARANTHESIS = ')';
    public static final char OPEN_SQUARE_BRACKET = '[';
    public static final char CLOSED_SQUARE_BRACKET = ']';
    public static final char OPEN_CURLY_BRACKET = '{';
    public static final char CLOSED_CURLY_BRACKET = '}';

    public static final Map<Character, Character> BRACKETS_ASSOCIATION = Map.of(
            OPEN_PARANTHESIS, CLOSED_PARANTHESIS,
            OPEN_SQUARE_BRACKET, CLOSED_SQUARE_BRACKET,
            OPEN_CURLY_BRACKET, CLOSED_CURLY_BRACKET
    );

    public static boolean areBalanced(String parantheses) {
        final Deque<Character> stack = new ArrayDeque<>();

        if (parantheses == null || parantheses.isEmpty()) {
            return false;
        }

        for (Character chr : parantheses.toCharArray()) {
            if (!isBracket(chr)) {
                return false;
            }

            if (isOpenBracket(chr)) {
                stack.push(chr);
            } else {
                // closed bracket flow
                if (!arePairedBrackets(stack.pop(), chr)) {
                    return false;
                }
            }
        }

        // stack should be empty at the end if everything is balanced
        return stack.isEmpty();
    }

    private static boolean arePairedBrackets(Character openBracket, Character closedBracket) {
        return closedBracket.equals(BRACKETS_ASSOCIATION.get(openBracket));
    }

    private static boolean isOpenBracket(Character bracket) {
        return OPEN_CURLY_BRACKET == bracket ||
                OPEN_SQUARE_BRACKET == bracket ||
                OPEN_PARANTHESIS == bracket;
    }

    private static boolean isClosedBracket(Character bracket) {
        return CLOSED_CURLY_BRACKET == bracket ||
                CLOSED_SQUARE_BRACKET == bracket ||
                CLOSED_PARANTHESIS == bracket;
    }

    private static boolean isBracket(Character bracket) {
        return isOpenBracket(bracket) || isClosedBracket(bracket);
    }
}
