package cn.iocoder.yudao.module.hospital.controller.admin.project.vo.achievement;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import javax.validation.constraints.*;
import java.util.Date;

@Data
public class ResearchAchievementBaseVO {
    @Schema(description = "Project ID", required = true, example = "1")
    @NotNull(message = "Project ID cannot be null")
    private Long projectId;

    @Schema(description = "Achievement Type (e.g., 论文, 专利, 软件著作权, 奖励)", required = true, example = "论文")
    @NotEmpty(message = "Achievement Type cannot be empty")
    private String achievementType;

    @Schema(description = "Achievement Name", required = true, example = "Breakthrough in Cancer Research")
    @NotEmpty(message = "Achievement Name cannot be empty")
    private String achievementName;

    @Schema(description = "Publication or Grant Date")
    private Date publicationOrGrantDate;

    @Schema(description = "Intellectual Property Information", example = "Patent No. 12345")
    private String intellectualPropertyInfo;

    @Schema(description = "Authors or Inventors", example = "Dr. Smith, Dr. Jones")
    private String authorsOrInventors;

    @Schema(description = "Journal or Patent Office", example = "Nature")
    private String journalOrPatentOffice;

    @Schema(description = "Status (e.g., 已提交, 审核中, 已登记)", required = true, example = "已登记")
    @NotEmpty(message = "Status cannot be empty")
    private String status;
}
