package org.codejudge.sb.service;

import lombok.extern.slf4j.Slf4j;
import org.codejudge.sb.business_object.IDriverBusinessObject;
import org.codejudge.sb.entity.Driver;
import org.codejudge.sb.validator.DriverValidator;
import org.codejudge.sb.vo.DriverVO;
import org.codejudge.sb.vo.SaveLocationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Slf4j
@Service("driverService")
public class DriverService implements IDriverService {

    private DriverValidator driverValidator;
    private IDriverBusinessObject driverBusinessObject;

    @Autowired
    public void setDriverValidator(DriverValidator driverValidator) {
        this.driverValidator = driverValidator;
    }

    @Autowired
    public void setDriverBusinessObject(IDriverBusinessObject driverBusinessObject) {
        this.driverBusinessObject = driverBusinessObject;
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Driver registerDriver(DriverVO driverVO) {
        driverValidator.registerDriverDataValidator(driverVO);
        return driverBusinessObject.registerDriver(driverVO);
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Driver saveLocationOfDriver(SaveLocationVO saveLocationVO) {
        driverValidator.saveLocationOfDriverDataValidator(saveLocationVO);
        return driverBusinessObject.saveLocationOfDriver(saveLocationVO);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public Optional<Driver> findDriver(Long id) {
        return driverBusinessObject.findDriver(id);
    }
}
