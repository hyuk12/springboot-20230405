package com.web.study.service;

import com.web.study.dto.request.lecture.LectureRegistryReqDto;
import com.web.study.dto.request.lecture.LectureReqDto;
import com.web.study.dto.request.lecture.LecturerReqDto;
import com.web.study.dto.request.lecture.StudentReqDto;

public interface LectureService {
    public void registerLecture(LectureReqDto lectureReqDto);
    public void saveStudent(StudentReqDto studentReqDto);
    public void saveLecturer(LecturerReqDto lectureReqDto);

    public void saveLectureRegistry(LectureRegistryReqDto lectureRegistryReqDto);
}
