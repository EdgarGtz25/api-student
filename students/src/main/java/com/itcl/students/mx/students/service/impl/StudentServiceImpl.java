package com.itcl.students.mx.students.service.impl;

import com.itcl.students.mx.students.dto.StudentDTO;
import com.itcl.students.mx.students.entity.Student;
import com.itcl.students.mx.students.exception.ResourceNotFoundException;
import com.itcl.students.mx.students.mapper.StudentMapper;
import com.itcl.students.mx.students.repository.StudentRepository;
import com.itcl.students.mx.students.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    @Override
    public List<StudentDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(StudentMapper::toDTO)
                .toList();
    }

    @Override
    public StudentDTO findById(Long id) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        return StudentMapper.toDTO(student);
    }

    @Override
    public StudentDTO create(StudentDTO dto) {
        Student student = StudentMapper.toEntity(dto);
        return StudentMapper.toDTO(repository.save(student));
    }

    @Override
    public StudentDTO update(Long id, StudentDTO dto) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setAge(dto.getAge());

        return StudentMapper.toDTO(repository.save(student));
    }

    @Override
    public void delete(Long id) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        repository.delete(student);
    }
}