package com.aggrey.eazy.school.hafifu.controller;

import com.aggrey.eazy.school.hafifu.model.Contact;
import com.aggrey.eazy.school.hafifu.model.Profile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Component
@Controller
public class ProfileController {

    @RequestMapping("/displayProfile")
    public ModelAndView displayProfile(Model model){

        Profile profile = new Profile();
        ModelAndView modelAndView = new ModelAndView("profile.html");
        model.addAttribute("profile", profile);
        return modelAndView;
    }


}
