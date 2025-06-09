package cn.iocoder.yudao.module.hospital.dal.mapper.project;

import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.hospital.dal.dataobject.project.ResearchAchievementDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ResearchAchievementMapper extends BaseMapperX<ResearchAchievementDO> {

    default List<ResearchAchievementDO> selectListByProjectId(Long projectId) {
        return selectList(ResearchAchievementDO::getProjectId, projectId);
    }
}
