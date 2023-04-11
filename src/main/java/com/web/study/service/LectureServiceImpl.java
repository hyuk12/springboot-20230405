package com.web.study.service;

import com.web.study.domain.entity.Lecture;
import com.web.study.dto.request.lecture.LectureReqDto;
import com.web.study.dto.response.LectureRespDto;
import com.web.study.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class LectureServiceImpl implements LectureService{

    private final LectureRepository lectureRepository;

    @Override
    public void registerLecture(LectureReqDto lectureReqDto) {

        Lecture lecture = lectureReqDto.toEntity();
        lectureRepository.register(lecture);
        log.info("Lecture registerDto : {}", lectureReqDto);
        log.info("Lecture entity : {}", lecture);
    }

    @Override
    public List<LectureRespDto> getLectureAll() {
        List<LectureRespDto> dtos = new ArrayList<>();
        lectureRepository.getLectureAll().forEach(entity -> dtos.add(entity.toDto()));
        return dtos;
    }

    @Override
    public LectureRespDto findLectureById(int id) {
        return lectureRepository.findLectureById(id).toDto();
    }

    @Override
    public List<LectureRespDto> getLectureBySearch(int type, String searchValue) {
        Map<String, Object> parameterMap = Map.of("type", type, "searchValue", searchValue);
        List<LectureRespDto> dtos = new ArrayList<>();

        lectureRepository.getLectureBySearch(parameterMap).forEach(entity -> dtos.add(entity.toDto()));
        return dtos;
    }
}