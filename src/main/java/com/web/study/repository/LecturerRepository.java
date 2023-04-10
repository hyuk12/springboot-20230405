package com.web.study.repository;

import com.web.study.domain.entity.Lecturer;
import com.web.study.dto.response.LecturerRespDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LecturerRepository {
    public void saveLecturer(Lecturer lecturer);
    public List<Lecturer> getLecturerAll();
    public Lecturer findLecturerById(int id);
    public Lecturer findLecturerByName(String lecturerName);
}
