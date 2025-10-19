package calculator;

import calculator.calculation.SumNum;
import calculator.print.Output;
import calculator.separation.SeparationString;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 데이터 입력
        String input = Console.readLine();
        Console.close();

        SeparationString separationString = new SeparationString(input);
        separationString.separate();

        int sumValue = SumNum.sum(separationString.getNumArr());

        Output.printOut(sumValue);
    }
}
