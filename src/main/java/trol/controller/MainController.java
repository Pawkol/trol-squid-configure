package trol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import trol.domain.filemanager.FileController;
import trol.domain.filemanager.SaveState;

@Controller
public class MainController {
    @Autowired
    private FileController fileController;

    @RequestMapping("/")
     ModelAndView index(){
        ModelAndView model = new ModelAndView("index");
        return model;
    }

    @RequestMapping("/login")
    String login(){
        return "/login";
    }

    @GetMapping("/save")
    @ResponseStatus(HttpStatus.OK)
    public void saveConfiguration(){
        fileController.saveConfiguration();
    }

    @GetMapping("/save/state")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody int getSaveState(){
        SaveState saveState = fileController.getState();
        return saveState == SaveState.FREE ? 1 : 0;
    }
}
