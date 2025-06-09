package cn.iocoder.yudao.module.hospital.controller.admin.project.vo.project;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class ResearchProjectBaseVO {
    @Schema(description = "Project Name", required = true, example = "AI for Medical Imaging")
    @NotEmpty(message = "Project Name cannot be empty")
    private String projectName;

    @Schema(description = "Principal Investigator User ID", required = true, example = "1024")
    @NotNull(message = "Principal Investigator ID cannot be null")
    private Long principalInvestigatorId;

    @Schema(description = "Department ID", required = true, example = "2048")
    @NotNull(message = "Department ID cannot be null")
    private Long departmentId;

    @Schema(description = "Start Date", required = true)
    @NotNull(message = "Start Date cannot be null")
    private Date startDate;

    @Schema(description = "End Date", required = true)
    @NotNull(message = "End Date cannot be null")
    private Date endDate;

    @Schema(description = "Total Funding Amount", required = true, example = "500000.00")
    @NotNull(message = "Total Funding Amount cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Funding amount must be greater than 0")
    private BigDecimal totalFundingAmount;

    @Schema(description = "Project Status", required = true, example = "进行中")
    @NotEmpty(message = "Project Status cannot be empty")
    private String projectStatus;

    @Schema(description = "Project Description", example = "Detailed description of the project.")
    private String projectDescription;
}
