package org.hiforce.lattice.sample.starter;

import org.hiforce.lattice.runtime.Lattice;
import org.hiforce.lattice.sample.service.PlaceOrderService;
import org.hiforce.lattice.sample.service.params.PlaceOrderReqDTO;
import org.hiforce.lattice.sample.service.server.PlaceOrderServiceServer;

/**
 * @author Rocky Yu
 * @since 2022/9/28
 */
public class LatticeUseCaseSample {

    public static void main(String[] args) {
        Lattice.getInstance().setSimpleMode(true);
        Lattice.getInstance().start();


        PlaceOrderService placeOrderService = new PlaceOrderServiceServer();
        PlaceOrderReqDTO reqDTO = new PlaceOrderReqDTO();
        reqDTO.setBuyQuantity(1);
        reqDTO.setItemId(100100221121L);
        placeOrderService.createOrder(reqDTO);
    }
}
