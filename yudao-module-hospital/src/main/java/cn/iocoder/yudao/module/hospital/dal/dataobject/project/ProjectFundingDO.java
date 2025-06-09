package cn.iocoder.yudao.module.hospital.dal.dataobject.project;

import lombok.*;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

@TableName("project_funding")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectFundingDO extends BaseDO {
    @TableId(type = IdType.AUTO)
    private Long fundingId;
    private Long projectId;
    private String budgetItemName;
    private String budgetItemCode;
    private BigDecimal amountPlanned;
    private BigDecimal amountReceived;
    private BigDecimal amountSpent;
    private String fundingSource;
    private Date receivedDate;
    private Date expenditureDate;
    private String voucherNumber;
    private String remarks;
}
