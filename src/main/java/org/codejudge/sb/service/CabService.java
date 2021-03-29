package org.codejudge.sb.service;

import lombok.extern.slf4j.Slf4j;
import org.codejudge.sb.entity.Driver;
import org.codejudge.sb.mo.cab.NearByCabRequestMO;
import org.codejudge.sb.mo.cab.NearByCabResponseMO;
import org.codejudge.sb.repository.IDriverRepository;
import org.codejudge.sb.util.Haversine;
import org.codejudge.sb.validator.CabServiceValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("cabService")
@Slf4j
public class CabService implements ICabService {

    private IDriverRepository driverRepository;
    private CabServiceValidator cabServiceValidator;

    @Autowired
    public void setDriverRepository(IDriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Autowired
    public void setCabServiceValidator(CabServiceValidator cabServiceValidator) {
        this.cabServiceValidator = cabServiceValidator;
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public NearByCabResponseMO findNearByCabs(NearByCabRequestMO nearByCabRequestMO) {
        NearByCabResponseMO nearByCabResponseMO = new NearByCabResponseMO();
        cabServiceValidator.validateFindNearByCabsData(nearByCabRequestMO);
        List<Driver> listOfAllDriver = driverRepository.findAll();
        listOfAllDriver.stream().forEach(driver -> {
            if (driver.getLocation() != null) {
                double distance = Haversine.haversine(driver.getLocation().getLatitude(), driver.getLocation().getLongitude(), nearByCabRequestMO.getLatitude(), nearByCabRequestMO.getLongitude());
                if (Math.abs(distance) <= 4) {
                    log.info("Found Cab " + Math.abs(distance) + " distance far with Driver: ", driver);
                    nearByCabResponseMO.addAvailableCab(driver);
                }
            }
        });
        return nearByCabResponseMO;
    }
}
