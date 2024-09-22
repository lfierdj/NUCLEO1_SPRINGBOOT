package com.nucleo.nucleo1.controller;

import com.nucleo.nucleo1.entities.courses;
import com.nucleo.nucleo1.entities.students;
import com.nucleo.nucleo1.entities.enrollments;
import com.nucleo.nucleo1.services.coursesService;
import com.nucleo.nucleo1.services.studentsService;
import com.nucleo.nucleo1.services.enrollmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/enrollments")
public class enrollmentsController {

    @Autowired
    private enrollmentsService enrollmentsService;

    @Autowired
    private studentsService studentsService;

    @Autowired
    private coursesService coursesService;

    // List all enrollments
    @GetMapping
    public String listEnrollments(Model model) {
        List<enrollments> enrollments = enrollmentsService.getAllEnrollments();
        model.addAttribute("enrollments", enrollments);
        return "enrollments/index"; // HTML page to list enrollments
    }

    // Show the form to create a new enrollment
    @GetMapping("/new")
    public String showNewForm(Model model) {
        List<students> students = studentsService.getAllStudents();
        List<courses> courses = coursesService.getAllCourses();
        model.addAttribute("enrollment", new enrollments());
        model.addAttribute("students", students);
        model.addAttribute("courses", courses);
        return "enrollments/form"; // Asegúrate de que este archivo exista
    }

    // Save or update an enrollment
    @PostMapping
    public String saveEnrollment(@ModelAttribute("enrollment") enrollments enrollment, Model model) {
        // Retrieve the student and course by their ID and assign them to the enrollment object
        students student = studentsService.getStudentById(enrollment.getStudents().getId_student());
        courses course = coursesService.getCourseById(enrollment.getCourses().getId_course());

        enrollment.setStudents(student);
        enrollment.setCourses(course);

        enrollmentsService.saveOrUpdateEnrollment(enrollment);
        return "redirect:/enrollments";
    }

    // Show the form to edit an existing enrollment
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        enrollments enrollment = enrollmentsService.getEnrollmentById(id);
        if (enrollment != null) {
            List<students> students = studentsService.getAllStudents();
            List<courses> courses = coursesService.getAllCourses();
            model.addAttribute("enrollment", enrollment);
            model.addAttribute("students", students); // Send student list to the form
            model.addAttribute("courses", courses); // Send course list to the form
            return "enrollments/form"; // HTML page for create/edit form
        } else {
            return "redirect:/enrollments"; // If it doesn't exist, redirect to the list
        }
    }

    // Delete an enrollment
    @GetMapping("/delete/{id}")
    public String deleteEnrollment(@PathVariable("id") Integer id) {
        enrollmentsService.deleteEnrollment(id);
        return "redirect:/enrollments";
    }
}