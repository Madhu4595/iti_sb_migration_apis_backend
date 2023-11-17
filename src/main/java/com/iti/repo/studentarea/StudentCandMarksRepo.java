package com.iti.repo.studentarea;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iti.entity.studentarea.StudentCandMarksEntity;

public interface StudentCandMarksRepo extends JpaRepository<StudentCandMarksEntity, String>{

}
