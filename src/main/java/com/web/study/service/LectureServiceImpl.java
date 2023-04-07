package com.web.study.service;

import com.web.study.domain.entity.Lecture;
import com.web.study.dto.request.lecture.LectureReqDto;
import com.web.study.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class LectureServiceImpl implements LectureService{

    private final LectureRepository lectureRepository;

    @Override
    public void registerLecture(LectureReqDto lectureReqDto) {
        Lecture lecture = lectureReqDto.toEntity();
        lectureRepository.register(lecture);
        log.info("lecture registerDto : {}", lectureReqDto);
        log.info("lecture entity : {}" , lecture);
    }
}
