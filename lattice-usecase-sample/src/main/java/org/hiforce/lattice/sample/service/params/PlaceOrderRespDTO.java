package org.hiforce.lattice.sample.service.params;

import lombok.Getter;

import java.io.Serializable;

/**
 * @author Rocky Yu
 * @since 2022/9/28
 */
public class PlaceOrderRespDTO implements Serializable {

    private static final long serialVersionUID = -8942563812910806993L;

    @Getter
    private boolean success;

    public static PlaceOrderRespDTO success() {
        PlaceOrderRespDTO respDTO = new PlaceOrderRespDTO();
        respDTO.success = true;
        return respDTO;
    }
}
