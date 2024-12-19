package com.example.project2.controller;

import com.example.project2.model.StudentModel;
import com.example.project2.service.InMemoryStudentImpl;
import com.example.project2.service.StudentService;
import com.example.project2.service.StudentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String getStudentAll(Model model){
        var students = studentService.findAllStudent();
        model.addAttribute("students",students);
        return "student";
    }

    @GetMapping("/create")
    public String getCreateStudent(
            StudentModel studentModel
    ){
        return  "createStudent";
    }

    @PostMapping("/create")
    public String postCreateStudent(
            @Valid
            @ModelAttribute("studentModel")  StudentModel studentModel,
            BindingResult result, Model model
    ){
        if (studentModel.getPersonaDataModel().getPassportNumber().isEmpty() ||
                studentModel.getPersonaDataModel().getPassportNumber().length() < 10) {
            result.rejectValue("personaDataModel.passportNumber", "error.invalid", "Паспорт должен быть 10 символов");
            return "createStudent";
        }

        if(result.hasErrors()){
            model.addAttribute("errors", result.getFieldErrors());
            return "createStudent";
        }
        studentService.createStudent(studentModel);
        return "redirect:/student";
    }
}
