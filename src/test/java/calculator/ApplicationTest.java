package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 같은_기호로_이루어진_구분자() {
        assertSimpleTest(() -> {
            run("/// //\\n1/2//3,4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 구분자로_메타문자_사용() {
        assertSimpleTest(() -> {
            run("/// < > ( )\\n1/2<3>4(5)6");
            assertThat(output()).contains("결과 : 21");
        });
    }

    @Test
    void 문자_커스텀_구분자() {
        assertSimpleTest(() -> {
            run("//wo te ko\\n2025wo10te14ko8");
            assertThat(output()).contains("결과 : 2057");
        });
    }

    @Test
    void 커스텀_구분자_사용안함() {
        assertSimpleTest(() -> {
            run("1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 입력값_공백() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 예외_테스트_하이픈() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_구분자연속() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_숫자_구분자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//1\\n1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_앞뒤_구분자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_구분자_아님() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2a3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
