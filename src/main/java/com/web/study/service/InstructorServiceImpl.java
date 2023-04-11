package com.web.study.service;

import com.web.study.domain.entity.Instructor;
import com.web.study.dto.request.lecture.InstructorReqDto;
import com.web.study.dto.response.InstructorRespDto;
import com.web.study.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;

    @Override
    public void registerInstructor(InstructorReqDto instructorReqDto) {
        Instructor entity = instructorReqDto.toEntity();
        instructorRepository.registerInstructor(entity);
        log.info("Lecturer registerDto : {}", instructorReqDto);
        log.info("Lecturer entity : {}" , entity);
    }

    @Override
    public List<InstructorRespDto> getInstructorAll() {
        List<InstructorRespDto> dtos = new ArrayList<InstructorRespDto>();
        instructorRepository.getInstructorAll().forEach(lecturer -> dtos.add(lecturer.toDto()));
        return dtos;
    }

    @Override
    public InstructorRespDto findInstructorById(int id) {
        log.info("id : {}", instructorRepository.findInstructorById(id));
        return instructorRepository.findInstructorById(id).toDto();
    }
}
