package org.codejudge.sb.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.codejudge.sb.constants.Status;
import org.codejudge.sb.entity.Driver;
import org.codejudge.sb.exception_handling.CustomNotFoundException;
import org.codejudge.sb.mo.BaseResponseMO;
import org.codejudge.sb.mo.SuccessResponseMO;
import org.codejudge.sb.mo.driver.RegisterDriverRequestMO;
import org.codejudge.sb.mo.driver.SaveLocationRequestMO;
import org.codejudge.sb.service.IDriverService;
import org.codejudge.sb.util.DriverToRegisterDriverResponseMO;
import org.codejudge.sb.util.RegisterDriverRequestMOtoDriverVOTransformer;
import org.codejudge.sb.util.SaveLocationMOtoVOTransformer;
import org.codejudge.sb.vo.DriverVO;
import org.codejudge.sb.vo.SaveLocationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/driver")
@Slf4j
public class DriverController {

    private IDriverService driverService;

    @Autowired
    public void setDriverService(IDriverService driverService) {
        this.driverService = driverService;
    }

    @ApiOperation("Find Driver by ID")
    @GetMapping("/find/{id}")
    public ResponseEntity<Object> findDriver(@PathVariable(value = "id") Long id) {
        Optional<Driver> driverOptional = driverService.findDriver(id);
        if (!driverOptional.isPresent())
            throw new CustomNotFoundException("Driver ID not found");
        return ResponseEntity.status(HttpStatus.FOUND).body(driverOptional.get());
    }

    @ApiOperation("Register a driver")
    @PostMapping("/register")
    public ResponseEntity<BaseResponseMO> registerDriver(@RequestBody RegisterDriverRequestMO requestMO) {
        log.info("ResisterDriver request: " + requestMO);
        DriverVO driverVO = new RegisterDriverRequestMOtoDriverVOTransformer().transform(requestMO);
        Driver driver = driverService.registerDriver(driverVO);
        log.info("ResisterDriver response: " + driver);
        return ResponseEntity.status(HttpStatus.CREATED).body(new DriverToRegisterDriverResponseMO().transform(driver));
    }

    @ApiOperation("Share Driver Location")
    @PostMapping("/{id}/sendLocation")
    public ResponseEntity<BaseResponseMO> saveDriverLocation(@RequestBody SaveLocationRequestMO requestMO, @PathVariable(value = "id") Long id) {
        log.info("SaveDriverLocation request: id= " + id + " " + requestMO);
        SaveLocationVO saveLocationVO = new SaveLocationMOtoVOTransformer(id).transform(requestMO);
        Driver driver = driverService.saveLocationOfDriver(saveLocationVO);
        log.info("SaveDriverLocation response: " + driver);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new SuccessResponseMO(Status.SUCCESS.getValue()));
    }
}
