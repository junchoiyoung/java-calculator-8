package calculator.separation;

import calculator.exception.ExceptionChecker;
import java.util.Arrays;
import java.util.List;

// 커스텀 구분자 분리
public class SeparatorSplitter {
    public static List<String> divide(String separator) {
        ExceptionChecker.checkNumInSeparator(separator);
        return Arrays.asList(separator.split(" "));
    }
}
