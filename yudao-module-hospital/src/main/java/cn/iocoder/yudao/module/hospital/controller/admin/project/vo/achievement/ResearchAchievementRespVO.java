package cn.iocoder.yudao.module.hospital.controller.admin.project.vo.achievement;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.Date;

@Schema(description = "Admin - Research Achievement Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ResearchAchievementRespVO extends ResearchAchievementBaseVO {
    @Schema(description = "Achievement ID", required = true, example = "201")
    private Long achievementId;

    @Schema(description = "Create Time", required = true)
    private Date createTime;
}
