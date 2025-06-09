package cn.iocoder.yudao.module.hospital.service.project;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.test.core.ut.BaseMockitoUnitTest; // Assuming this base class exists from yudao-spring-boot-starter-test
import cn.iocoder.yudao.module.hospital.controller.admin.project.vo.project.*;
import cn.iocoder.yudao.module.hospital.dal.dataobject.project.ResearchProjectDO;
import cn.iocoder.yudao.module.hospital.dal.mapper.project.ResearchProjectMapper;
import cn.iocoder.yudao.module.hospital.convert.project.ResearchProjectConvert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
// If ServiceExceptionUtil.exception is used for specific error codes, those might need to be handled or mocked if not available in test scope easily.
// For now, assuming RuntimeException for not_exists validation.

public class ResearchProjectServiceImplTest extends BaseMockitoUnitTest {

    @InjectMocks
    private ResearchProjectServiceImpl researchProjectService;

    @Mock
    private ResearchProjectMapper researchProjectMapper;

    @Spy
    private ResearchProjectConvert researchProjectConvert = ResearchProjectConvert.INSTANCE;

    @BeforeEach
    public void setUp() {
        // Common setup if any, e.g., researchProjectService = new ResearchProjectServiceImpl(researchProjectMapper);
        // But @InjectMocks should handle this.
    }

    @Test
    public void testCreateResearchProject_Success() {
        // Arrange
        ResearchProjectCreateReqVO reqVO = new ResearchProjectCreateReqVO();
        reqVO.setProjectName("Test Project");
        reqVO.setPrincipalInvestigatorId(1L);
        reqVO.setDepartmentId(101L);
        reqVO.setStartDate(new Date());
        reqVO.setEndDate(new Date(System.currentTimeMillis() + 100000000));
        reqVO.setTotalFundingAmount(new BigDecimal("100000.00"));
        reqVO.setProjectStatus("申报中");

        ResearchProjectDO projectDO = new ResearchProjectDO();
        projectDO.setProjectId(1L); // Simulate DB generated ID after insert

        // Mocking mapper behavior:
        // 1. researchProjectMapper.insert(any(ResearchProjectDO.class))
        //    We need to ensure the passed ResearchProjectDO gets its ID set,
        //    which is typically handled by MyBatis Plus's IdType.AUTO.
        //    For mock, we can use doAnswer or just assume convert works and ID is set on the passed object.
        doAnswer(invocation -> {
            ResearchProjectDO argument = invocation.getArgument(0);
            argument.setProjectId(1L); // Simulate ID generation
            return 1; // Simulate 1 row affected
        }).when(researchProjectMapper).insert(any(ResearchProjectDO.class));


        // Act
        Long projectId = researchProjectService.createResearchProject(reqVO);

        // Assert
        assertNotNull(projectId);
        assertEquals(1L, projectId);
        verify(researchProjectMapper).insert(any(ResearchProjectDO.class));
    }

    @Test
    public void testGetResearchProject_Found() {
        // Arrange
        Long projectId = 1L;
        ResearchProjectDO projectDO = ResearchProjectDO.builder()
                                        .projectId(projectId)
                                        .projectName("Found Project")
                                        .principalInvestigatorId(2L)
                                        .departmentId(102L)
                                        .startDate(new Date())
                                        .endDate(new Date())
                                        .totalFundingAmount(BigDecimal.TEN)
                                        .projectStatus("进行中")
                                        .build();
        when(researchProjectMapper.selectById(projectId)).thenReturn(projectDO);

        // Act
        ResearchProjectRespVO respVO = researchProjectService.getResearchProject(projectId);

        // Assert
        assertNotNull(respVO);
        assertEquals(projectId, respVO.getProjectId());
        assertEquals("Found Project", respVO.getProjectName());
        verify(researchProjectMapper).selectById(projectId);
    }

    @Test
    public void testGetResearchProject_NotFound() {
        // Arrange
        Long projectId = 2L;
        when(researchProjectMapper.selectById(projectId)).thenReturn(null);

        // Act
        ResearchProjectRespVO respVO = researchProjectService.getResearchProject(projectId);

        // Assert
        assertNull(respVO); // Current behavior is to return null if not found by converter
        verify(researchProjectMapper).selectById(projectId);
    }

    @Test
    public void testUpdateResearchProject_Success() {
        // Arrange
        ResearchProjectUpdateReqVO reqVO = new ResearchProjectUpdateReqVO();
        reqVO.setProjectId(1L);
        reqVO.setProjectName("Updated Project");
        // Set other fields as needed for a complete update object
        reqVO.setPrincipalInvestigatorId(1L);
        reqVO.setDepartmentId(101L);
        reqVO.setStartDate(new Date());
        reqVO.setEndDate(new Date(System.currentTimeMillis() + 100000000));
        reqVO.setTotalFundingAmount(new BigDecimal("120000.00"));
        reqVO.setProjectStatus("已批准");

        ResearchProjectDO existingProjectDO = new ResearchProjectDO();
        existingProjectDO.setProjectId(1L);
        when(researchProjectMapper.selectById(1L)).thenReturn(existingProjectDO); // For validation
        when(researchProjectMapper.updateById(any(ResearchProjectDO.class))).thenReturn(1);


        // Act
        researchProjectService.updateResearchProject(reqVO);

        // Assert
        verify(researchProjectMapper).selectById(1L); // Verification for validateResearchProjectExists
        verify(researchProjectMapper).updateById(argThat(updatedDO ->
            updatedDO.getProjectId().equals(1L) &&
            updatedDO.getProjectName().equals("Updated Project")
        ));
    }

    @Test
    public void testUpdateResearchProject_NotFound_ThrowsException() {
        // Arrange
        ResearchProjectUpdateReqVO reqVO = new ResearchProjectUpdateReqVO();
        reqVO.setProjectId(99L); // Non-existent ID
        reqVO.setProjectName("Non Existent Project Update");
         // Set other fields as needed
        reqVO.setPrincipalInvestigatorId(1L);
        reqVO.setDepartmentId(101L);
        reqVO.setStartDate(new Date());
        reqVO.setEndDate(new Date(System.currentTimeMillis() + 100000000));
        reqVO.setTotalFundingAmount(new BigDecimal("120000.00"));
        reqVO.setProjectStatus("已批准");

        when(researchProjectMapper.selectById(99L)).thenReturn(null);

        // Act & Assert
        Exception exception = assertThrows(RuntimeException.class, () -> {
            researchProjectService.updateResearchProject(reqVO);
        });
        assertEquals("Research project not found with ID: 99", exception.getMessage());
        verify(researchProjectMapper).selectById(99L);
        verify(researchProjectMapper, never()).updateById(any());
    }


    @Test
    public void testDeleteResearchProject_Success() {
        // Arrange
        Long projectId = 1L;
        ResearchProjectDO existingProjectDO = new ResearchProjectDO();
        existingProjectDO.setProjectId(projectId);
        when(researchProjectMapper.selectById(projectId)).thenReturn(existingProjectDO);
        when(researchProjectMapper.deleteById(projectId)).thenReturn(1);

        // Act
        researchProjectService.deleteResearchProject(projectId);

        // Assert
        verify(researchProjectMapper).selectById(projectId);
        verify(researchProjectMapper).deleteById(projectId);
    }

    @Test
    public void testDeleteResearchProject_NotFound_ThrowsException() {
        // Arrange
        Long projectId = 99L; // Non-existent ID
        when(researchProjectMapper.selectById(projectId)).thenReturn(null);

        // Act & Assert
         Exception exception = assertThrows(RuntimeException.class, () -> {
            researchProjectService.deleteResearchProject(projectId);
        });
        assertEquals("Research project not found with ID: 99", exception.getMessage());
        verify(researchProjectMapper).selectById(projectId);
        verify(researchProjectMapper, never()).deleteById(anyLong());
    }

    @Test
    public void testGetResearchProjectPage_Success() {
        // Arrange
        ResearchProjectPageReqVO pageReqVO = new ResearchProjectPageReqVO();
        // Assuming BaseMapperX.selectPage is used and needs mocking if we go deeper.
        // For now, the service impl uses selectList(null) which is a placeholder.
        when(researchProjectMapper.selectList(null)).thenReturn(Collections.emptyList());

        // Act
        PageResult<ResearchProjectRespVO> pageResult = researchProjectService.getResearchProjectPage(pageReqVO);

        // Assert
        assertNotNull(pageResult);
        assertTrue(pageResult.getList().isEmpty());
        assertEquals(0L, pageResult.getTotal());
        verify(researchProjectMapper).selectList(null); // Verifying the current placeholder behavior
    }

}
