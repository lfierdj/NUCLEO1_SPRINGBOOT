package com.nucleo.nucleo1.controller;

import com.nucleo.nucleo1.entities.courses;
import com.nucleo.nucleo1.services.coursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class coursesController {
    @Autowired
    private coursesService coursesService;

    @GetMapping
    public String listCourses(Model model) {
        List<courses> courses = coursesService.getAllCourses();
        model.addAttribute("courses", courses);
        return "courses/index"; // HTML page to list courses
    }

    @GetMapping("/new")
    public String showNewForm(Model model) {
        model.addAttribute("courses", new courses());
        return "courses/form"; // HTML page for the create/edit form
    }

    @PostMapping
    public String saveCourses(@ModelAttribute("courses") courses courses) {
        coursesService.saveOrUpdateCourse(courses);
        return "redirect:/courses";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        courses courses = coursesService.getCourseById(id);
        if (courses != null) {
            model.addAttribute("courses", courses);
            return "courses/form";
        } else {
            return "redirect:/courses"; // If it doesn't exist, redirect to the list
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteCourses(@PathVariable("id") Integer id) {
        coursesService.deleteCourse(id);
        return "redirect:/courses";
    }
}
