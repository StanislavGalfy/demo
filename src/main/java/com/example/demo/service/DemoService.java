package com.example.demo.service;

import com.example.demo.model.DemoRequestDTO;
import com.example.demo.model.DemoResponseDTO;

import java.util.List;

public interface DemoService {

    void create(DemoRequestDTO demoRequestDTO);

    List<DemoResponseDTO> getAll();

    void update(Long demoId, DemoRequestDTO demoRequestDTO);

    void delete(Long demoId);
}
