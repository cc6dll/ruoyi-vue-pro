package cn.iocoder.yudao.module.hospital.controller.admin.project.vo.achievement;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import javax.validation.constraints.NotNull;

@Schema(description = "Admin - Research Achievement Update Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ResearchAchievementUpdateReqVO extends ResearchAchievementBaseVO {
    @Schema(description = "Achievement ID", required = true, example = "201")
    @NotNull(message = "Achievement ID cannot be null")
    private Long achievementId;
}
