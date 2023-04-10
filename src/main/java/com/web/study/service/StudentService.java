package com.web.study.service;

import com.web.study.dto.request.student.StudentReqDto;
import com.web.study.dto.response.StudentRespDto;

import java.util.List;

public interface StudentService {
    public void saveStudent(StudentReqDto studentReqDto);
    public List<StudentRespDto> getStudentAll();
    public StudentRespDto findStudentById(int id);
}
