package calculator.separation;

import calculator.exception.ExceptionChecker;
import java.util.ArrayList;
import java.util.Collections;

// 숫자와 구분자를 분리
public class SeparationNum {
    public static String[] separateNum(String numStr, ArrayList<String> separatorList) {
        //예외처리(맨앞이나 뒤에 구분자가 있는지)
        ExceptionChecker.checkSeparatorPosition(numStr);

        // 같은 기호가 구분자로 여러번 나오는 경우
        // 예) //< <<\n1<2<<3
        separatorList.sort(Collections.reverseOrder());

        for (String separator : separatorList) {
            numStr = numStr.replace(separator, " ");
        }

        //예외처리(구분자가 2번 연속으로 나오는 경우)
        ExceptionChecker.checkContinuousSeparator(numStr);

        return numStr.split(" ");
    }
}
