package org.codejudge.sb.util;

import org.apache.commons.collections4.Transformer;
import org.codejudge.sb.entity.Driver;
import org.codejudge.sb.mo.driver.RegisterDriverResponseMO;

public class DriverToRegisterDriverResponseMO implements Transformer<Driver, RegisterDriverResponseMO> {
    @Override
    public RegisterDriverResponseMO transform(Driver driver) {
        return RegisterDriverResponseMO.builder()
                .id(driver.getId())
                .name(driver.getName())
                .email(driver.getEmail())
                .phoneNumber(driver.getPhoneNumber())
                .licenceNumber(driver.getLicenceNumber())
                .carNumber(driver.getCarNumber())
                .build();

    }
}
