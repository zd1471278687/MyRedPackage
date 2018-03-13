package app.zd.myredpackage.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 红包相关参数
 * Created by zhangdong on 2018/3/11.
 */

public class RedPackageParam implements Serializable {
    public BigDecimal amount; //金额
    public BigDecimal number; //数量
    public String describe;
}
