package com.web.study.repository;

import com.web.study.domain.entity.Lecture;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LectureRepository {
    public int register(Lecture lecture);
}
