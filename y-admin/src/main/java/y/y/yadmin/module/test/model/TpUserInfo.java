package y.y.yadmin.module.test.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 用户信息实例表
 * </p>
 *
 * @author lmc
 * @since 2019-07-18
 */
@TableName("tp_user_info")
public class TpUserInfo extends Model<TpUserInfo> {

    private static final long serialVersionUID = 1L;

    private String id;
    /**
     * 受理单号
     */
    @TableField("bus_code")
    private String busCode;
    /**
     * 名称
     */
    private String cn;
    /**
     * 身份证号码
     */
    @TableField("card_no")
    private String cardNo;
    /**
     * 1个人 2 机构  3 其他
     */
    private String type;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 电子邮件
     */
    private String email;
    /**
     * 状态
     */
    private String status;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBusCode() {
        return busCode;
    }

    public void setBusCode(String busCode) {
        this.busCode = busCode;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TpUserInfo{" +
        "id=" + id +
        ", busCode=" + busCode +
        ", cn=" + cn +
        ", cardNo=" + cardNo +
        ", type=" + type +
        ", mobile=" + mobile +
        ", email=" + email +
        ", status=" + status +
        "}";
    }
}