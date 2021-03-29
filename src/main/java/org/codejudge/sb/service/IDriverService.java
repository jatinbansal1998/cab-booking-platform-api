package org.codejudge.sb.service;

import org.codejudge.sb.entity.Driver;
import org.codejudge.sb.vo.DriverVO;
import org.codejudge.sb.vo.SaveLocationVO;

import java.util.Optional;

public interface IDriverService {
    Driver registerDriver(DriverVO driverVO);

    Driver saveLocationOfDriver(SaveLocationVO saveLocationVO);

    Optional<Driver> findDriver(Long id);
}
