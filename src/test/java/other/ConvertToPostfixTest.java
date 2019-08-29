package other;

import org.junit.Test;

/**
 * @author liuqian
 * @date 2019/8/29 21:54.
 */
public class ConvertToPostfixTest {

    @Test
    public void convertTest() {
        String infixExpression = "1 + 1";
        ConvertToPostfix convert = new ConvertToPostfix(infixExpression);
        System.out.println(convert.toPostfix());

        String a = "123456 12345";
        System.out.println(a.replace("  ", " "));
    }
}
