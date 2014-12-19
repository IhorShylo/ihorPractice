package org.artdevs.meetingslog.web.controllers;

import org.artdevs.meetingslog.core.dao.CoreComponent;
import org.artdevs.meetingslog.facades.FacadeComponent;
import org.artdevs.meetingslog.services.ServiceComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by Яна on 19.12.14.
 */
@Controller
public class RegistrationController {
    @Resource(name = "coreComponent")
    CoreComponent coreComponent;

    @Autowired
    FacadeComponent facadeComponent;

    @Autowired
    ServiceComponent serviceComponent;
    @RequestMapping(value = "/registration",method = RequestMethod.GET)
    public ModelAndView showPage () {
        ModelAndView modelAndView = new ModelAndView();
        String message = "This is registration page";
        modelAndView.addObject("customMessage", message);
        modelAndView.setViewName("registration");
        return modelAndView;
    }
}
