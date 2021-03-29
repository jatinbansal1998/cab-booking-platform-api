package org.codejudge.sb.validator;

import org.codejudge.sb.exception_handling.CustomBusinessException;
import org.codejudge.sb.mo.cab.NearByCabRequestMO;
import org.springframework.stereotype.Component;

@Component
public class CabServiceValidator {
    public void validateFindNearByCabsData(NearByCabRequestMO nearByCabRequestMO) {
        if (nearByCabRequestMO.getLatitude() == null)
            throw new CustomBusinessException("Latitude must not be null");
        if (nearByCabRequestMO.getLongitude() == null)
            throw new CustomBusinessException("Longitude must not be null");
    }
}
