package org.codejudge.sb.mo.cab;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codejudge.sb.mo.BaseResponseMO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel
public class CarResponseMO extends BaseResponseMO {
    @ApiModelProperty(required = true, value = "Driver Name", dataType = "String", example = "Jon Doe")
    private String name;
    @ApiModelProperty(required = true, value = "Car Number", dataType = "String", example = "DL9A9999")
    @JsonProperty("car_number")
    private String carNumber;
    @ApiModelProperty(required = true, value = "Driver Phone Number 10 digits", dataType = "Number", example = "9999999999")
    @JsonProperty("phone_number")
    private Long phoneNumber;
}
