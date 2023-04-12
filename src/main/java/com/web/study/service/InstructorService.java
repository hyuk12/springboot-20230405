package com.web.study.service;

import com.web.study.dto.request.Instructor.InstructorReqDto;
import com.web.study.dto.response.InstructorRespDto;

import java.util.List;

public interface InstructorService {
    public void registerInstructor(InstructorReqDto instructorReqDto);
    public List<InstructorRespDto> getInstructorAll();
    public InstructorRespDto findInstructorById(int id);
}
