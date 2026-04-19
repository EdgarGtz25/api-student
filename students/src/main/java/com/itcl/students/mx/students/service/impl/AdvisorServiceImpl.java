package com.itcl.students.mx.students.service.impl;

import com.itcl.students.mx.students.dto.AdvisorDTO;
import com.itcl.students.mx.students.entity.Advisor;
import com.itcl.students.mx.students.entity.Subject;
import com.itcl.students.mx.students.mapper.AdvisorMapper;
import com.itcl.students.mx.students.repository.AdvisorRepository;
import com.itcl.students.mx.students.repository.SubjectRepository;
import com.itcl.students.mx.students.service.AdvisorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdvisorServiceImpl implements AdvisorService {

    private final AdvisorRepository advisorRepo;
    private final SubjectRepository subjectRepo;

    @Override
    public List<AdvisorDTO> findAll() {
        return advisorRepo.findAll()
                .stream()
                .map(AdvisorMapper::toDTO)
                .toList();
    }

    @Override
    public AdvisorDTO findById(Long id) {
        Advisor advisor = advisorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Advisor not found"));
        return AdvisorMapper.toDTO(advisor);
    }

        @Override
        public AdvisorDTO create(AdvisorDTO dto) {
            Advisor advisor = AdvisorMapper.toEntity(dto, subjectRepo);
            return AdvisorMapper.toDTO(advisorRepo.save(advisor));
        }

        @Override
        public AdvisorDTO update(Long id, AdvisorDTO dto) {
            Advisor advisor = advisorRepo.findById(id)
                    .orElseThrow(() -> new RuntimeException("Not found"));

            advisor.setName(dto.getName());
            advisor.setEmail(dto.getEmail());

            if (dto.getSubjectIds() != null) {
                List<Subject> subjects = new ArrayList<>(
                        dto.getSubjectIds()
                                .stream()
                                .map(subjectRepo::findById)
                                .filter(Optional::isPresent)
                                .map(Optional::get)
                                .toList()
                );

                advisor.setSubjects(subjects);
            }

            return AdvisorMapper.toDTO(advisorRepo.save(advisor));
        }

    @Override
    public void delete(Long id) {
        advisorRepo.deleteById(id);
    }
}