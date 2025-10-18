package calculator.calculation;

import calculator.exception.ExceptionChecker;

public class SumNum {
    public static int sum(String[] num) {
        int value = 0;

        ExceptionChecker.checkInvalidSeparator(num);
        ExceptionChecker.checkHyphen(num);

        for (String s : num) {
            value += Integer.parseInt(s);
        }

        return value;
    }
}
