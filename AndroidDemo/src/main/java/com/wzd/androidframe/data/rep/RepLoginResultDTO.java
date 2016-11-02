package com.wzd.androidframe.data.rep;

import com.wzd.androidframe.data.BaseResultDTO;

/**
 * <p>Description: </p>
 * Created by wzd on 2016/11/2.
 */

public class RepLoginResultDTO extends BaseResultDTO {
    private String token;

    private RepUserDTO userDTO;

    private RepUserCustomerDTO customer;

    public String getToken() {
        return token;
    }

    public RepUserCustomerDTO getCustomer() {
        return customer;
    }

    public RepUserDTO getUserDTO() {
        return userDTO;
    }

}
