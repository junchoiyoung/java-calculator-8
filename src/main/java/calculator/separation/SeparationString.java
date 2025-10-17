package calculator.separation;

import java.util.ArrayList;

public class SeparationString {

    String str;
    String[] num;

    // 구분자 배열
    ArrayList<String> separatorList = new ArrayList<>() {{
        add(",");
        add(":");
    }};

    public SeparationString(String str) {
        this.str = str;
    }

    // 사용자에게 입력받은 문자열에서 커스텀 구분자와 숫자를 구분
    public void separate() {

        if (str.isEmpty()) {
            return;
        }

        if ((str.charAt(0) == '/' && str.charAt(1) == '/') && str.contains("\\n")) {
            int index = str.indexOf("\\n");
            String separator = str.substring(2, index);
            str = str.substring(index + 2);
            separatorList.addAll(SeparatorSplitter.divide(separator));
        }

        num = SeparationNum.separateNum(str, separatorList);
    }

    public String[] getNum() {
        return num == null ? new String[]{"0"} : num;
    }
}