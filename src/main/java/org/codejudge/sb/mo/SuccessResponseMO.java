package org.codejudge.sb.mo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel
public class SuccessResponseMO extends BaseResponseMO {
    @ApiModelProperty(notes = "Status")
    private String status;
}
