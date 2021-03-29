package org.codejudge.sb.service;

import org.codejudge.sb.mo.cab.NearByCabRequestMO;
import org.codejudge.sb.mo.cab.NearByCabResponseMO;

import javax.transaction.Transactional;

public interface ICabService {
    @Transactional(Transactional.TxType.REQUIRED)
    NearByCabResponseMO findNearByCabs(NearByCabRequestMO nearByCabRequestMO);
}
