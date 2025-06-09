package cn.iocoder.yudao.module.hospital.convert.project;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.hospital.controller.admin.project.vo.achievement.*;
import cn.iocoder.yudao.module.hospital.dal.dataobject.project.ResearchAchievementDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface ResearchAchievementConvert {
    ResearchAchievementConvert INSTANCE = Mappers.getMapper(ResearchAchievementConvert.class);
    ResearchAchievementDO convert(ResearchAchievementCreateReqVO bean);
    ResearchAchievementDO convert(ResearchAchievementUpdateReqVO bean);
    ResearchAchievementRespVO convert(ResearchAchievementDO bean);
    List<ResearchAchievementRespVO> convertList(List<ResearchAchievementDO> list);
    // PageResult<ResearchAchievementRespVO> convertPage(PageResult<ResearchAchievementDO> page);
}
