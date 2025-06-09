package cn.iocoder.yudao.module.hospital.service.project;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.hospital.controller.admin.project.vo.funding.*;
import cn.iocoder.yudao.module.hospital.dal.dataobject.project.ProjectFundingDO;
import cn.iocoder.yudao.module.hospital.dal.mapper.project.ProjectFundingMapper;
import cn.iocoder.yudao.module.hospital.convert.project.ProjectFundingConvert; // Assume this converter will be created
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Collections; // Added for emptyList in placeholder
import java.util.List;
// import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
// import static cn.iocoder.yudao.module.hospital.enums.ErrorCodeConstants.*; // Assume these error codes will be created

@Service
public class ProjectFundingServiceImpl implements ProjectFundingService {

    @Resource
    private ProjectFundingMapper projectFundingMapper;

    @Override
    public Long createProjectFunding(ProjectFundingCreateReqVO createReqVO) {
        ProjectFundingDO projectFunding = ProjectFundingConvert.INSTANCE.convert(createReqVO);
        projectFundingMapper.insert(projectFunding);
        return projectFunding.getFundingId();
    }

    @Override
    public void updateProjectFunding(ProjectFundingUpdateReqVO updateReqVO) {
        validateProjectFundingExists(updateReqVO.getFundingId());
        ProjectFundingDO updateDO = ProjectFundingConvert.INSTANCE.convert(updateReqVO);
        projectFundingMapper.updateById(updateDO);
    }

    @Override
    public void deleteProjectFunding(Long id) {
        validateProjectFundingExists(id);
        projectFundingMapper.deleteById(id);
    }

    private void validateProjectFundingExists(Long id) {
        if (projectFundingMapper.selectById(id) == null) {
            // throw exception(PROJECT_FUNDING_NOT_EXISTS); // Placeholder
            throw new RuntimeException("Project funding not found with ID: " + id);
        }
    }

    @Override
    public ProjectFundingRespVO getProjectFunding(Long id) {
        ProjectFundingDO funding = projectFundingMapper.selectById(id);
        return ProjectFundingConvert.INSTANCE.convert(funding);
    }

    @Override
    public List<ProjectFundingRespVO> getProjectFundingListByProjectId(Long projectId) {
        List<ProjectFundingDO> list = projectFundingMapper.selectListByProjectId(projectId); // Assumes this method exists in mapper
        return ProjectFundingConvert.INSTANCE.convertList(list);
    }

    @Override
    public PageResult<ProjectFundingRespVO> getProjectFundingPage(ProjectFundingPageReqVO pageReqVO) {
        // TODO: Implement proper pagination query with conditions from pageReqVO
        // This will require ProjectFundingMapper to extend BaseMapperX and for selectPage to be used.
        // For now, returning an empty page.
        return new PageResult<>(Collections.emptyList(), 0L);
    }
}
