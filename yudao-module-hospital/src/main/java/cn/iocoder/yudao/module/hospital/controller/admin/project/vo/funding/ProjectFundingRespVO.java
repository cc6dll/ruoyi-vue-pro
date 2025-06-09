package cn.iocoder.yudao.module.hospital.controller.admin.project.vo.funding;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.Date;

@Schema(description = "Admin - Project Funding Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ProjectFundingRespVO extends ProjectFundingBaseVO {
    @Schema(description = "Funding ID", required = true, example = "101")
    private Long fundingId;

    @Schema(description = "Create Time", required = true)
    private Date createTime;
}
