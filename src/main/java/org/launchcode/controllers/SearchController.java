package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        ArrayList<HashMap<String, String>> resultMapTest;
        resultMapTest = JobData.findByValue("Java");
        model.addAttribute("columns", ListController.columnChoices);
        //model.addAttribute("maps", "[1,2,3,4,5]" );
        return "search";
    }

    @RequestMapping(value = "results")
    public String searchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {
        model.addAttribute("columns", ListController.columnChoices);

        ArrayList<HashMap<String, String>> resultMap;
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");

        if(searchType.equals("all")){
            resultMap = JobData.findByValue(searchTerm);
            //System.out.println(JobData.findByValue(searchTerm));
        } else {

            resultMap = JobData.findByColumnAndValue(searchType, searchTerm);
        }

        System.out.println(resultMap);

        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");

        model.addAttribute("maps", resultMap);
        return "search";
    }

    // TODO #1 - Create handler to process search request and display results

}
