package com.akorobtc.angualrspringapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.akorobtc.angualrspringapp.beans.SiteImageInfo;
import com.akorobtc.angualrspringapp.service.SearchService;


@Controller
@RequestMapping("/results")
public class AllResultsController {
	
	private static final Logger logger = LoggerFactory.
			getLogger(AllResultsController.class);


    @RequestMapping("/layout")
    public String getResultsPartialPage(ModelMap modelMap) {
        return "results/layout";
    }
}
