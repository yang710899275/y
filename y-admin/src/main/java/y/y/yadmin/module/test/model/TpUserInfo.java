package y.y.yadmin.module.test.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@TableName("tp_user_info")
@Data
@ToString
public class TpUserInfo extends Model<TpUserInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 受理单号
     */
    @TableField("bus_code")
    @NotNull(message = "busCode不能为空")
    private String busCode;
    /**
     * 名称
     */
    @NotNull(message = "cn不能为空")
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

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
