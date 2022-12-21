package com.aggrey.eazy.school.hafifu.controller;

import com.aggrey.eazy.school.hafifu.model.Contact;
import com.aggrey.eazy.school.hafifu.model.Person;
import com.aggrey.eazy.school.hafifu.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
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

    @Value("${eazyschool.pageSize}")
    private int defaultPageSize;

    @Value("${eazyschool.contact.successMsg}")
    private String message;

    @Autowired
    Environment environment;


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



    private void logMessages() {
        log.error("Error message from the Dashboard page");
        log.warn("Warning message from the Dashboard page");
        log.info("Info message from the Dashboard page");
        log.debug("Debug message from the Dashboard page");
        log.trace("Trace message from the Dashboard page");

        log.error("defaultPageSize value with @Value annotation is : " + defaultPageSize);
        log.error("successMsg value with @Value annotation is : " + message);

        log.error("defaultPageSize value with Environment is : "+ environment.getProperty("eazyschool.pageSize"));
        log.error("successMsg value with Environment is : " + environment.getProperty("eazyschool.contact.successMsg"));
        log.error("Java Home environment variable using Environment is : " +environment.getProperty("JAVA_HOME"));
    }

}
