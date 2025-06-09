package cn.iocoder.yudao.module.hospital.controller.admin.project.vo.project;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.Date;

@Schema(description = "Admin - Research Project Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ResearchProjectRespVO extends ResearchProjectBaseVO {
    @Schema(description = "Project ID", required = true, example = "1")
    private Long projectId;

    @Schema(description = "Create Time", required = true)
    private Date createTime;
}
