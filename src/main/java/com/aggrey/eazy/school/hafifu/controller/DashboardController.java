package com.aggrey.eazy.school.hafifu.controller;

import com.aggrey.eazy.school.hafifu.model.Contact;
import com.aggrey.eazy.school.hafifu.model.Person;
import com.aggrey.eazy.school.hafifu.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
public class DashboardController {

    @Autowired
    PersonRepository personRepository;


    @RequestMapping("/dashboard")
    public String displayDashboard(Model model, Authentication authentication, HttpSession httpSession) {

       Person person = personRepository.readByEmail(authentication.getName());
        model.addAttribute("username", person.getName());
        model.addAttribute("roles", authentication.getAuthorities().toString());

        //check if they are  any classes assigned to person  and if it is not null, check the class name
        if(null != person.getEazyClass() && null != person.getEazyClass().getName()){
            //assigned the name of the class to UI attribute
            model.addAttribute("enrolledClass", person.getEazyClass().getName());
        }
        httpSession.setAttribute("loggedInPerson", person);
        return "dashboard.html";
    }

}
