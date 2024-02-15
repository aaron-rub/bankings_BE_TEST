package com.nighthawk.spring_portfolio.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

@Controller
public class Birds {

    @GetMapping("/birds")
    public String getRandomTip(Model model) {
        try {
            InputStream resource = new ClassPathResource("financial-tips.json").getInputStream();
            ObjectMapper mapper = new ObjectMapper();
            List<String> tips = mapper.readValue(resource, new TypeReference<List<String>>(){});
            int idx = new Random().nextInt(tips.size());
            model.addAttribute("financialTip", tips.get(idx));
            return "tip"; // Name of the Thymeleaf template
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("financialTip", "Error fetching financial tip.");
            return "error"; // Consider having an error template
        }
    }
}
