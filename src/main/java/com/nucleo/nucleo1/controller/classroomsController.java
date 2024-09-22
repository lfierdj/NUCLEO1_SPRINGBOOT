package com.nucleo.nucleo1.controller;

import com.nucleo.nucleo1.entities.classrooms;
import com.nucleo.nucleo1.entities.courses;
import com.nucleo.nucleo1.services.coursesService;
import com.nucleo.nucleo1.services.classroomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/classrooms")
public class classroomsController {

    @Autowired
    private classroomsService classroomsService;

    @Autowired
    private coursesService coursesService;

    // List all classrooms
    @GetMapping
    public String listClassrooms(Model model) {
        List<classrooms> classrooms = classroomsService.getAllClassrooms();
        model.addAttribute("classrooms", classrooms);
        return "classrooms/index"; // HTML page to list classrooms
    }

    // Show form to create a new classroom
    @GetMapping("/new")
    public String showNewForm(Model model) {
        List<courses> courses = coursesService.getAllCourses();
        model.addAttribute("classrooms", new classrooms());
        model.addAttribute("courses", courses); // Send list of courses to form
        return "classrooms/form"; // HTML page for create/edit form
    }

    // Save or update a classroom
    @PostMapping
    public String saveClassrooms(@ModelAttribute("classrooms") classrooms classrooms) {
        classroomsService.saveOrUpdateClassroom(classrooms);
        return "redirect:/classrooms"; // Redirect to classroom list after saving
    }

    // Show form to edit an existing classroom
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        classrooms classrooms = classroomsService.getClassroomById(id);
        if (classrooms != null) {
            List<courses> courses = coursesService.getAllCourses();
            model.addAttribute("classrooms", classrooms);
            model.addAttribute("courses", courses); // Send list of courses to form
            return "classrooms/form";
        } else {
            return "redirect:/classrooms"; // If it doesn't exist, redirect to list
        }
    }

    // Delete a classroom
    @GetMapping("/delete/{id}")
    public String deleteClassrooms(@PathVariable("id") Integer id) {
        classroomsService.deleteClassroom(id);
        return "redirect:/classrooms";
    }
}

