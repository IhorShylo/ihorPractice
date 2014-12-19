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
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Яна on 19.12.14.
 */
@Controller
public class NewMessageController {
    @Resource(name = "coreComponent")
    CoreComponent coreComponent;

    @Autowired
    FacadeComponent facadeComponent;

    @Autowired
    ServiceComponent serviceComponent;
    @RequestMapping(value = "/newMessage",method = RequestMethod.GET)
    public ModelAndView showPage (HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        String someNewMessage = request.getParameter("SomeMessage");
        String message = "This is newMessage page";
        modelAndView.addObject("customMessage", message);
        modelAndView.addObject("someNewMessage", someNewMessage);
        modelAndView.setViewName("newMessage");
        return modelAndView;
    }
}