package other.models;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author liuqian
 * @date 2020-09-02 13:28
 */
@Data
@Accessors(prefix = "m")
public class TestModelA {
    private Integer mId;
    private String mName;
}
