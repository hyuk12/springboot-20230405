package com.web.study.service;

import com.web.study.domain.entity.Student;
import com.web.study.dto.request.student.StudentReqDto;
import com.web.study.dto.response.StudentRespDto;
import com.web.study.exception.DuplicatedNameException;
import com.web.study.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    @Override
    public void saveStudent(StudentReqDto studentReqDto) {
        Student existingStudent = studentRepository.findStudentByName(studentReqDto.getName());
        if (existingStudent != null) {
            throw new DuplicatedNameException("Student name already exists");
        }

        studentRepository.saveStudent(studentReqDto.toEntity());
        log.info("Student registerDto : {}", studentReqDto);
        log.info("Student entity : {}", studentReqDto.toEntity());
    }

    @Override
    public List<StudentRespDto> getStudentAll() {
        List<StudentRespDto> dtos = new ArrayList<StudentRespDto>();
        studentRepository.getStudentAll().forEach(student -> dtos.add(student.toDto()));
        return dtos;
    }

    @Override
    public StudentRespDto findStudentById(int id) {
        return studentRepository.findStudentById(id).toDto();
    }
}
