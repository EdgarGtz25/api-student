package com.itcl.students.mx.students.service.impl;

import com.itcl.students.mx.students.dto.StudentDTO;
import com.itcl.students.mx.students.entity.Advisor;
import com.itcl.students.mx.students.entity.Student;
import com.itcl.students.mx.students.entity.Subject;
import com.itcl.students.mx.students.exception.ResourceNotFoundException;
import com.itcl.students.mx.students.mapper.StudentMapper;
import com.itcl.students.mx.students.repository.AdvisorRepository;
import com.itcl.students.mx.students.repository.StudentRepository;
import com.itcl.students.mx.students.repository.SubjectRepository;
import com.itcl.students.mx.students.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class StudentServiceImpl implements StudentService {
    private final AdvisorRepository advisorRepo;
    private final SubjectRepository subjectRepo;
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

        Student student = new Student();
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setAge(dto.getAge());

        // 🔥 SET ADVISOR
        if (dto.getAdvisorId() != null) {
            Advisor advisor = advisorRepo.findById(dto.getAdvisorId())
                    .orElseThrow(() -> new RuntimeException("Advisor not found"));
            student.setAdvisor(advisor);
        }

        // 🔥 SET SUBJECTS
        if (dto.getSubjectIds() != null && !dto.getSubjectIds().isEmpty()) {
            List<Subject> subjects = dto.getSubjectIds()
                    .stream()
                    .map(id -> subjectRepo.findById(id)
                            .orElseThrow(() -> new RuntimeException("Subject not found")))
                    .toList();

            student.setSubjects(subjects);
        }

        return StudentMapper.toDTO(repository.save(student));
    }
    @Override
    public StudentDTO update(Long id, StudentDTO dto) {

        Student student = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setAge(dto.getAge());

        // 🔥 UPDATE ADVISOR
        if (dto.getAdvisorId() != null) {
            Advisor advisor = advisorRepo.findById(dto.getAdvisorId())
                    .orElseThrow(() -> new RuntimeException("Advisor not found"));
            student.setAdvisor(advisor);
        }

        // 🔥 UPDATE SUBJECTS
        if (dto.getSubjectIds() != null) {
            List<Subject> subjects = dto.getSubjectIds()
                    .stream()
                    .map(idSub -> subjectRepo.findById(idSub)
                            .orElseThrow(() -> new RuntimeException("Subject not found")))
                    .toList();

            student.setSubjects(subjects);
        }

        return StudentMapper.toDTO(repository.save(student));
    }

    @Override
    public void delete(Long id) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        repository.delete(student);
    }
}