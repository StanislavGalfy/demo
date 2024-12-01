package com.example.demo.serviceimpl;

import com.example.demo.entity.DemoEntity;
import com.example.demo.exception.ApiException;
import com.example.demo.model.DemoRequestDTO;
import com.example.demo.repository.DemoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class DemoServiceImplTest {

    private static final Long DEMO_ID = 1L;

    private static final String DEMO_NAME = "demo";
    
    @Mock
    DemoRepository demoRepository;

    @InjectMocks
    DemoServiceImpl demoService;

    @Captor
    ArgumentCaptor<DemoEntity> demoEntityArgumentCaptor;

    @Test
    public void createDemoTest() {
        demoService.create(getDemoRequestDTO());

        Mockito.verify(demoRepository).save(demoEntityArgumentCaptor.capture());
        assertDemoEntity(demoEntityArgumentCaptor.getValue());
        Mockito.verifyNoMoreInteractions(demoRepository);
    }

    @Test
    public void deleteDemoTest() {
        Mockito.when(demoRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(getDemoEntity()));

        demoService.delete(1L);

        Mockito.verify(demoRepository).delete(demoEntityArgumentCaptor.capture());
        assertDemoEntity(demoEntityArgumentCaptor.getValue());
        Mockito.verifyNoMoreInteractions(demoRepository);
    }

    @Test
    public void deleteNonExistingDemoTest() {
        Mockito.when(demoRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());

        Assertions.assertThrows(ApiException.class, () -> demoService.delete( DEMO_ID));
        Mockito.verifyNoMoreInteractions(demoRepository);
    }

    @Test
    public void updateDemoTest() {
        Mockito.when(demoRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(getDemoEntity()));

        demoService.update(1L, getDemoRequestDTO());

        Mockito.verify(demoRepository).save(demoEntityArgumentCaptor.capture());
        assertDemoEntity(demoEntityArgumentCaptor.getValue());
        Mockito.verifyNoMoreInteractions(demoRepository);
    }

    @Test
    public void updateNonExistingDemoTest() {
        Mockito.when(demoRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());

        Assertions.assertThrows(ApiException.class, () -> demoService.update( DEMO_ID, getDemoRequestDTO()));
        Mockito.verifyNoMoreInteractions(demoRepository);
    }

    private void assertDemoEntity(DemoEntity demoEntity) {
        Assertions.assertEquals(DEMO_NAME, demoEntity.getName());
    }

    private DemoRequestDTO getDemoRequestDTO() {
        return DemoRequestDTO.builder()
                .name(DEMO_NAME)
                .build();
    }

    private DemoEntity getDemoEntity() {
        return DemoEntity.builder()
                .id(1L)
                .name(DEMO_NAME)
                .build();
    }
}
