package calculator.calculation;

import calculator.exception.ExceptionChecker;

public class SumNum {
    public static int sum(String[] numArr) {
        int value = 0;

        ExceptionChecker.checkInvalidSeparator(numArr);
        ExceptionChecker.checkHyphen(numArr);

        for (String num : numArr) {
            value += Integer.parseInt(num);
        }

        return value;
    }
}
