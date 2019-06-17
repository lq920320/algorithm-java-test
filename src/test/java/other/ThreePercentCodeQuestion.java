package other;

import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuqian
 * @date 2019/6/17  13:06
 * 3% 的代码问题
 */
public class ThreePercentCodeQuestion {

    // 01
    @Test
    public void floatPrimitiveTest() {
        float a = 1.0f - 0.9f;
        float b = 0.9f - 0.8f;
        if (a == b) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        // the result: false
    }

    // 02
    @Test
    public void FloatWrapperTest() {
        Float a = Float.valueOf(1.0f - 0.9f);
        Float b = Float.valueOf(09.f - 0.8f);
        if (a.equals(b)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        // the result: false
    }

    // 03
    @Test
    public void SwitchTest() {
        String param = null;
        switch (param) {
            case "null":
                System.out.println("null");
                break;
            default:
                System.out.println("default");
        }
        // the result:
    }

    // 04
    @Test
    public void BigDecimalTest() {
        BigDecimal a = new BigDecimal(0.1);
        System.out.println(a);
        BigDecimal b = new BigDecimal("0.1");
        System.out.println(b);
        // the result:
        //        a: 0.1000000000000000055511151231257827021181583404541015625
        //        b: 0.1
    }

    // 05
    private final static Lock lock = new ReentrantLock();

    @Test
    public void LockTest() {
        try {
            lock.tryLock();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        // the result:
    }
}
