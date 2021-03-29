package org.codejudge.sb.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaveLocationVO implements Serializable {
    private static final long serialVersionUID = 2020952369498000845L;
    private Long id;
    private Double latitude;
    private Double longitude;
}
