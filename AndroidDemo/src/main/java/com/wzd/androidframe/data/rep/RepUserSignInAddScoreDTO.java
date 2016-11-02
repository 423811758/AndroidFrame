package com.wzd.androidframe.data.rep;

import com.wzd.androidframe.data.BaseResultDTO;

/**
 * <p>Description: </p>
 * Created by wzd on 2016/11/2.
 */

public class RepUserSignInAddScoreDTO extends BaseResultDTO {
    /** 总积分 */
    private int integralAmount;
    /** 已用积分 */
    private int integralUsed;

    public int getIntegralAmount() {
        return integralAmount;
    }

    public int getIntegralUsed() {
        return integralUsed;
    }
}
