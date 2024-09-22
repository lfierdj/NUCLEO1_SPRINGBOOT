package com.nucleo.nucleo1.services;

import com.nucleo.nucleo1.entities.classrooms;

import java.util.List;
public interface classroomsService {
    List<classrooms> getAllClassrooms();
    List<classrooms> getAllCourses(); // If necessary, implement specific logic
    classrooms getClassroomById(Integer id);
    classrooms saveOrUpdateClassroom(classrooms classroom);
    boolean deleteClassroom(Integer id);
}
