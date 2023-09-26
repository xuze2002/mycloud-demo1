package com.yiven.user.controller;


import com.yiven.model.user.entity.Role;
import com.yiven.user.service.UserService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/temp")
public class TempController {

    @Autowired
    private Configuration configuration;

    @Autowired
    private UserService userService;

    @GetMapping("/tempPage")
    public void tempPage() throws IOException, TemplateException {
        Template template = configuration.getTemplate("login.ftl");
        List<Role> roles = userService.roles();
        Map<String,Object> map = new HashMap<>();
        map.put("roles",roles);
        template.process(map,new FileWriter("D:/learn/outStream/login.html"));

    }
}
