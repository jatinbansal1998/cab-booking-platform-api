package org.codejudge.sb.mo.driver;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel
public class RegisterDriverRequestMO implements Serializable {

    private static final long serialVersionUID = -6568520192038829757L;

    @ApiModelProperty(required = true, value = "Driver Name", dataType = "String", example = "Jon Doe")
    private String name;
    @ApiModelProperty(required = true, value = "Driver Email Address", dataType = "String", example = "jondoe@example.com")
    private String email;
    @ApiModelProperty(required = true, value = "Driver Phone Number 10 digits", dataType = "Number", example = "9999999999")
    @JsonProperty(value = "phone_number")
    private Long phoneNumber;
    @ApiModelProperty(required = true, value = "Driver Licence Number", dataType = "String", example = "DL_NUMBER")
    @JsonProperty(value = "license_number")
    private String licenceNumber;
    @ApiModelProperty(required = true, value = "Car Number", dataType = "String", example = "DL9A9999")
    @JsonProperty(value = "car_number")
    private String carNumber;
}
