package utils;

import cn.hutool.core.lang.Assert;

import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Calendar;
import java.util.Date;

/**
 * 比较两个日期的间隔
 *
 * @author zetu
 * @date 2021/8/26
 */
public class DateBetweenUtils {


    /**
     * 计算两个日期相隔年数
     * 在非重置情况下，如果起始日期的月大于结束日期的月，年数要少算1（不足1年）
     *
     * @param beginDate 起始日期
     * @param endDate   末端日期
     * @param isReset   是否重置时间为起始时间（重置天时分秒）
     * @return 相隔的年数
     */
    public static long betweenYear(Date beginDate, Date endDate, boolean isReset) {
        Assert.notNull(beginDate, "Begin date is null !");
        Assert.notNull(endDate, "End date is null !");

        final Calendar beginCal = getCalendar(beginDate);
        final Calendar endCal = getCalendar(endDate);

        int result = endCal.get(Calendar.YEAR) - beginCal.get(Calendar.YEAR);
        if (!isReset) {
            // 考虑闰年的2月情况
            if (Calendar.FEBRUARY == beginCal.get(Calendar.MONTH) && Calendar.FEBRUARY == endCal.get(Calendar.MONTH)) {
                if (beginCal.get(Calendar.DAY_OF_MONTH) == beginCal.getActualMaximum(Calendar.DAY_OF_MONTH)
                        && endCal.get(Calendar.DAY_OF_MONTH) == endCal.getActualMaximum(Calendar.DAY_OF_MONTH)) {
                    // 两个日期都位于2月的最后一天，此时月数按照相等对待，此时都设置为1号
                    beginCal.set(Calendar.DAY_OF_MONTH, 1);
                    endCal.set(Calendar.DAY_OF_MONTH, 1);
                }
            }

            endCal.set(Calendar.YEAR, beginCal.get(Calendar.YEAR));
            long between = endCal.getTimeInMillis() - beginCal.getTimeInMillis();
            if (between < 0) {
                return result - 1;
            }
        }
        return result;
    }

    /**
     * 计算两个日期相隔月数
     * 在非重置情况下，如果起始日期的天大于结束日期的天，月数要少算1（不足1个月）
     *
     * @param beginDate 起始日期
     * @param endDate   末端日期
     * @param isReset   是否重置时间为起始时间（重置天时分秒）
     * @return 相隔的月份数
     */
    public static long betweenMonth(Date beginDate, Date endDate, boolean isReset) {
        Assert.notNull(beginDate, "Begin date is null !");
        Assert.notNull(endDate, "End date is null !");

        final Calendar beginCal = getCalendar(beginDate);
        final Calendar endCal = getCalendar(endDate);
        int betweenYear = endCal.get(Calendar.YEAR) - beginCal.get(Calendar.YEAR);
        int betweenMonthOfYear = endCal.get(Calendar.MONTH) - beginCal.get(Calendar.MONTH);
        long result = betweenYear * 12L + betweenMonthOfYear;
        if (!isReset) {
            endCal.set(Calendar.YEAR, beginCal.get(Calendar.YEAR));
            endCal.set(Calendar.MONTH, beginCal.get(Calendar.MONTH));
            long between = endCal.getTimeInMillis() - beginCal.getTimeInMillis();
            if (between < 0L) {
                return result - 1;
            }
        }
        return result;
    }

    /**
     * 计算两个日期相隔周数
     *
     * @param beginDate  起始日期
     * @param endDate    末端日期
     * @param chronoUnit 时间单位
     * @param isAbs      是否取绝对值
     * @return 相隔的周数
     */
    public static long between(Date beginDate, Date endDate, ChronoUnit chronoUnit, boolean isAbs) {
        Assert.notNull(beginDate, "Begin date is null !");
        Assert.notNull(endDate, "End date is null !");

        Date begin = beginDate;
        Date end = endDate;
        if (isAbs && beginDate.after(endDate)) {
            // 间隔只为正数的情况下，如果开始日期晚于结束日期，置换之
            begin = endDate;
            end = beginDate;
        }
        // 获取差值
        long diff = end.getTime() - begin.getTime();
        return diff / chronoUnit.getDuration().toMillis();
    }

    /**
     * 比较两个日期相隔，基于 java 8 实现
     *
     * @param beginDate  起始日期带时刻
     * @param endDate    末端日期带时刻
     * @param chronoUnit 时间单位
     * @return 相隔数
     */
    public static long between(Date beginDate, Date endDate, ChronoUnit chronoUnit) {
        Temporal beginTemp = beginDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        Temporal endTemp = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        // or alternatively
        // beginTemp.until(endTemp, chronoUnit);
        return chronoUnit.between(beginTemp, endTemp);
    }

    /**
     * 比较两个日期相隔月数，基于 java 8 实现
     *
     * @param beginDate 起始日期带时刻
     * @param endDate   末端日期带时刻
     * @return 相隔的月份数
     */
    public static long betweenMonth(Date beginDate, Date endDate) {
        Temporal beginTemp = beginDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        Temporal endTemp = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        // or alternatively
        // beginTemp.until(endTemp, ChronoUnit.MONTHS);
        return ChronoUnit.MONTHS.between(beginTemp, endTemp);
    }

    /**
     * 将 date 转为 Calendar
     *
     * @param date 日期
     * @return calendar
     */
    private static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date.getTime());
        return cal;
    }
}
