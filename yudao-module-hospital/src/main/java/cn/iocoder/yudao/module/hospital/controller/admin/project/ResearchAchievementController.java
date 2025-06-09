package cn.iocoder.yudao.module.hospital.controller.admin.project;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.hospital.controller.admin.project.vo.achievement.*;
import cn.iocoder.yudao.module.hospital.service.project.ResearchAchievementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "Admin - Hospital Research Achievement Management")
@RestController
@RequestMapping("/hospital/achievement") // Specific base path for achievement
@Validated
public class ResearchAchievementController {

    @Resource
    private ResearchAchievementService researchAchievementService;

    @PostMapping("/create")
    @Operation(summary = "Create Research Achievement Entry")
    // @PreAuthorize("@ss.hasPermission('hospital:achievement:create')") // Placeholder
    public CommonResult<Long> createResearchAchievement(@Valid @RequestBody ResearchAchievementCreateReqVO createReqVO) {
        return success(researchAchievementService.createResearchAchievement(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Update Research Achievement Entry")
    // @PreAuthorize("@ss.hasPermission('hospital:achievement:update')") // Placeholder
    public CommonResult<Boolean> updateResearchAchievement(@Valid @RequestBody ResearchAchievementUpdateReqVO updateReqVO) {
        researchAchievementService.updateResearchAchievement(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete Research Achievement Entry")
    @Parameter(name = "id", description = "Achievement ID", required = true, example = "201")
    // @PreAuthorize("@ss.hasPermission('hospital:achievement:delete')") // Placeholder
    public CommonResult<Boolean> deleteResearchAchievement(@RequestParam("id") Long id) {
        researchAchievementService.deleteResearchAchievement(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get Research Achievement Entry by ID")
    @Parameter(name = "id", description = "Achievement ID", required = true, example = "201")
    // @PreAuthorize("@ss.hasPermission('hospital:achievement:query')") // Placeholder
    public CommonResult<ResearchAchievementRespVO> getResearchAchievement(@RequestParam("id") Long id) {
        return success(researchAchievementService.getResearchAchievement(id));
    }

    @GetMapping("/list-by-project")
    @Operation(summary = "Get Research Achievement List by Project ID")
    @Parameter(name = "projectId", description = "Project ID", required = true, example = "1")
    // @PreAuthorize("@ss.hasPermission('hospital:achievement:query')") // Placeholder
    public CommonResult<List<ResearchAchievementRespVO>> getResearchAchievementListByProjectId(@RequestParam("projectId") Long projectId) {
        List<ResearchAchievementRespVO> list = researchAchievementService.getResearchAchievementListByProjectId(projectId);
        return success(list);
    }

    @GetMapping("/page")
    @Operation(summary = "Get Research Achievement Page")
    // @PreAuthorize("@ss.hasPermission('hospital:achievement:query')") // Placeholder
    public CommonResult<PageResult<ResearchAchievementRespVO>> getResearchAchievementPage(@Valid ResearchAchievementPageReqVO pageVO) {
        PageResult<ResearchAchievementRespVO> pageResult = researchAchievementService.getResearchAchievementPage(pageVO);
        return success(pageResult);
    }
}
