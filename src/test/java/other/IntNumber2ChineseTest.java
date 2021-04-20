package other;

import org.junit.Test;

/**
 * @author liuqian
 * @date 2020/05/07
 */
public class IntNumber2ChineseTest {

    private static final String[] units = {"", "十", "百", "千", "万", "十万", "百万", "千万", "亿", "十亿", "百亿", "千亿", "万亿"};
    private static final char[] numArray = {'零', '一', '二', '三', '四', '五', '六', '七', '八', '九'};

    @Test
    public void numberTest() {
        int num = 100;
        String numStr = formatInteger(num);
        System.out.println("num = " + num + ", convert result: " + numStr);
        num = 12;
        numStr = formatInteger(num);
        System.out.println("num = " + num + ", convert result: " + numStr);
        num = 8;
        numStr = formatInteger(num);
        System.out.println("num = " + num + ", convert result: " + numStr);
        num = 10;
        numStr = formatInteger(num);
        System.out.println("num = " + num + ", convert result: " + numStr);
        num = 20;
        numStr = formatInteger(num);
        System.out.println("num = " + num + ", convert result: " + numStr);
        num = 25;
        numStr = formatInteger(num);
        System.out.println("num = " + num + ", convert result: " + numStr);
        num = 99;
        numStr = formatInteger(num);
        System.out.println("num = " + num + ", convert result: " + numStr);
        num = 71;
        numStr = formatInteger(num);
        System.out.println("num = " + num + ", convert result: " + numStr);
        num = 112;
        numStr = formatInteger(num);
        System.out.println("num = " + num + ", convert result: " + numStr);
        num = 120;
        numStr = formatInteger(num);
        System.out.println("num = " + num + ", convert result: " + numStr);
        num = 108;
        numStr = formatInteger(num);
        System.out.println("num = " + num + ", convert result: " + numStr);
    }


    private static String formatInteger(int num) {
        char[] val = String.valueOf(num).toCharArray();
        int len = val.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            String m = val[i] + "";
            int n = Integer.parseInt(m);
            boolean isZero = n == 0;
            String unit = units[(len - 1) - i];
            if (isZero) {
                if ('0' != val[len - 1]) {
                    sb.append(numArray[n]);
                }
            } else {
                if (num < 10 || num >= 20 || i != 0) {
                    sb.append(numArray[n]);
                }
                sb.append(unit);
            }
        }
        return sb.toString();
    }
}