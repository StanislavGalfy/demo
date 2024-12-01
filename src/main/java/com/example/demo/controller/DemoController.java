package com.example.demo.controller;

import com.example.demo.model.DemoRequestDTO;
import com.example.demo.model.DemoResponseDTO;
import com.example.demo.service.DemoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("demo")
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void create(@RequestBody @NotNull @Valid DemoRequestDTO demoRequestDTO) {
        demoService.create(demoRequestDTO);
    }

    @GetMapping
    public List<DemoResponseDTO> getAll() {
        return demoService.getAll();
    }

    @PutMapping("/{demoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(
            @PathVariable @NotNull @Positive Long demoId,
            @RequestBody @NotNull @Valid DemoRequestDTO demoRequestDTO
    ) {
        demoService.update(demoId, demoRequestDTO);
    }

    @DeleteMapping("/{demoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long demoId) {
        demoService.delete(demoId);
    }
}
