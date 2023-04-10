package com.web.study.service;

import com.web.study.domain.entity.Lecturer;
import com.web.study.dto.request.lecture.LecturerReqDto;
import com.web.study.dto.response.LecturerRespDto;
import com.web.study.repository.LecturerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LecturerServiceImpl implements LecturerService{

    private final LecturerRepository lecturerRepository;

    @Override
    public void saveLecturer(LecturerReqDto lecturerReqDto) {
        Lecturer entity = lecturerReqDto.toEntity();
        lecturerRepository.saveLecturer(entity);
        log.info("Lecturer registerDto : {}", lecturerReqDto);
        log.info("Lecturer entity : {}" , entity);
    }

    @Override
    public List<LecturerRespDto> getLecturerAll() {
        List<LecturerRespDto> dtos = new ArrayList<LecturerRespDto>();
        lecturerRepository.getLecturerAll().forEach(lecturer -> dtos.add(lecturer.toDto()));
        return dtos;
    }

    @Override
    public LecturerRespDto findLecturerById(int id) {
        log.info("id : {}", lecturerRepository.findLecturerById(id));
        return lecturerRepository.findLecturerById(id).toDto();
    }
}
