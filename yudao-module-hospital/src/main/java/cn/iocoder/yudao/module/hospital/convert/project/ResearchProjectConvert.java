package cn.iocoder.yudao.module.hospital.convert.project;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.hospital.controller.admin.project.vo.project.*;
import cn.iocoder.yudao.module.hospital.dal.dataobject.project.ResearchProjectDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface ResearchProjectConvert {
    ResearchProjectConvert INSTANCE = Mappers.getMapper(ResearchProjectConvert.class);
    ResearchProjectDO convert(ResearchProjectCreateReqVO bean);
    ResearchProjectDO convert(ResearchProjectUpdateReqVO bean);
    ResearchProjectRespVO convert(ResearchProjectDO bean);
    List<ResearchProjectRespVO> convertList(List<ResearchProjectDO> list);
    // PageResult<ResearchProjectRespVO> convertPage(PageResult<ResearchProjectDO> page); // Will be needed for proper pagination
}
