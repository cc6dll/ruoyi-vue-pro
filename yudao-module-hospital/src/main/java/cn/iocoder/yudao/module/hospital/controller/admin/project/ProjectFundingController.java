package cn.iocoder.yudao.module.hospital.controller.admin.project;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.hospital.controller.admin.project.vo.funding.*;
import cn.iocoder.yudao.module.hospital.service.project.ProjectFundingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "Admin - Hospital Project Funding Management")
@RestController
@RequestMapping("/hospital/funding") // Specific base path for funding
@Validated
public class ProjectFundingController {

    @Resource
    private ProjectFundingService projectFundingService;

    @PostMapping("/create")
    @Operation(summary = "Create Project Funding Entry")
    // @PreAuthorize("@ss.hasPermission('hospital:funding:create')") // Placeholder
    public CommonResult<Long> createProjectFunding(@Valid @RequestBody ProjectFundingCreateReqVO createReqVO) {
        return success(projectFundingService.createProjectFunding(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Update Project Funding Entry")
    // @PreAuthorize("@ss.hasPermission('hospital:funding:update')") // Placeholder
    public CommonResult<Boolean> updateProjectFunding(@Valid @RequestBody ProjectFundingUpdateReqVO updateReqVO) {
        projectFundingService.updateProjectFunding(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete Project Funding Entry")
    @Parameter(name = "id", description = "Funding ID", required = true, example = "101")
    // @PreAuthorize("@ss.hasPermission('hospital:funding:delete')") // Placeholder
    public CommonResult<Boolean> deleteProjectFunding(@RequestParam("id") Long id) {
        projectFundingService.deleteProjectFunding(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get Project Funding Entry by ID")
    @Parameter(name = "id", description = "Funding ID", required = true, example = "101")
    // @PreAuthorize("@ss.hasPermission('hospital:funding:query')") // Placeholder
    public CommonResult<ProjectFundingRespVO> getProjectFunding(@RequestParam("id") Long id) {
        return success(projectFundingService.getProjectFunding(id));
    }

    @GetMapping("/list-by-project")
    @Operation(summary = "Get Project Funding List by Project ID")
    @Parameter(name = "projectId", description = "Project ID", required = true, example = "1")
    // @PreAuthorize("@ss.hasPermission('hospital:funding:query')") // Placeholder
    public CommonResult<List<ProjectFundingRespVO>> getProjectFundingListByProjectId(@RequestParam("projectId") Long projectId) {
        List<ProjectFundingRespVO> list = projectFundingService.getProjectFundingListByProjectId(projectId);
        return success(list);
    }

    @GetMapping("/page")
    @Operation(summary = "Get Project Funding Page")
    // @PreAuthorize("@ss.hasPermission('hospital:funding:query')") // Placeholder
    public CommonResult<PageResult<ProjectFundingRespVO>> getProjectFundingPage(@Valid ProjectFundingPageReqVO pageVO) {
        PageResult<ProjectFundingRespVO> pageResult = projectFundingService.getProjectFundingPage(pageVO);
        return success(pageResult);
    }
}
