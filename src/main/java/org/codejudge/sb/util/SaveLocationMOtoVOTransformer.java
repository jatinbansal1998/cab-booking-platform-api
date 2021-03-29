package org.codejudge.sb.util;

import org.apache.commons.collections4.Transformer;
import org.codejudge.sb.mo.driver.SaveLocationRequestMO;
import org.codejudge.sb.vo.SaveLocationVO;

public class SaveLocationMOtoVOTransformer implements Transformer<SaveLocationRequestMO, SaveLocationVO> {
    private final long id;

    public SaveLocationMOtoVOTransformer(Long id) {
        this.id = id;
    }

    @Override
    public SaveLocationVO transform(SaveLocationRequestMO saveLocationRequestMO) {
        return SaveLocationVO.builder()
                .id(this.id)
                .latitude(saveLocationRequestMO.getLatitude())
                .longitude(saveLocationRequestMO.getLongitude())
                .build();
    }
}
