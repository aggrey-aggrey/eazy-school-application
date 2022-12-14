package com.aggrey.eazy.school.hafifu.controller;

import com.aggrey.eazy.school.hafifu.model.Contact;
import com.aggrey.eazy.school.hafifu.model.Person;
import com.aggrey.eazy.school.hafifu.model.Profile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Component
@Controller
public class ProfileController {

    @RequestMapping("/displayProfile")
    public ModelAndView displayProfile(Model model, HttpSession httpSession) {
        Person person = (Person) httpSession.getAttribute("loggedInPerson");

        Profile profile = new Profile();
        profile.setName(person.getName());
        profile.setMobileNumber(person.getMobileNumber());
        profile.setEmail(person.getEmail());

        if (person.getAddress() != null && person.getAddress().getAddressId() > 0) {
            profile.setAddress1(person.getAddress().getAddress1());
            profile.setAddress2(person.getAddress().getAddress2());
            profile.setCity(person.getAddress().getCity());
            profile.setState(person.getAddress().getState());
            profile.setZipCode(person.getAddress().getZipCode());
        }

        ModelAndView modelAndView = new ModelAndView("profile.html");
        model.addAttribute("profile", profile);
        return modelAndView;
    }


}
