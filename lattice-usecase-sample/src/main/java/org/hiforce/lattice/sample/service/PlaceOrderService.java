package org.hiforce.lattice.sample.service;

import org.hiforce.lattice.sample.service.params.PlaceOrderReqDTO;
import org.hiforce.lattice.sample.service.params.PlaceOrderRespDTO;

/**
 * @author Rocky Yu
 * @since 2022/9/28
 */
public interface PlaceOrderService {

    PlaceOrderRespDTO createOrder(PlaceOrderReqDTO reqDTO);
}
