package com.nucleo.nucleo1.services;

import com.nucleo.nucleo1.entities.classrooms;
import com.nucleo.nucleo1.entities.teachers;

import java.util.List;
public interface teachersService {
    List<teachers> getAllTeachers();
    List<classrooms> getAllClassrooms();
    teachers getTeacherById(Integer id);
    teachers saveOrUpdateTeacher(teachers teacher);
    boolean deleteTeacher(Integer id);
}
