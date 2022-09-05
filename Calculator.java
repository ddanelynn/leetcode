public class Calculator {
    // helper function splits expression into left, operator and right as a
    // three-element String array
    public static String[] helper(String expression) {
        // (2 + (3 - 4))
        String[] result = expression.split(" ");
        return result;
    }

    public static String calculate(String leftOp, String rightOp, String operator) throws Exception {
        if (operator == "+") {
            return String.valueOf(Integer.parseInt(leftOp) + Integer.parseInt(rightOp));
        } else if (operator == "-") {
            return String.valueOf(Integer.parseInt(leftOp) - Integer.parseInt(rightOp));
        } else if (operator == "*") {
            return String.valueOf(Integer.parseInt(leftOp) * Integer.parseInt(rightOp));
        } else if (operator == "/") {
            return String.valueOf(Integer.parseInt(leftOp) / Integer.parseInt(rightOp));
        } else {
            throw new Exception("unmatched operator");
        }
    }

    public static String evaluate(String[] result) throws Exception {
        if (result[0].matches("[0-9]*") && result[2].matches("[0-9]*")) {
            return calculate(result[0], result[2], result[1]);
        } else if (result[0].matches("[0-9]*")) {
            return calculate(result[0], result[2], evaluate(helper(result[1])));
        } else if (result[2].matches("[0-9]*")) {
            return calculate(result[0], evaluate(helper(result[2])), result[1]);
        } else {
            return calculate(evaluate(helper(result[0])), evaluate(helper(result[2])), result[1]);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(evaluate(new String[] { "1", "*", "2" }));
    }
}
