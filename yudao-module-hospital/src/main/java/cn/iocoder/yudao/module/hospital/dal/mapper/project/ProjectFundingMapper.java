package cn.iocoder.yudao.module.hospital.dal.mapper.project;

import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.hospital.dal.dataobject.project.ProjectFundingDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectFundingMapper extends BaseMapperX<ProjectFundingDO> {

    default List<ProjectFundingDO> selectListByProjectId(Long projectId) {
        return selectList(ProjectFundingDO::getProjectId, projectId);
    }
}
