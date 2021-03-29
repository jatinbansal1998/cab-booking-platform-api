package org.codejudge.sb.business_object;

import org.codejudge.sb.entity.Driver;
import org.codejudge.sb.entity.Location;
import org.codejudge.sb.exception_handling.CustomNotFoundException;
import org.codejudge.sb.repository.IDriverRepository;
import org.codejudge.sb.vo.DriverVO;
import org.codejudge.sb.vo.SaveLocationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DriverBusinessObject implements IDriverBusinessObject {
    private IDriverRepository driverRepository;

    @Autowired
    public void setDriverRepository(IDriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public Driver registerDriver(DriverVO driverVO) {
        Driver driver = Driver.builder()
                .name(driverVO.getName())
                .email(driverVO.getEmail())
                .phoneNumber(driverVO.getPhoneNumber())
                .licenceNumber(driverVO.getLicenceNumber())
                .carNumber(driverVO.getCarNumber())
                .build();
        return this.driverRepository.save(driver);
    }

    @Override
    public Driver saveLocationOfDriver(SaveLocationVO saveLocationVO) {
        Optional<Driver> driverOptional = this.driverRepository.findById(saveLocationVO.getId());
        if (!driverOptional.isPresent())
            throw new CustomNotFoundException("Driver ID not Found");
        Driver driver = driverOptional.get();
        driver.setLocation(
                Location.builder()
                        .latitude(saveLocationVO.getLatitude())
                        .longitude(saveLocationVO.getLongitude())
                        .build()
        );
        return this.driverRepository.save(driver);
    }

    public Optional<Driver> findDriver(Long id) {
        return driverRepository.findById(id);
    }
}
