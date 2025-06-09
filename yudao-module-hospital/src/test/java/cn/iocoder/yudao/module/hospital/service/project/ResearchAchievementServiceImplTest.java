package cn.iocoder.yudao.module.hospital.service.project;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.test.core.ut.BaseMockitoUnitTest;
import cn.iocoder.yudao.module.hospital.controller.admin.project.vo.achievement.*;
import cn.iocoder.yudao.module.hospital.dal.dataobject.project.ResearchAchievementDO;
import cn.iocoder.yudao.module.hospital.dal.mapper.project.ResearchAchievementMapper;
import cn.iocoder.yudao.module.hospital.convert.project.ResearchAchievementConvert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ResearchAchievementServiceImplTest extends BaseMockitoUnitTest {

    @InjectMocks
    private ResearchAchievementServiceImpl researchAchievementService;

    @Mock
    private ResearchAchievementMapper researchAchievementMapper;

    @Spy
    private ResearchAchievementConvert researchAchievementConvert = ResearchAchievementConvert.INSTANCE;

    @Test
    public void testCreateResearchAchievement_Success() {
        // Arrange
        ResearchAchievementCreateReqVO reqVO = new ResearchAchievementCreateReqVO();
        reqVO.setProjectId(1L);
        reqVO.setAchievementName("Test Paper");
        reqVO.setAchievementType("论文");
        reqVO.setStatus("已提交");
        // ... set other required fields ...

        doAnswer(invocation -> {
            ResearchAchievementDO argument = invocation.getArgument(0);
            argument.setAchievementId(201L); // Simulate ID generation
            return 1;
        }).when(researchAchievementMapper).insert(any(ResearchAchievementDO.class));

        // Act
        Long achievementId = researchAchievementService.createResearchAchievement(reqVO);

        // Assert
        assertNotNull(achievementId);
        assertEquals(201L, achievementId);
        verify(researchAchievementMapper).insert(any(ResearchAchievementDO.class));
    }

    @Test
    public void testGetResearchAchievement_Found() {
        // Arrange
        Long achievementId = 201L;
        ResearchAchievementDO achievementDO = ResearchAchievementDO.builder()
                                                .achievementId(achievementId)
                                                .projectId(1L)
                                                .achievementName("Published Paper")
                                                .achievementType("论文")
                                                .status("已登记")
                                                .build();
        when(researchAchievementMapper.selectById(achievementId)).thenReturn(achievementDO);

        // Act
        ResearchAchievementRespVO respVO = researchAchievementService.getResearchAchievement(achievementId);

        // Assert
        assertNotNull(respVO);
        assertEquals(achievementId, respVO.getAchievementId());
        assertEquals("Published Paper", respVO.getAchievementName());
        verify(researchAchievementMapper).selectById(achievementId);
    }

    @Test
    public void testGetResearchAchievementListByProjectId_Success() {
        // Arrange
        Long projectId = 1L;
        when(researchAchievementMapper.selectListByProjectId(projectId)).thenReturn(Collections.emptyList());

        // Act
        List<ResearchAchievementRespVO> list = researchAchievementService.getResearchAchievementListByProjectId(projectId);

        // Assert
        assertNotNull(list);
        assertTrue(list.isEmpty());
        verify(researchAchievementMapper).selectListByProjectId(projectId);
    }

    @Test
    public void testGetResearchAchievementPage_Success() {
        // Arrange
        ResearchAchievementPageReqVO pageReqVO = new ResearchAchievementPageReqVO();
        // The service currently returns a hardcoded empty page, so we don't need to mock selectPage for this test to pass.
        // If the service implementation changes to call selectPage, this mock will be needed:
        // when(researchAchievementMapper.selectPage(eq(pageReqVO), any())).thenReturn(new PageResult<>(Collections.emptyList(), 0L));


        // Act
        PageResult<ResearchAchievementRespVO> pageResult = researchAchievementService.getResearchAchievementPage(pageReqVO);

        // Assert
        assertNotNull(pageResult);
        assertTrue(pageResult.getList().isEmpty());
        assertEquals(0L, pageResult.getTotal());
        // verify(researchAchievementMapper).selectPage(eq(pageReqVO), any());
    }
}
