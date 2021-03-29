package org.codejudge.sb.validator;

import org.codejudge.sb.exception_handling.CustomBusinessException;
import org.codejudge.sb.vo.DriverVO;
import org.codejudge.sb.vo.SaveLocationVO;
import org.springframework.stereotype.Component;

@Component
public class DriverValidator {
    public void registerDriverDataValidator(DriverVO driverVO) {
        if (driverVO.getName() == null || driverVO.getName().isEmpty())
            throw new CustomBusinessException("Driver name should not be null and not empty");
        if (driverVO.getEmail() == null || driverVO.getEmail().isEmpty())
            throw new CustomBusinessException("Driver email should not be null and not empty");
        if (!driverVO.getEmail().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z]+[.][a-zA-Z0-9.-]+$"))
            throw new CustomBusinessException("invalid email address");
        if (driverVO.getPhoneNumber() == null || driverVO.getPhoneNumber() < 1000000000L || driverVO.getPhoneNumber() > 9999999999L)
            throw new CustomBusinessException("driver number is mandatory and should be 10 digits");
        if (driverVO.getLicenceNumber() == null || driverVO.getLicenceNumber().isEmpty())
            throw new CustomBusinessException("Driver Licence Number should not be null and not empty");
        if (driverVO.getCarNumber() == null || driverVO.getCarNumber().isEmpty())
            throw new CustomBusinessException("Driver Car Number should not be null and not empty");
    }

    public void saveLocationOfDriverDataValidator(SaveLocationVO saveLocationVO) {
        if (saveLocationVO.getId() == null)
            throw new CustomBusinessException("Driver ID cannot be null");
        if (saveLocationVO.getLatitude() == null)
            throw new CustomBusinessException("Latitude should not be null");
        if (saveLocationVO.getLongitude() == null)
            throw new CustomBusinessException("Longitude should not be null");
    }
}
