package org.codejudge.sb.mo.cab;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@ApiModel
public class NearByCabRequestMO implements Serializable {
    private static final long serialVersionUID = 6718454816464069740L;

    @ApiModelProperty(required = true, value = "Driver Latitude", dataType = "Double", example = "12.972442")
    @NotNull
    private Double latitude;
    @ApiModelProperty(required = true, value = "Driver Longitude", dataType = "Double", example = "77.580643")
    @NotNull
    private Double longitude;
}
