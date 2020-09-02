package other.models;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author liuqian
 * @date 2020-09-02 13:28
 */
@Data
@Accessors(fluent = true)
public class TestModelB {
    private Integer id;
    private String name;
}
