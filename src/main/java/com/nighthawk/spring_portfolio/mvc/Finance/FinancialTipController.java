package com.nighthawk.spring_portfolio.mvc.Finance;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.HashMap;
import java.util.Random;

@RestController
public class FinancialTipController {

    @GetMapping("/random-tip")
    public String getRandomTip() {
        try {
            File resource = new ClassPathResource("financial-tips.json").getFile();
            ObjectMapper mapper = new ObjectMapper();
            HashMap<String, Object> data = mapper.readValue(resource, HashMap.class);
            String[] tips = ((java.util.ArrayList<String>)data.get("tips")).toArray(new String[0]);
            int idx = new Random().nextInt(tips.length);
            return tips[idx];
        } catch (Exception e) {
            e.printStackTrace();
            return "Error fetching financial tip.";
        }
    }
}
