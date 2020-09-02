package other.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liuqian
 * @date 2020-09-02 14:09
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestModelD {
    private Integer id;
    private String name;
}
