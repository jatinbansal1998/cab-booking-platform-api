package org.codejudge.sb.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.codejudge.sb.mo.BaseResponseMO;
import org.codejudge.sb.mo.MessageResponseMO;
import org.codejudge.sb.mo.cab.NearByCabRequestMO;
import org.codejudge.sb.mo.cab.NearByCabResponseMO;
import org.codejudge.sb.service.ICabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/passenger")
@Slf4j
public class CabController {

    private ICabService cabService;

    @Autowired
    public void setCabService(ICabService cabService) {
        this.cabService = cabService;
    }

    @ApiOperation("Get Nearby Cabs")
    @PostMapping("/available_cabs")
    public ResponseEntity<BaseResponseMO> getNearByCabs(@RequestBody NearByCabRequestMO nearByCabRequestMO) {
        log.info("Get NearByCabs request: " + nearByCabRequestMO);
        NearByCabResponseMO foundCabs = cabService.findNearByCabs(nearByCabRequestMO);
        if (foundCabs.getAvailableCabs().isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(new MessageResponseMO("No cabs available!"));
        }
        log.info("Get NearByCabs response: " + foundCabs);
        return ResponseEntity.status(HttpStatus.OK).body(foundCabs);
    }
}
