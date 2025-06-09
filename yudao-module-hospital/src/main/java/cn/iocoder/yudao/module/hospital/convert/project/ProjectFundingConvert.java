package cn.iocoder.yudao.module.hospital.convert.project;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.hospital.controller.admin.project.vo.funding.*;
import cn.iocoder.yudao.module.hospital.dal.dataobject.project.ProjectFundingDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface ProjectFundingConvert {
    ProjectFundingConvert INSTANCE = Mappers.getMapper(ProjectFundingConvert.class);
    ProjectFundingDO convert(ProjectFundingCreateReqVO bean);
    ProjectFundingDO convert(ProjectFundingUpdateReqVO bean);
    ProjectFundingRespVO convert(ProjectFundingDO bean);
    List<ProjectFundingRespVO> convertList(List<ProjectFundingDO> list);
    // PageResult<ProjectFundingRespVO> convertPage(PageResult<ProjectFundingDO> page);
}
