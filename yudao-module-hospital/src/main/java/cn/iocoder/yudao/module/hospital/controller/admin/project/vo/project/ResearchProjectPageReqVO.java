package cn.iocoder.yudao.module.hospital.controller.admin.project.vo.project;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - Research Project Page Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ResearchProjectPageReqVO extends PageParam {
    @Schema(description = "Project Name", example = "AI Project")
    private String projectName;

    @Schema(description = "Principal Investigator ID", example = "1024")
    private Long principalInvestigatorId;

    @Schema(description = "Department ID", example = "2048")
    private Long departmentId;

    @Schema(description = "Project Status", example = "进行中")
    private String projectStatus;

    @Schema(description = "Start Date Range - Begin")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] startDate;

    @Schema(description = "End Date Range - Begin")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] endDate;
}
