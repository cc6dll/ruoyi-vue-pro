package cn.iocoder.yudao.module.hospital.service.project;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.hospital.controller.admin.project.vo.achievement.*;
import javax.validation.Valid;
import java.util.List;

public interface ResearchAchievementService {
    Long createResearchAchievement(@Valid ResearchAchievementCreateReqVO createReqVO);
    void updateResearchAchievement(@Valid ResearchAchievementUpdateReqVO updateReqVO);
    void deleteResearchAchievement(Long id);
    ResearchAchievementRespVO getResearchAchievement(Long id);
    List<ResearchAchievementRespVO> getResearchAchievementListByProjectId(Long projectId);
    PageResult<ResearchAchievementRespVO> getResearchAchievementPage(@Valid ResearchAchievementPageReqVO pageReqVO);
}
