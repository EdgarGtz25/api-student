package com.itcl.students.mx.students.service.impl;

import com.itcl.students.mx.students.dto.SubjectDTO;
import com.itcl.students.mx.students.entity.Subject;
import com.itcl.students.mx.students.mapper.SubjectMapper;
import com.itcl.students.mx.students.repository.SubjectRepository;
import com.itcl.students.mx.students.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository repository;

    @Override
    public List<SubjectDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(SubjectMapper::toDTO)
                .toList();
    }

    @Override
    public SubjectDTO findById(Long id) {
        Subject subject = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found"));
        return SubjectMapper.toDTO(subject);
    }

    @Override
    public SubjectDTO create(SubjectDTO dto) {
        return SubjectMapper.toDTO(repository.save(SubjectMapper.toEntity(dto)));
    }

    @Override
    public SubjectDTO update(Long id, SubjectDTO dto) {
        Subject subject = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        subject.setName(dto.getName());
        return SubjectMapper.toDTO(repository.save(subject));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}