package cn.iocoder.yudao.module.hospital.controller.admin.project;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.hospital.controller.admin.project.vo.project.*;
import cn.iocoder.yudao.module.hospital.service.project.ResearchProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.validation.Valid;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "Admin - Hospital Research Project Management")
@RestController
@RequestMapping("/hospital/project") // Adjusted base path to be more specific
@Validated
public class ResearchProjectController {

    @Resource
    private ResearchProjectService researchProjectService;

    @PostMapping("/create")
    @Operation(summary = "Create Research Project")
    // @PreAuthorize("@ss.hasPermission('hospital:project:create')") // Placeholder for permission
    public CommonResult<Long> createResearchProject(@Valid @RequestBody ResearchProjectCreateReqVO createReqVO) {
        return success(researchProjectService.createResearchProject(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Update Research Project")
    // @PreAuthorize("@ss.hasPermission('hospital:project:update')") // Placeholder for permission
    public CommonResult<Boolean> updateResearchProject(@Valid @RequestBody ResearchProjectUpdateReqVO updateReqVO) {
        researchProjectService.updateResearchProject(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete Research Project")
    @Parameter(name = "id", description = "Project ID", required = true, example = "1024")
    // @PreAuthorize("@ss.hasPermission('hospital:project:delete')") // Placeholder for permission
    public CommonResult<Boolean> deleteResearchProject(@RequestParam("id") Long id) {
        researchProjectService.deleteResearchProject(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get Research Project by ID")
    @Parameter(name = "id", description = "Project ID", required = true, example = "1024")
    // @PreAuthorize("@ss.hasPermission('hospital:project:query')") // Placeholder for permission
    public CommonResult<ResearchProjectRespVO> getResearchProject(@RequestParam("id") Long id) {
        return success(researchProjectService.getResearchProject(id));
    }

    @GetMapping("/page")
    @Operation(summary = "Get Research Project Page")
    // @PreAuthorize("@ss.hasPermission('hospital:project:query')") // Placeholder for permission
    public CommonResult<PageResult<ResearchProjectRespVO>> getResearchProjectPage(@Valid ResearchProjectPageReqVO pageVO) {
        PageResult<ResearchProjectRespVO> pageResult = researchProjectService.getResearchProjectPage(pageVO);
        return success(pageResult);
    }
}
