package com.web.study.service;

import com.web.study.dto.request.lecture.CourseReqDto;
import com.web.study.dto.request.lecture.LectureReqDto;
import com.web.study.dto.response.LectureRespDto;

import java.util.List;

public interface LectureService {
    public void registerLecture(LectureReqDto lectureReqDto);
    public List<LectureRespDto> getLectureAll();
    public LectureRespDto findLectureById(int id);
}
