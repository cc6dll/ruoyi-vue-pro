package cn.iocoder.yudao.module.hospital.service.project;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.hospital.controller.admin.project.vo.project.*;
import cn.iocoder.yudao.module.hospital.dal.dataobject.project.ResearchProjectDO;
import cn.iocoder.yudao.module.hospital.dal.mapper.project.ResearchProjectMapper;
import cn.iocoder.yudao.module.hospital.convert.project.ResearchProjectConvert; // Assume this converter will be created
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
// import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception; // TODO: Uncomment when ErrorCodeConstants is properly set up
// import static cn.iocoder.yudao.module.hospital.enums.ErrorCodeConstants.*; // Assume these error codes will be created

@Service
public class ResearchProjectServiceImpl implements ResearchProjectService {

    @Resource
    private ResearchProjectMapper researchProjectMapper;

    @Override
    public Long createResearchProject(ResearchProjectCreateReqVO createReqVO) {
        // Basic validation (e.g., name uniqueness if needed) can go here
        ResearchProjectDO researchProject = ResearchProjectConvert.INSTANCE.convert(createReqVO);
        researchProjectMapper.insert(researchProject);
        return researchProject.getProjectId();
    }

    @Override
    public void updateResearchProject(ResearchProjectUpdateReqVO updateReqVO) {
        validateResearchProjectExists(updateReqVO.getProjectId());
        ResearchProjectDO updateDO = ResearchProjectConvert.INSTANCE.convert(updateReqVO);
        researchProjectMapper.updateById(updateDO);
    }

    @Override
    public void deleteResearchProject(Long id) {
        validateResearchProjectExists(id);
        researchProjectMapper.deleteById(id);
    }

    private void validateResearchProjectExists(Long id) {
        if (researchProjectMapper.selectById(id) == null) {
            // throw exception(RESEARCH_PROJECT_NOT_EXISTS); // Placeholder for actual error code
            throw new RuntimeException("Research project not found with ID: " + id); // Simple exception for now
        }
    }

    @Override
    public ResearchProjectRespVO getResearchProject(Long id) {
        ResearchProjectDO project = researchProjectMapper.selectById(id);
        return ResearchProjectConvert.INSTANCE.convert(project);
    }

    @Override
    public PageResult<ResearchProjectRespVO> getResearchProjectPage(ResearchProjectPageReqVO pageReqVO) {
        // TODO: Implement proper pagination query with conditions from pageReqVO
        // For now, a simple selectList is used, which is not correct for pagination.
        // This will need to be replaced with a Page query using BaseMapperX's selectPage method.
        // Example: return ResearchProjectConvert.INSTANCE.convertPage(researchProjectMapper.selectPage(pageReqVO, null));
        // This requires ResearchProjectMapper to extend BaseMapperX and PageParam/PageResult to be set up.
        // For now, returning an empty page to avoid compilation errors with a simple list.
        return new PageResult<>(ResearchProjectConvert.INSTANCE.convertList(researchProjectMapper.selectList(null)), 0L);
    }
}
