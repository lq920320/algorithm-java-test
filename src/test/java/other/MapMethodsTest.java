package other;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuqian
 * @date 2019/10/7 19:11.
 */
public class MapMethodsTest {

    @Test
    public void mapMergeTest() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<StudentScore> studentScoreList = buildATestList();
        // 按照学生分组，求得每个学生的总分
        // 常规做法
        Map<String, Integer> studentScoreMap = new HashMap<>();
        studentScoreList.forEach(studentScore -> {
            if (studentScoreMap.containsKey(studentScore.getStuName())) {
                studentScoreMap.put(studentScore.getStuName(), studentScoreMap.get(studentScore.getStuName()) + studentScore.getScore());
            } else {
                studentScoreMap.put(studentScore.getStuName(), studentScore.getScore());
            }
        });
        // {"李四":228,"张三":215,"王五":235}
        System.out.println(objectMapper.writeValueAsString(studentScoreMap));

        // merge() 方法
        Map<String, Integer> studentScoreMap2 = new HashMap<>();
        studentScoreList.forEach(studentScore -> studentScoreMap2.merge(
          studentScore.getStuName(),
          studentScore.getScore(),
          Integer::sum));
        // {"李四":228,"张三":215,"王五":235}
        System.out.println(objectMapper.writeValueAsString(studentScoreMap2));
    }

    @Test
    public void mapComputeTest() {
        String k = "key";
        Map<String, Integer> map = new HashMap<String, Integer>() {{
            put(k, 1);
        }};
        // 2
        System.out.println(map.compute(k, (key, oldVal) -> oldVal + 1));
    }

    private List<StudentScore> buildATestList() {
        List<StudentScore> studentScoreList = new ArrayList<>();
        StudentScore studentScore1 = new StudentScore() {{
            setStuName("张三");
            setSubject("语文");
            setScore(70);
        }};
        StudentScore studentScore2 = new StudentScore() {{
            setStuName("张三");
            setSubject("数学");
            setScore(80);
        }};
        StudentScore studentScore3 = new StudentScore() {{
            setStuName("张三");
            setSubject("英语");
            setScore(65);
        }};
        StudentScore studentScore4 = new StudentScore() {{
            setStuName("李四");
            setSubject("语文");
            setScore(68);
        }};
        StudentScore studentScore5 = new StudentScore() {{
            setStuName("李四");
            setSubject("数学");
            setScore(70);
        }};
        StudentScore studentScore6 = new StudentScore() {{
            setStuName("李四");
            setSubject("英语");
            setScore(90);
        }};
        StudentScore studentScore7 = new StudentScore() {{
            setStuName("王五");
            setSubject("语文");
            setScore(80);
        }};
        StudentScore studentScore8 = new StudentScore() {{
            setStuName("王五");
            setSubject("数学");
            setScore(85);
        }};
        StudentScore studentScore9 = new StudentScore() {{
            setStuName("王五");
            setSubject("英语");
            setScore(70);
        }};

        studentScoreList.add(studentScore1);
        studentScoreList.add(studentScore2);
        studentScoreList.add(studentScore3);
        studentScoreList.add(studentScore4);
        studentScoreList.add(studentScore5);
        studentScoreList.add(studentScore6);
        studentScoreList.add(studentScore7);
        studentScoreList.add(studentScore8);
        studentScoreList.add(studentScore9);

        return studentScoreList;
    }

    @Data
    private class StudentScore {
        private String stuName;
        private String subject;
        private Integer score;
    }
}
