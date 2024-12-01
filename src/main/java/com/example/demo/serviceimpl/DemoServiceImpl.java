package com.example.demo.serviceimpl;

import com.example.demo.entity.DemoEntity;
import com.example.demo.exception.ApiException;
import com.example.demo.model.DemoRequestDTO;
import com.example.demo.model.DemoResponseDTO;
import com.example.demo.repository.DemoRepository;
import com.example.demo.service.DemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DemoServiceImpl implements DemoService {

    private final DemoRepository demoRepository;

    @Override
    public void create(DemoRequestDTO demoRequestDTO) {
        val demoEntity = DemoEntity.builder()
                .name(demoRequestDTO.getName())
                .build();

        demoRepository.save(demoEntity);

        log.info("Demo '{}' successfully created", demoEntity.getId());
    }

    @Override
    public void update(Long demoId, DemoRequestDTO demoRequestDTO) {
        val demoEntity = demoRepository.findById(demoId).orElseThrow(() ->
                ApiException.demoNotFound(demoId));

        demoEntity.setName(demoRequestDTO.getName());

        demoRepository.save(demoEntity);

        log.info("Demo '{}' successfully updated", demoEntity.getId());
    }

    @Override
    public void delete(Long demoId) {
        val demoEntity = demoRepository.findById(demoId).orElseThrow(() ->
                ApiException.demoNotFound(demoId));

        demoRepository.delete(demoEntity);

        log.info("Demo '{}' successfully deleted", demoEntity.getId());
    }

    @Override
    public List<DemoResponseDTO> getAll() {
        val demoResponseDTOs = new ArrayList<DemoResponseDTO>();
        demoRepository.findAll().forEach(demoEntity -> {
            val demoResponsesDTO = DemoResponseDTO.builder()
                    .id(demoEntity.getId())
                    .name(demoEntity.getName())
                    .build();

            demoResponseDTOs.add(demoResponsesDTO);
        });
        return demoResponseDTOs;
    }
}
