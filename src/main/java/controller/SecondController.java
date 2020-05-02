package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/secondController")
public class SecondController {

    @RequestMapping
    public ModelAndView modelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("secondView");
        return modelAndView;
    }
}
