package com.spring.boot.view_resolvers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("report")
public class ReportController {
    public ModelAndView showReport() {
        //dummy data
        Map<String, String> revenueData = new HashMap<String, String>();
        revenueData.put("1/20/2010", "$100,000");
        revenueData.put("1/21/2010", "$200,000");
        revenueData.put("1/22/2010", "$300,000");
        revenueData.put("1/23/2010", "$400,000");
        revenueData.put("1/24/2010", "$500,000");
        return new ModelAndView("PdfRevenueSummary", "revenueData", revenueData);
    }
}
