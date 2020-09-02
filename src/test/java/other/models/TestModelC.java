package other.models;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author liuqian
 * @date 2020-09-02 13:28
 */
@Data
@Accessors(chain = true)
public class TestModelC {
    private Integer id;
    private String name;
}
