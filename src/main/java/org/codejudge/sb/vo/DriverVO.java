package org.codejudge.sb.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codejudge.sb.entity.Driver;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DriverVO implements Serializable {
    private static final long serialVersionUID = -8109117606618932938L;
    private Driver driver;
    private String name;
    private String email;
    private Long phoneNumber;
    private String licenceNumber;
    private String carNumber;
}
