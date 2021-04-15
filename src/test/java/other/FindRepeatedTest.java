package other;

import cn.hutool.json.JSONUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author liuqian
 * @date 2019/10/27 14:30
 */
public class FindRepeatedTest {

    /**
     * 找到名字重复的数据并计数
     */
    @Test
    public void findRepeatedTest() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            User user = new User();
            user.setUserName("xpf" + (i % 3));
            user.setUserNo("123" + (i % 3));
            user.setAge(18);
            users.add(user);
        }
        Map<String, Long> collect = users.stream()
          .map(User::getUserName)
          .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(JSONUtil.toJsonStr(collect));

        List<String> result = new ArrayList<>();
        collect.forEach((k, v) -> {
            if (v > 1) result.add(k);
        });
        System.out.println(result.toString());
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class User {
        private String userName;
        private String userNo;
        private Integer age;
    }


}