package com.nucleo.nucleo1.controller;

import com.nucleo.nucleo1.entities.students;
import com.nucleo.nucleo1.services.studentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class studentsController {
    @Autowired
    private studentsService studentsService;

    @GetMapping
    public String listStudents(Model model) {
        List<students> students = studentsService.getAllStudents();
        model.addAttribute("students", students);
        return "students/index"; // HTML page to list students
    }

    @GetMapping("/new")
    public String showNewForm(Model model) {
        model.addAttribute("students", new students());
        return "students/form"; // HTML page for the create/edit form
    }

    @PostMapping
    public String saveStudents(@ModelAttribute("students") students students) {
        studentsService.saveOrUpdateStudent(students);
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        students students = studentsService.getStudentById(id);
        if (students != null) {
            model.addAttribute("students", students);
            return "students/form";
        } else {
            return "redirect:/students"; // If it doesn't exist, redirect to the list
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteStudents(@PathVariable("id") Integer id) {
        studentsService.deleteStudent(id);
        return "redirect:/students";
    }
}
