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
 * @since 2019-06-19
 */
@TableName("TE_CUS_CERTINFO")
@Data
@ToString
public class CusCertinfo extends Model<CusCertinfo> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_ID)
    private String id;
    @TableField("PCERTID")
    private String pcertid;
    @TableField("TRUSTNO")
    private String trustno;
    @TableField("CUSINFOID")
    private String cusinfoid;
    @TableField("CERTTYPEID")
    private String certtypeid;
    @TableField("DPID")
    private String dpid;
    @TableField("CAINFOID")
    private String cainfoid;
    @TableField("RAINOFID")
    private String rainofid;
    @TableField("CREATEDATE")
    private Date createdate;
    @TableField("LASTMODIFYDATE")
    private Date lastmodifydate;
    @TableField("STARTTIME")
    private Date starttime;
    @TableField("ENDTIME")
    private Date endtime;
    @TableField("SUPERPIN")
    private String superpin;
    @TableField("USERPIN")
    private String userpin;
    @TableField("TEMPLATEID")
    private String templateid;
    @TableField("ONLINETIME")
    private Integer onlinetime;
    @TableField("HANDSELTIME")
    private Integer handseltime;
    @TableField("KEYID")
    private String keyid;
    @TableField("MEDIUMCODE")
    private String mediumcode;
    @TableField("APPLYTYPE")
    private String applytype;
    @TableField("OLD")
    private String old;
    @TableField("STATUS")
    private String status;
    @TableField("ISTEST")
    private String istest;
    @TableField("TOTALAMOUNT")
    private Double totalamount;
    @TableField("CERTUSERID")
    private String certuserid;
    @TableField("CARRIERTYPE")
    private Integer carriertype;
    @TableField("COMMONNAME")
    private String commonname;
    @TableField("UPGRADE_FLAG")
    private Integer upgradeFlag;

    @Override
    protected Serializable pkVal() {
        return null;
    }
}
