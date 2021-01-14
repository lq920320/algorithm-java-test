package lintcode.microsoft;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author liuqian
 * @date 2021/1/14 21:45.
 */
public class MeetingRooms {
    /**
     * 920. 会议室
     * <p>
     * 给定一系列的会议时间间隔，包括起始和结束时间[[s1,e1]，[s2,e2]，…(si < ei)，确定一个人是否可以参加所有会议。
     * 样例
     * <p>
     * 样例1
     * <p>
     * 输入: intervals = [(0,30),(5,10),(15,20)]
     * 输出: false
     * 解释:
     * (0,30), (5,10) 和 (0,30),(15,20) 这两对会议会冲突
     * <p>
     * 样例2
     * <p>
     * 输入: intervals = [(5,8),(9,15)]
     * 输出: true
     * 解释:
     * 这两个时间段不会冲突
     * <p>
     * 注意事项
     * <p>
     * (0,8),(8,10)在8这一时刻不冲突
     */
    @Test
    public void meetingRoomsTest() {
        List<Interval> intervals1 = new ArrayList<Interval>() {{
            add(new Interval(0, 30));
            add(new Interval(5, 10));
            add(new Interval(15, 20));
        }};
        List<Interval> intervals2 = new ArrayList<Interval>() {{
            add(new Interval(5, 8));
            add(new Interval(9, 15));
        }};
        List<Interval> intervals3 = new ArrayList<Interval>() {{
            add(new Interval(0, 8));
            add(new Interval(8, 10));
        }};
        System.out.println(solution(intervals1));
        System.out.println(solution(intervals2));
        System.out.println(solution(intervals3));
    }

    public class Interval {
        int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public boolean solution(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return true;
        }
        intervals.sort(Comparator.comparingInt(a -> a.start));
        for (int i = 0; i < intervals.size() - 1; i++) {
            if (intervals.get(i).start == intervals.get(i + 1).start) {
                return false;
            }
            if (intervals.get(i).end > intervals.get(i + 1).start) {
                return false;
            }
        }

        return true;
    }
}
