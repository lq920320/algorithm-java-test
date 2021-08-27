package utils;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * 两个日期间隔测试类
 *
 * @author zetu
 * @date 2021/8/26
 */
public class DateBetweenTest {

    @Test
    public void betweenYearTest() throws ParseException {
        System.out.println("=====================首先设置两个日期，不包含时间======================");
        // 首先设置两个日期，不包含时间
        String beginDateStr1 = "2018-01-01";
        String endDateStr1 = "2021-01-01";

        String beginDateStr2 = "2018-01-20";
        String endDateStr2 = "2021-01-01";

        Date beginDate1 = DateUtils.parseDate(beginDateStr1, "yyyy-MM-dd");
        Date endDate1 = DateUtils.parseDate(endDateStr1, "yyyy-MM-dd");

        Date beginDate2 = DateUtils.parseDate(beginDateStr2, "yyyy-MM-dd");
        Date endDate2 = DateUtils.parseDate(endDateStr2, "yyyy-MM-dd");

        System.out.println("=========基于基本数据类型进行比较=========");
        Assert.assertEquals("应该相差3年", 3,
                DateBetweenUtils.betweenYear(beginDate1, endDate1, false));
        Assert.assertEquals("应该相差3年", 3,
                DateBetweenUtils.betweenYear(beginDate1, endDate1, true));
        Assert.assertEquals("应该相差2年，不足3年", 2,
                DateBetweenUtils.betweenYear(beginDate2, endDate2, false));
        // 这里的 isReset = true，会进行重置，故计算的结果还是 3 年，其实是不足 3 年的
        Assert.assertEquals("应该相差3个月，不足4个月", 3,
                DateBetweenUtils.betweenYear(beginDate2, endDate2, true));

        System.out.println("=========基于 Java 8 进行比较=========");
        Assert.assertEquals("应该相差3年", 3,
                DateBetweenUtils.between(beginDate1, endDate1, ChronoUnit.YEARS));
        Assert.assertEquals("应该相差2年", 2,
                DateBetweenUtils.between(beginDate2, endDate2, ChronoUnit.YEARS));


        System.out.println("=====================设置两个日期，包含时刻======================");
        // 设置两个日期，包含时刻
        String beginDateStrA = "2018-01-01 00:00:00";
        String endDateStrA = "2021-01-01 00:00:00";

        String beginDateStrB = "2018-01-01 23:59:59";
        String endDateStrB = "2021-01-01 00:00:00";

        Date beginDateA = DateUtils.parseDate(beginDateStrA, "yyyy-MM-dd HH:mm:ss");
        Date endDateA = DateUtils.parseDate(endDateStrA, "yyyy-MM-dd HH:mm:ss");

        Date beginDateB = DateUtils.parseDate(beginDateStrB, "yyyy-MM-dd HH:mm:ss");
        Date endDateB = DateUtils.parseDate(endDateStrB, "yyyy-MM-dd HH:mm:ss");

        System.out.println("=========带时刻的基于基本数据类型进行比较=========");
        Assert.assertEquals("应该相差3年", 3,
                DateBetweenUtils.betweenYear(beginDateA, endDateA, false));
        Assert.assertEquals("应该相差3年", 3,
                DateBetweenUtils.betweenYear(beginDateA, endDateA, true));
        Assert.assertEquals("应该相差2年，不足3年", 2,
                DateBetweenUtils.betweenYear(beginDateB, endDateB, false));
        // 这里的 isReset = true，不会进行重置，故计算的结果还是 3 年，其实是不足 3 年的
        Assert.assertEquals("应该相差2年，不足3年", 3,
                DateBetweenUtils.betweenYear(beginDateB, endDateB, true));

        System.out.println("=========带时刻的基于 Java 8 进行比较=========");
        Assert.assertEquals("应该相差3年", 3,
                DateBetweenUtils.between(beginDateA, endDateA, ChronoUnit.YEARS));
        Assert.assertEquals("应该相差2年，不足3年", 2,
                DateBetweenUtils.between(beginDateB, endDateB, ChronoUnit.YEARS));
    }

    @Test
    public void betweenMonthTest() throws ParseException {
        System.out.println("=====================首先设置两个日期，不包含时间======================");
        // 首先设置两个日期，不包含时间
        String beginDateStr1 = "2021-01-01";
        String endDateStr1 = "2021-05-01";

        String beginDateStr2 = "2021-01-20";
        String endDateStr2 = "2021-05-01";

        Date beginDate1 = DateUtils.parseDate(beginDateStr1, "yyyy-MM-dd");
        Date endDate1 = DateUtils.parseDate(endDateStr1, "yyyy-MM-dd");

        Date beginDate2 = DateUtils.parseDate(beginDateStr2, "yyyy-MM-dd");
        Date endDate2 = DateUtils.parseDate(endDateStr2, "yyyy-MM-dd");

        System.out.println("=========基于基本数据类型进行比较=========");
        Assert.assertEquals("应该相差4个月", 4,
                DateBetweenUtils.betweenMonth(beginDate1, endDate1, false));
        Assert.assertEquals("应该相差4个月", 4,
                DateBetweenUtils.betweenMonth(beginDate1, endDate1, true));
        Assert.assertEquals("应该相差3个月，不足4个月", 3,
                DateBetweenUtils.betweenMonth(beginDate2, endDate2, false));
        // 这里的 isReset = true，会进行重置，故计算的结果还是 4 个月，其实是不足 4 个月的
        Assert.assertEquals("应该相差3个月，不足4个月", 4,
                DateBetweenUtils.betweenMonth(beginDate2, endDate2, true));

        System.out.println("=========基于 Java 8 进行比较=========");
        Assert.assertEquals("应该相差4个月", 4,
                DateBetweenUtils.betweenMonth(beginDate1, endDate1));
        Assert.assertEquals("应该相差3个月，不足4个月", 3,
                DateBetweenUtils.betweenMonth(beginDate2, endDate2));

        System.out.println("=====================设置两个日期，包含时刻======================");
        // 设置两个日期，包含时刻
        String beginDateStrA = "2021-01-01 00:00:00";
        String endDateStrA = "2021-05-01 00:00:00";

        String beginDateStrB = "2021-01-01 23:59:59";
        String endDateStrB = "2021-05-01 00:00:00";

        Date beginDateA = DateUtils.parseDate(beginDateStrA, "yyyy-MM-dd HH:mm:ss");
        Date endDateA = DateUtils.parseDate(endDateStrA, "yyyy-MM-dd HH:mm:ss");

        Date beginDateB = DateUtils.parseDate(beginDateStrB, "yyyy-MM-dd HH:mm:ss");
        Date endDateB = DateUtils.parseDate(endDateStrB, "yyyy-MM-dd HH:mm:ss");

        System.out.println("=========带时刻的基于基本数据类型进行比较=========");
        Assert.assertEquals("应该相差4个月", 4,
                DateBetweenUtils.betweenMonth(beginDateA, endDateA, false));
        Assert.assertEquals("应该相差4个月", 4,
                DateBetweenUtils.betweenMonth(beginDateA, endDateA, true));
        Assert.assertEquals("应该相差3个月，不足4个月", 3,
                DateBetweenUtils.betweenMonth(beginDateB, endDateB, false));
        // 这里的 isReset = true，不会进行重置，故计算的结果还是 4 个月，其实是不足 4 个月的
        Assert.assertEquals("应该相差3个月，不足4个月", 4,
                DateBetweenUtils.betweenMonth(beginDateB, endDateB, true));

        System.out.println("=========带时刻的基于 Java 8 进行比较=========");
        Assert.assertEquals("应该相差4个月", 4,
                DateBetweenUtils.betweenMonth(beginDateA, endDateA));
        Assert.assertEquals("应该相差3个月，不足4个月", 3,
                DateBetweenUtils.betweenMonth(beginDateB, endDateB));
    }

    @Test
    public void betweenWeekTest() throws ParseException {
        System.out.println("=====================首先设置两个日期，不包含时间======================");
        // 首先设置两个日期，不包含时间
        String beginDateStr1 = "2021-08-01";
        String endDateStr1 = "2021-08-31";

        String beginDateStr2 = "2021-08-07";
        String endDateStr2 = "2021-08-31";

        Date beginDate1 = DateUtils.parseDate(beginDateStr1, "yyyy-MM-dd");
        Date endDate1 = DateUtils.parseDate(endDateStr1, "yyyy-MM-dd");

        Date beginDate2 = DateUtils.parseDate(beginDateStr2, "yyyy-MM-dd");
        Date endDate2 = DateUtils.parseDate(endDateStr2, "yyyy-MM-dd");

        System.out.println("=========基于基本数据类型进行比较=========");
        Assert.assertEquals("应该相差4周", 4,
                DateBetweenUtils.between(beginDate1, endDate1, ChronoUnit.WEEKS, true));
        Assert.assertEquals("应该相差3周，不足4周", 3,
                DateBetweenUtils.between(beginDate2, endDate2, ChronoUnit.WEEKS, true));

        System.out.println("=========基于 Java 8 进行比较=========");
        Assert.assertEquals("应该相差4周", 4,
                DateBetweenUtils.between(beginDate1, endDate1, ChronoUnit.WEEKS));
        Assert.assertEquals("应该相差3周", 3,
                DateBetweenUtils.between(beginDate2, endDate2, ChronoUnit.WEEKS));


        System.out.println("=====================设置两个日期，包含时刻======================");
        // 设置两个日期，包含时刻
        String beginDateStrA = "2021-08-01 00:00:00";
        String endDateStrA = "2021-08-29 00:00:00";

        String beginDateStrB = "2021-08-01 23:59:59";
        String endDateStrB = "2021-08-29 00:00:00";

        Date beginDateA = DateUtils.parseDate(beginDateStrA, "yyyy-MM-dd HH:mm:ss");
        Date endDateA = DateUtils.parseDate(endDateStrA, "yyyy-MM-dd HH:mm:ss");

        Date beginDateB = DateUtils.parseDate(beginDateStrB, "yyyy-MM-dd HH:mm:ss");
        Date endDateB = DateUtils.parseDate(endDateStrB, "yyyy-MM-dd HH:mm:ss");

        System.out.println("=========带时刻的基于基本数据类型进行比较=========");
        Assert.assertEquals("应该相差4周", 4,
                DateBetweenUtils.between(beginDateA, endDateA, ChronoUnit.WEEKS, true));
        Assert.assertEquals("应该相差3周，不足4周", 3,
                DateBetweenUtils.between(beginDateB, endDateB, ChronoUnit.WEEKS, true));

        System.out.println("=========带时刻的基于 Java 8 进行比较=========");
        Assert.assertEquals("应该相差4周", 4,
                DateBetweenUtils.between(beginDateA, endDateA, ChronoUnit.WEEKS));
        Assert.assertEquals("应该相差3周，不足4周", 3,
                DateBetweenUtils.between(beginDateB, endDateB, ChronoUnit.WEEKS));
    }

    @Test
    public void betweenDayTest() throws ParseException {
        // 这里的测试就和周的测试类似了，只是单位不一样
    }

    @Test
    public void betweenHourTest() throws ParseException {
        // 这里的测试就和周的测试类似了，只是单位不一样
    }

    @Test
    public void betweenMinuteTest() throws ParseException {
        // 这里的测试就和周的测试类似了，只是单位不一样
    }

    @Test
    public void betweenSecondTest() throws ParseException {
        // 这里的测试就和周的测试类似了，只是单位不一样
    }

    @Test
    public void betweenMilliTest() throws ParseException {
        // 这里的测试就和周的测试类似了，只是单位不一样
    }
}
