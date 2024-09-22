package com.nucleo.nucleo1.controller;

import com.nucleo.nucleo1.entities.classrooms;
import com.nucleo.nucleo1.entities.teachers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teachers")
public class teachersController {
    @Autowired
    private com.nucleo.nucleo1.services.teachersService teachersService;

    @Autowired
    private com.nucleo.nucleo1.services.classroomsService classroomsService;

    // List all teachers
    @GetMapping
    public String listTeachers(Model model) {
        List<teachers> teachers = teachersService.getAllTeachers();
        model.addAttribute("teachers", teachers);
        return "teachers/index"; // HTML page to list teachers
    }

    // Show the form to create a new teacher
    @GetMapping("/new")
    public String showNewForm(Model model) {
        List<classrooms> classrooms = classroomsService.getAllClassrooms();
        model.addAttribute("teachers", new teachers());
        model.addAttribute("classrooms", classrooms); // Send list of classrooms to the form
        return "teachers/form"; // HTML page for the create/edit form
    }

    // Save or update a teacher
    @PostMapping
    public String saveTeachers(@ModelAttribute("teachers") teachers teachers) {
        teachersService.saveOrUpdateTeacher(teachers);
        return "redirect:/teachers"; // Redirect to the list of teachers after saving
    }

    // Show the form to edit an existing teacher
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        teachers teachers = teachersService.getTeacherById(id);
        if (teachers != null) {
            List<classrooms> classrooms = classroomsService.getAllClassrooms();
            model.addAttribute("teachers", teachers);
            model.addAttribute("classrooms", classrooms); // Send list of classrooms to the form
            return "teachers/form";
        } else {
            return "redirect:/teachers"; // If it doesn't exist, redirect to the list
        }
    }

    // Delete a teacher
    @GetMapping("/delete/{id}")
    public String deleteTeachers(@PathVariable("id") Integer id) {
        teachersService.deleteTeacher(id);
        return "redirect:/teachers";
    }
}
