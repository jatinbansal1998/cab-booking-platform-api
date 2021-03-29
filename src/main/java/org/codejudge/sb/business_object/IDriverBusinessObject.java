package org.codejudge.sb.business_object;

import org.codejudge.sb.entity.Driver;
import org.codejudge.sb.vo.DriverVO;
import org.codejudge.sb.vo.SaveLocationVO;

import java.util.Optional;

public interface IDriverBusinessObject {
    Driver registerDriver(DriverVO driverVO);

    Driver saveLocationOfDriver(SaveLocationVO saveLocationVO);

    Optional<Driver> findDriver(Long id);
}
