package cn.iocoder.yudao.module.hospital.controller.admin.project.vo.project;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - Research Project Create Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ResearchProjectCreateReqVO extends ResearchProjectBaseVO {
}
