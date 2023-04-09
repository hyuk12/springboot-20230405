package com.web.study.service;

import com.web.study.domain.entity.Lecture;
import com.web.study.domain.entity.LectureRegistry;
import com.web.study.domain.entity.Lecturer;
import com.web.study.domain.entity.Student;
import com.web.study.dto.request.lecture.LectureRegistryReqDto;
import com.web.study.dto.request.lecture.LectureReqDto;
import com.web.study.dto.request.lecture.LecturerReqDto;
import com.web.study.dto.request.lecture.StudentReqDto;
import com.web.study.exception.DuplicatedNameException;
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
        Lecture existingLecture = lectureRepository.findLectureByName(lectureReqDto.getLectureName());
        if (existingLecture != null) {
            throw new DuplicatedNameException("Lecture name already exists");
        }

        Lecture entity = lectureReqDto.toEntity();
        lectureRepository.register(entity);
        log.info("Lecture registerDto : {}", lectureReqDto);
        log.info("Lecture entity : {}", entity);
    }

    @Override
    public void saveStudent(StudentReqDto studentReqDto) {
        Student existingStudent = lectureRepository.findStudentByName(studentReqDto.getName());
        if (existingStudent != null) {
            throw new DuplicatedNameException("Student name already exists");
        }

        Student entity = studentReqDto.toEntity();
        lectureRepository.saveStudent(entity);
        log.info("Student registerDto : {}", studentReqDto);
        log.info("Student entity : {}", entity);
    }

    @Override
    public void saveLecturer(LecturerReqDto lecturerReqDto) {
        Lecturer entity = lecturerReqDto.toEntity();
        lectureRepository.saveLecturer(entity);
        log.info("Lecturer registerDto : {}", lecturerReqDto);
        log.info("Lecturer entity : {}" , entity);
    }

    @Override
    public void saveLectureRegistry(LectureRegistryReqDto lectureRegistryReqDto) {
        Lecture lecture = lectureRepository.findLectureByName(lectureRegistryReqDto.getLectureName());
        Student student = lectureRepository.findStudentByName(lectureRegistryReqDto.getStudentName());

        LectureRegistry lectureRegistry = lectureRegistryReqDto.toEntity(lecture.getId(), student.getId());

        lectureRepository.saveLectureRegistry(lectureRegistry);
    }


}