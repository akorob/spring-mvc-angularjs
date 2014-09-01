package com.akorobtc.angualrspringapp.controller;

import com.akorobtc.angualrspringapp.beans.SiteImageInfo;
import com.akorobtc.angualrspringapp.service.SearchService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {
	
	private static final Logger logger = LoggerFactory.
			getLogger(SearchController.class);

    
    @Autowired
    private SearchService searchService;

    @RequestMapping(value = "/getSitesInfo", method = RequestMethod.POST)
    public @ResponseBody List<SiteImageInfo>
    	searchSitesInfo( @RequestBody List<String> urls){
    	logger.debug("/getSitesInfo");
        return searchService.findSiteImageInfo(urls);
    }
    
    @RequestMapping("/layout")
    public String getSearchPartialPage(ModelMap modelMap) {
        return "search/layout";
    }
 
}
