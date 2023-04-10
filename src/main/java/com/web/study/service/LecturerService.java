package com.web.study.service;

import com.web.study.domain.entity.Lecturer;
import com.web.study.dto.request.lecture.LecturerReqDto;
import com.web.study.dto.response.LecturerRespDto;

import java.util.List;

public interface LecturerService {
    public void saveLecturer(LecturerReqDto lectureReqDto);
    public List<LecturerRespDto> getLecturerAll();
    public LecturerRespDto findLecturerById(int id);
}
