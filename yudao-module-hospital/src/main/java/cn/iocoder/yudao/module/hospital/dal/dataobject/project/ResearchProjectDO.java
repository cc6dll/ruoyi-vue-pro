package cn.iocoder.yudao.module.hospital.dal.dataobject.project;

import lombok.*;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

@TableName("research_project")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResearchProjectDO extends BaseDO {
    @TableId(type = IdType.AUTO)
    private Long projectId;
    private String projectName;
    private Long principalInvestigatorId;
    private Long departmentId;
    private Date startDate;
    private Date endDate;
    private BigDecimal totalFundingAmount;
    private String projectStatus;
    private String projectDescription;
    // tenant_id, creator, create_time, updater, update_time, deleted are in BaseDO
}
