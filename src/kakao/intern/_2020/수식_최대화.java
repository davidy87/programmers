package kakao.intern._2020;

import java.util.*;

public class 수식_최대화 {

    private static final char[][] OPS = {
            {'+', '-', '*'}, {'+', '*', '-'},
            {'-', '+', '*'}, {'-', '*', '+'},
            {'*', '+', '-'}, {'*', '-', '+'}
    };

    private final List<Long> operands = new ArrayList<>();
    private final List<Character> operators = new ArrayList<>();

    public long solution(String expression) {
        split(expression);
        return getBestResult();
    }

    private long getBestResult() {
        long result = 0L;

        for (char[] op : OPS) {
            List<Long> tempOperands = new ArrayList<>(operands);
            List<Character> tempOperators = new ArrayList<>(operators);

            for (char o : op) {
                int i = 0;

                while (i < tempOperands.size() - 1) {
                    if (tempOperators.get(i) != o) {
                        i++;
                        continue;
                    }

                    long a = tempOperands.get(i);
                    long b = tempOperands.get(i + 1);

                    tempOperands.set(i, calculate(a, b, o));
                    tempOperators.remove(i);
                    tempOperands.remove(i + 1);
                }
            }

            result = Math.max(Math.abs(tempOperands.get(0)), result);
        }

        return result;
    }

    private long calculate(long a, long b, char o) {
        if (o == '+') {
            return a + b;
        } else if (o == '-') {
            return a - b;
        }

        return a * b;
    }

    private void split(String expression) {
        for (String operand : expression.split("[-+*]")) {
            operands.add(Long.parseLong(operand));
        }

        for (String operator : expression.split("\\d+")) {
            if (!operator.isEmpty()) {
                operators.add(operator.charAt(0));
            }
        }
    }
}
