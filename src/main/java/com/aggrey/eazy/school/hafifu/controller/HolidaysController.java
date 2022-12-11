package com.aggrey.eazy.school.hafifu.controller;

import com.aggrey.eazy.school.hafifu.model.Holiday;
import com.aggrey.eazy.school.hafifu.repository.HolidaysRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Controller
public class HolidaysController {

    @Autowired
    private HolidaysRepository holidaysRepository;
    @GetMapping("/holidays/{display}")
    public String displayHolidays(@PathVariable String display,Model model) {
        if(null != display && display.equals("all")){
            model.addAttribute("festival",true);
            model.addAttribute("federal",true);
        }else if(null != display && display.equals("federal")){
            model.addAttribute("federal",true);
        }else if(null != display && display.equals("festival")){
            model.addAttribute("festival",true);
        }

        /**  we could also implement uncommented code below like shown in commented code instead casting to a list
         Iterable<Holiday> holidays = holidaysRepository.findAll();
         List<Holiday> holidayList = StreamSupport.stream(holidays.spliterator(),false)
         .collect(Collectors.toList());

         Holiday.Type[] types = Holiday.Type.values();
         for (Holiday.Type type : types) {
         model.addAttribute(type.toString(),
         (holidays.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList())));
         }
         return "holidays.html"
         **/

        List<Holiday> holidays = (List<Holiday>) holidaysRepository.findAll();
        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types) {
            model.addAttribute(type.toString(),
                    (holidays.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList())));
        }
        return "holidays.html";
    }

}
