package org.titans.controller.aris;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.titans.annotation.AuthenPassport;
import org.titans.service.aris.ISearchService;

/**
 * 全局搜索.
 */
@Controller
@RequestMapping(value = "/search")
public class SearchController {

    /**
     * 日志对象.
     */
    private Logger log = LoggerFactory.getLogger(FlowInfoController.class);

    @Autowired
    private ISearchService searchService;
    
    @AuthenPassport
    @RequestMapping(value = "search")
    private ModelAndView searchView(String keyWord,HttpServletRequest request) {

        request.setAttribute("keyWord", keyWord);
        return new ModelAndView("/search/search");
    }

    @AuthenPassport
    @ResponseBody
    @RequestMapping(value = "searchAllFile")
    private List<Map<String, String>> queryAllFile(String searchName) {

        List<Map<String, String>> result = new ArrayList<>();
        result = searchService.queryAllFileInfo(searchName);
        return result;
    }
}
