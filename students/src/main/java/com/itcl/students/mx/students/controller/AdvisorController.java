package com.itcl.students.mx.students.controller;

import com.itcl.students.mx.students.dto.AdvisorDTO;
import com.itcl.students.mx.students.service.AdvisorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/advisors")
@RequiredArgsConstructor
public class AdvisorController {

    private final AdvisorService service;

    @GetMapping
    public List<AdvisorDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public AdvisorDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public AdvisorDTO create(@RequestBody AdvisorDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public AdvisorDTO update(@PathVariable Long id, @RequestBody AdvisorDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}