package com.web.study.repository;

import com.web.study.domain.entity.Instructor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InstructorRepository {
    public void registerInstructor(Instructor lecturer);
    public List<Instructor> getInstructorAll();
    public Instructor findInstructorById(int id);
}
