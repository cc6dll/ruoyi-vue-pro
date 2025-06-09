package cn.iocoder.yudao.module.hospital.dal.dataobject.project;

import lombok.*;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

@TableName("research_achievement")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResearchAchievementDO extends BaseDO {
    @TableId(type = IdType.AUTO)
    private Long achievementId;
    private Long projectId;
    private String achievementType;
    private String achievementName;
    private Date publicationOrGrantDate;
    private String intellectualPropertyInfo;
    private String authorsOrInventors;
    private String journalOrPatentOffice;
    private String status;
}
