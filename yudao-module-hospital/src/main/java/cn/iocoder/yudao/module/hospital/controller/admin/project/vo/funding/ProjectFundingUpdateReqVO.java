package cn.iocoder.yudao.module.hospital.controller.admin.project.vo.funding;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import javax.validation.constraints.NotNull;

@Schema(description = "Admin - Project Funding Update Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ProjectFundingUpdateReqVO extends ProjectFundingBaseVO {
    @Schema(description = "Funding ID", required = true, example = "101")
    @NotNull(message = "Funding ID cannot be null")
    private Long fundingId;
}
