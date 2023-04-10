package com.web.study.service;

import com.web.study.domain.entity.Lecture;
import com.web.study.domain.entity.Course;
import com.web.study.domain.entity.Lecturer;
import com.web.study.domain.entity.Student;
import com.web.study.dto.request.lecture.CourseReqDto;
import com.web.study.dto.request.lecture.LectureReqDto;
import com.web.study.exception.DuplicatedNameException;
import com.web.study.repository.LectureRepository;
import com.web.study.repository.LecturerRepository;
import com.web.study.repository.StudentRepository;
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

        Lecture entity = lectureReqDto.toEntity();
        lectureRepository.register(entity);
        log.info("Lecture registerDto : {}", lectureReqDto);
        log.info("Lecture entity : {}", entity);
    }
}