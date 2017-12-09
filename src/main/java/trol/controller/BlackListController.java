package trol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import trol.service.BlackListService;

@Controller
public class BlackListController {

    @Autowired
    private BlackListService blackListService;

    @RequestMapping(value={"/blacklist"}, method = RequestMethod.GET)
    public ModelAndView getBlackList() {
        ModelAndView model = new ModelAndView();
        model.addObject("blacklist", blackListService.getBlackList());
        model.setViewName("blacklist");
        return model;
    }
}