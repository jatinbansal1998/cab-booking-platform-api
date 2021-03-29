package org.codejudge.sb.util;

import org.apache.commons.collections4.Transformer;
import org.codejudge.sb.mo.driver.RegisterDriverRequestMO;
import org.codejudge.sb.vo.DriverVO;

public class RegisterDriverRequestMOtoDriverVOTransformer implements Transformer<RegisterDriverRequestMO, DriverVO> {
    @Override
    public DriverVO transform(RegisterDriverRequestMO registerDriverRequestMO) {
        return DriverVO.builder()
                .name(registerDriverRequestMO.getName())
                .email(registerDriverRequestMO.getEmail())
                .phoneNumber(registerDriverRequestMO.getPhoneNumber())
                .licenceNumber(registerDriverRequestMO.getLicenceNumber())
                .carNumber(registerDriverRequestMO.getCarNumber())
                .build();
    }
}
