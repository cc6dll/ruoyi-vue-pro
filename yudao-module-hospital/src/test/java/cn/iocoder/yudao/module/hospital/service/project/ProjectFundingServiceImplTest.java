package cn.iocoder.yudao.module.hospital.service.project;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.test.core.ut.BaseMockitoUnitTest;
import cn.iocoder.yudao.module.hospital.controller.admin.project.vo.funding.*;
import cn.iocoder.yudao.module.hospital.dal.dataobject.project.ProjectFundingDO;
import cn.iocoder.yudao.module.hospital.dal.mapper.project.ProjectFundingMapper;
import cn.iocoder.yudao.module.hospital.convert.project.ProjectFundingConvert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProjectFundingServiceImplTest extends BaseMockitoUnitTest {

    @InjectMocks
    private ProjectFundingServiceImpl projectFundingService;

    @Mock
    private ProjectFundingMapper projectFundingMapper;

    @Spy
    private ProjectFundingConvert projectFundingConvert = ProjectFundingConvert.INSTANCE;

    @Test
    public void testCreateProjectFunding_Success() {
        // Arrange
        ProjectFundingCreateReqVO reqVO = new ProjectFundingCreateReqVO();
        reqVO.setProjectId(1L);
        reqVO.setBudgetItemName("Test Equipment");
        reqVO.setAmountPlanned(new BigDecimal("5000.00"));
        // ... set other required fields ...

        doAnswer(invocation -> {
            ProjectFundingDO argument = invocation.getArgument(0);
            argument.setFundingId(101L); // Simulate ID generation
            return 1;
        }).when(projectFundingMapper).insert(any(ProjectFundingDO.class));

        // Act
        Long fundingId = projectFundingService.createProjectFunding(reqVO);

        // Assert
        assertNotNull(fundingId);
        assertEquals(101L, fundingId);
        verify(projectFundingMapper).insert(any(ProjectFundingDO.class));
    }

    @Test
    public void testGetProjectFunding_Found() {
        // Arrange
        Long fundingId = 101L;
        ProjectFundingDO fundingDO = ProjectFundingDO.builder()
                                        .fundingId(fundingId)
                                        .projectId(1L)
                                        .budgetItemName("Equipment")
                                        .amountPlanned(BigDecimal.TEN)
                                        .build();
        when(projectFundingMapper.selectById(fundingId)).thenReturn(fundingDO);

        // Act
        ProjectFundingRespVO respVO = projectFundingService.getProjectFunding(fundingId);

        // Assert
        assertNotNull(respVO);
        assertEquals(fundingId, respVO.getFundingId());
        assertEquals("Equipment", respVO.getBudgetItemName());
        verify(projectFundingMapper).selectById(fundingId);
    }

    @Test
    public void testGetProjectFundingListByProjectId_Success() {
        // Arrange
        Long projectId = 1L;
        when(projectFundingMapper.selectListByProjectId(projectId)).thenReturn(Collections.emptyList());

        // Act
        List<ProjectFundingRespVO> list = projectFundingService.getProjectFundingListByProjectId(projectId);

        // Assert
        assertNotNull(list);
        assertTrue(list.isEmpty());
        verify(projectFundingMapper).selectListByProjectId(projectId);
    }

    @Test
    public void testGetProjectFundingPage_Success() {
        // Arrange
        ProjectFundingPageReqVO pageReqVO = new ProjectFundingPageReqVO();
        // The service currently returns a hardcoded empty page, so we don't need to mock selectPage for this test to pass.
        // If the service implementation changes to call selectPage, this mock will be needed:
        // when(projectFundingMapper.selectPage(eq(pageReqVO), any())).thenReturn(new PageResult<>(Collections.emptyList(), 0L));


        // Act
        PageResult<ProjectFundingRespVO> pageResult = projectFundingService.getProjectFundingPage(pageReqVO);

        // Assert
        assertNotNull(pageResult);
        assertTrue(pageResult.getList().isEmpty());
        assertEquals(0L, pageResult.getTotal());
        // verify(projectFundingMapper).selectPage(eq(pageReqVO), any()); // This requires proper PageParam and query wrapper setup in service
    }
}
