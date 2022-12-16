package com.aggrey.eazy.school.hafifu.controller;

import com.aggrey.eazy.school.hafifu.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequestMapping("student")
public class StudentController {

    @GetMapping("/displayCourses")
    public ModelAndView displayCourses(Model model, HttpSession session) {
        //Get current logged user details from the session which represent data presently in the db
        Person person = (Person) session.getAttribute("loggedInPerson");
        //create view object
        ModelAndView modelAndView = new ModelAndView("courses_enrolled.html");
        //add peroon object to UI view
        modelAndView.addObject("person",person);
        return modelAndView;
    }
}
