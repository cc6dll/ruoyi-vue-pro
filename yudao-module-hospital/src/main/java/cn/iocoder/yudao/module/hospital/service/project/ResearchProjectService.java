package cn.iocoder.yudao.module.hospital.service.project;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.hospital.controller.admin.project.vo.project.*;
import javax.validation.Valid;

public interface ResearchProjectService {
    Long createResearchProject(@Valid ResearchProjectCreateReqVO createReqVO);
    void updateResearchProject(@Valid ResearchProjectUpdateReqVO updateReqVO);
    void deleteResearchProject(Long id);
    ResearchProjectRespVO getResearchProject(Long id);
    PageResult<ResearchProjectRespVO> getResearchProjectPage(@Valid ResearchProjectPageReqVO pageReqVO);
}
