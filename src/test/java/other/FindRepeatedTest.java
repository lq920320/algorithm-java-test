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
        users.add(new User("xpf1", "1238", 18));
        users.add(new User("xpf2", "1234", 18));
        users.add(new User("xpf3", "1235", 18));
        users.add(new User("xpf", "1236", 18));
        users.add(new User("xpf", "1237", 18));
        users.add(new User("xpf", "1237", 18));
        users.add(new User("xpf1", "1239", 18));
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
    private class User {
        private String userName;
        private String userNo;
        private Integer age;
    }


}