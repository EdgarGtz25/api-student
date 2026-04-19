package com.itcl.students.mx.students.controller;

import com.itcl.students.mx.students.dto.SubjectDTO;
import com.itcl.students.mx.students.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService service;

    @GetMapping
    public List<SubjectDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public SubjectDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public SubjectDTO create(@RequestBody SubjectDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public SubjectDTO update(@PathVariable Long id, @RequestBody SubjectDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
