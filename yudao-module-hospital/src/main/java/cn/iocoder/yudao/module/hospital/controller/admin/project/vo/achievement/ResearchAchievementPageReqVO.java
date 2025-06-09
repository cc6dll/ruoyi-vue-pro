package cn.iocoder.yudao.module.hospital.controller.admin.project.vo.achievement;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;


@Schema(description = "Admin - Research Achievement Page Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ResearchAchievementPageReqVO extends PageParam {
    @Schema(description = "Project ID", example = "1")
    private Long projectId;

    @Schema(description = "Achievement Type", example = "论文")
    private String achievementType;

    @Schema(description = "Achievement Name", example = "Cancer Research")
    private String achievementName;

    @Schema(description = "Status", example = "已登记")
    private String status;

    @Schema(description = "Publication Date Range - Begin")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] publicationOrGrantDate;
}
