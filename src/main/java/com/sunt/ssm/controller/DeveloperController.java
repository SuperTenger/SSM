package com.sunt.ssm.controller;

import com.sunt.ssm.model.CommonModel;
import com.sunt.ssm.model.DeveloperModel;
import com.sunt.ssm.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/developer")
public class DeveloperController {

    private DeveloperService developerService;

    @Autowired
    DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @RequestMapping(value = "/api/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/api/developers", method = RequestMethod.GET)
    @ResponseBody
    public CommonModel getAllDevelopers() {
        List<DeveloperModel> lists = developerService.getAllDevelopers();
        CommonModel commonModel = new CommonModel();
        if (lists.size() > 0) {
            commonModel.setSuccess();
            commonModel.setData(lists);
        } else {
            commonModel.setFail();
        }
        return commonModel;
    }

    @RequestMapping(value = "/api/developer", method = RequestMethod.GET)
    @ResponseBody
    public CommonModel getDeveloper(String id) {
        CommonModel commonModel = new CommonModel();
        DeveloperModel developerModel = developerService.getDeveloper(id);
        if (developerModel != null) {
            commonModel.setSuccess();
            commonModel.setData(developerModel);
        } else {
            commonModel.setFail();
        }

        return commonModel;
    }

    @RequestMapping(value = "/api/developer/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonModel addDeveloper(String name, String site) {
        CommonModel commonModel = new CommonModel();
        DeveloperModel developerModel = new DeveloperModel();
        developerModel.setName(name);
        developerModel.setSite(site);
        boolean result = developerService.addDeveloper(developerModel);
        if (result) {
            commonModel.setSuccess();
        } else {
            commonModel.setFail();
        }
        return commonModel;
    }

    @RequestMapping(value = "/api/developer/update", method = RequestMethod.POST)
    @ResponseBody
    public CommonModel updateDeveloper(String id, String name) {
        CommonModel commonModel = new CommonModel();
        if (developerService.updateDeveloper(id, name)) {
            commonModel.setSuccess();
        } else {
            commonModel.setFail();
        }
        return commonModel;
    }

    @RequestMapping(value = "/api/developer/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonModel deleteDeveloper(String id) {
        CommonModel commonModel = new CommonModel();
        if (developerService.deleteDeveloper(id)) {
            commonModel.setSuccess();
        } else {
            commonModel.setFail();
        }
        return commonModel;
    }

}
