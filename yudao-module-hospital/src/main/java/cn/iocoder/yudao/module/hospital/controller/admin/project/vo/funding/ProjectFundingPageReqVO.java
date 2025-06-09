package cn.iocoder.yudao.module.hospital.controller.admin.project.vo.funding;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - Project Funding Page Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ProjectFundingPageReqVO extends PageParam {
    @Schema(description = "Project ID", example = "1")
    private Long projectId;

    @Schema(description = "Budget Item Name", example = "Equipment")
    private String budgetItemName;

    @Schema(description = "Funding Source", example = "Gov")
    private String fundingSource;
}
