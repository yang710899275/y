package y.y.yadmin.module.test.model.ra;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2019-04-24
 */
@TableName("TP_BUS_CERTINFO")
@Data
@ToString
public class BusCertinfo extends Model<BusCertinfo> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    @TableField("INSTANCEID")
    private String instanceid;
    @TableField("ACCEPTCODE")
    private String acceptcode;
    @TableField("CERTID")
    private String certid;
    @TableField("CERTTYPEID")
    private String certtypeid;
    @TableField("CERTTAMPLATEID")
    private String certtamplateid;
    @TableField("PCERTID")
    private String pcertid;
    @TableField("TRUSTNO")
    private String trustno;
    @TableField("CAINFOID")
    private String cainfoid;
    @TableField("STARTTIME")
    private Date starttime;
    @TableField("ENDTIME")
    private Date endtime;
    @TableField("SUPERPIN")
    private String superpin;
    @TableField("USERPIN")
    private String userpin;
    @TableField("KEYID")
    private String keyid;
    @TableField("MEDIUMCODE")
    private String mediumcode;
    @TableField("CHANGETIMEFLAG")
    private String changetimeflag;
    @TableField("CERTUSERID")
    private String certuserid;
    @TableField("TOTALAMOUNT")
    private Integer totalamount;
    @TableField("OLDSTARTTIME")
    private Date oldstarttime;
    @TableField("OLDENDTIME")
    private Date oldendtime;
    @TableField("CARRIERTYPE")
    private Integer carriertype;
    @TableField("UPGRADE_FLAG")
    private Integer upgradeFlag;

    @Override
    protected Serializable pkVal() {
        return null;
    }

}
