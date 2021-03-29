package org.codejudge.sb.mo.cab;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codejudge.sb.entity.Driver;
import org.codejudge.sb.mo.BaseResponseMO;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@ApiModel
@AllArgsConstructor
@NoArgsConstructor
public class NearByCabResponseMO extends BaseResponseMO {
    @ApiModelProperty(value = "List of available Cabs")
    @JsonProperty("available_cabs")
    private List<CarResponseMO> availableCabs = new ArrayList<>();

    public List<CarResponseMO> addAvailableCab(Driver driver) {
        availableCabs.add(CarResponseMO.builder()
                .carNumber(driver.getCarNumber())
                .name(driver.getName())
                .phoneNumber(driver.getPhoneNumber())
                .build()
        );
        return this.availableCabs;
    }
}
