package calculator.exception;

public class ExceptionChecker {

    // 커스텀 구분자에 숫자가 있는지 확인
    public static void checkNumInSeparator(String str) {
        if (str.contains("[1-9]")) {
            throw new IllegalArgumentException();
        }
    }

    // 구분자가 2번이상 나오는지 확인
    public static void checkContinuousSeparator(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == ' ' && str.charAt(i + 1) == ' ') {
                throw new IllegalArgumentException();
            }
        }
    }

    // 문자열 맨 앞과 뒤에 구분자가 있는지 확인
    public static void checkSeparatorPosition(String str) {
        try {
            Integer.parseInt(String.valueOf(str.charAt(0)));
            Integer.parseInt(String.valueOf(str.charAt(str.length() - 1)));
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    // 문자열속에 구분자가 아닌 문자가 들어있는지 확인
    public static void checkInvalidSeparator(String[] num) {
        try {
            for (String s : num) {
                Integer.parseInt(s);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    // "-"가 들어있는지 확인
    public static void checkHyphen(String[] num) {
        for (String s : num) {
            int value = Integer.parseInt(s);
            if (value < 0) {
                throw new IllegalArgumentException();
            }
        }
    }
}
