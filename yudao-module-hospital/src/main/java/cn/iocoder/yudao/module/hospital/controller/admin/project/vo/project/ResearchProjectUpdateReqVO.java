package cn.iocoder.yudao.module.hospital.controller.admin.project.vo.project;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import javax.validation.constraints.NotNull;

@Schema(description = "Admin - Research Project Update Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ResearchProjectUpdateReqVO extends ResearchProjectBaseVO {
    @Schema(description = "Project ID", required = true, example = "1")
    @NotNull(message = "Project ID cannot be null")
    private Long projectId;
}
