package cn.iocoder.yudao.module.hospital.service.project;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.hospital.controller.admin.project.vo.funding.*;
import javax.validation.Valid;
import java.util.List;

public interface ProjectFundingService {
    Long createProjectFunding(@Valid ProjectFundingCreateReqVO createReqVO);
    void updateProjectFunding(@Valid ProjectFundingUpdateReqVO updateReqVO);
    void deleteProjectFunding(Long id);
    ProjectFundingRespVO getProjectFunding(Long id);
    List<ProjectFundingRespVO> getProjectFundingListByProjectId(Long projectId);
    PageResult<ProjectFundingRespVO> getProjectFundingPage(@Valid ProjectFundingPageReqVO pageReqVO);
}
