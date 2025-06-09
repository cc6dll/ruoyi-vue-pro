package cn.iocoder.yudao.module.hospital.service.project;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.hospital.controller.admin.project.vo.achievement.*;
import cn.iocoder.yudao.module.hospital.dal.dataobject.project.ResearchAchievementDO;
import cn.iocoder.yudao.module.hospital.dal.mapper.project.ResearchAchievementMapper;
import cn.iocoder.yudao.module.hospital.convert.project.ResearchAchievementConvert; // Assume converter
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
// import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
// import static cn.iocoder.yudao.module.hospital.enums.ErrorCodeConstants.*; // Assume error codes

@Service
public class ResearchAchievementServiceImpl implements ResearchAchievementService {

    @Resource
    private ResearchAchievementMapper researchAchievementMapper;

    @Override
    public Long createResearchAchievement(ResearchAchievementCreateReqVO createReqVO) {
        ResearchAchievementDO researchAchievement = ResearchAchievementConvert.INSTANCE.convert(createReqVO);
        researchAchievementMapper.insert(researchAchievement);
        return researchAchievement.getAchievementId();
    }

    @Override
    public void updateResearchAchievement(ResearchAchievementUpdateReqVO updateReqVO) {
        validateResearchAchievementExists(updateReqVO.getAchievementId());
        ResearchAchievementDO updateDO = ResearchAchievementConvert.INSTANCE.convert(updateReqVO);
        researchAchievementMapper.updateById(updateDO);
    }

    @Override
    public void deleteResearchAchievement(Long id) {
        validateResearchAchievementExists(id);
        researchAchievementMapper.deleteById(id);
    }

    private void validateResearchAchievementExists(Long id) {
        if (researchAchievementMapper.selectById(id) == null) {
            // throw exception(RESEARCH_ACHIEVEMENT_NOT_EXISTS); // Placeholder
            throw new RuntimeException("Research achievement not found with ID: " + id);
        }
    }

    @Override
    public ResearchAchievementRespVO getResearchAchievement(Long id) {
        ResearchAchievementDO achievement = researchAchievementMapper.selectById(id);
        return ResearchAchievementConvert.INSTANCE.convert(achievement);
    }

    @Override
    public List<ResearchAchievementRespVO> getResearchAchievementListByProjectId(Long projectId) {
        List<ResearchAchievementDO> list = researchAchievementMapper.selectListByProjectId(projectId); // Assumes method in mapper
        return ResearchAchievementConvert.INSTANCE.convertList(list);
    }

    @Override
    public PageResult<ResearchAchievementRespVO> getResearchAchievementPage(ResearchAchievementPageReqVO pageReqVO) {
        // TODO: Implement proper pagination query
        return new PageResult<>(Collections.emptyList(), 0L);
    }
}
