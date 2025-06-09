package cn.iocoder.yudao.module.hospital.controller.admin.project.vo.funding;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProjectFundingBaseVO {
    @Schema(description = "Project ID", required = true, example = "1")
    @NotNull(message = "Project ID cannot be null")
    private Long projectId;

    @Schema(description = "Budget Item Name", required = true, example = "Equipment Purchase")
    @NotEmpty(message = "Budget Item Name cannot be empty")
    private String budgetItemName;

    @Schema(description = "Budget Item Code", example = "EQUIP-001")
    private String budgetItemCode;

    @Schema(description = "Amount Planned", required = true, example = "10000.00")
    @NotNull(message = "Planned amount cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Planned amount must be greater than 0")
    private BigDecimal amountPlanned;

    @Schema(description = "Amount Received", example = "5000.00")
    private BigDecimal amountReceived;

    @Schema(description = "Amount Spent", example = "3000.00")
    private BigDecimal amountSpent;

    @Schema(description = "Funding Source", example = "National Grant")
    private String fundingSource;

    @Schema(description = "Received Date")
    private Date receivedDate;

    @Schema(description = "Expenditure Date")
    private Date expenditureDate;

    @Schema(description = "Voucher Number", example = "VN12345")
    private String voucherNumber;

    @Schema(description = "Remarks", example = "Initial funding installment")
    private String remarks;
}
