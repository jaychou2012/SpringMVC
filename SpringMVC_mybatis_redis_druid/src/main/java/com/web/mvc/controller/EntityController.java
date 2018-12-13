package com.web.mvc.controller;

import com.web.mvc.model.Entity;
import com.web.mvc.service.EntityService;
import com.web.mvc.service.IEntityService;
import com.web.mvc.utils.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/entity")
public class EntityController {

    @Autowired
    private IEntityService entityService;
    @Autowired
    private RedisUtils redisUtils;
    private static Logger logger = LoggerFactory.getLogger(EntityController.class);

    @RequestMapping("/{id}")
    public String getDetail(@PathVariable Integer id, Model model) {
        Entity entity = null;
        try {
            entity = entityService.findById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        redisUtils.set("entity", entity);
        model.addAttribute("text", entity.getName() + "");
        model.addAttribute("entity", entity);
        return "page";
    }

    @RequestMapping("/add/{id}")
    public String addEntity(@PathVariable Integer id, Model model) {
        Entity entity = new Entity();
        entity.setId(id);
        entity.setName("Entity");
        entity.setAge(18);
        entity.setSex("boy");
        entity.setTel("133");
        try {
            entityService.add(entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        model.addAttribute("text", id + "");
        model.addAttribute("entity", entity);
        return "page";
    }

    @RequestMapping("/all")
    public String getAll(Model model) {
        List<Entity> list = null;
        try {
            list = entityService.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        model.addAttribute("text", list.get(0).getName() + "");
        return "page";
    }

    @RequestMapping("/cache/{id}")
    public String getCacheDetail(@PathVariable Integer id, Model model) {
        Entity entity = (Entity) redisUtils.get("entity");
        model.addAttribute("text", entity.getName() + "");
        model.addAttribute("entity", entity);
        return "page";
    }

    @RequestMapping("/del/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        try {
            entityService.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        model.addAttribute("text", "del");
        return "page";
    }

    @RequestMapping("/update/{id}")
    public String update(@PathVariable Integer id, Model model) {
        Entity entity = new Entity();
        entity.setName("Update");
        entity.setAge(18);
        try {
            entityService.update(id, entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        model.addAttribute("text", "del");
        return "page";
    }
}
