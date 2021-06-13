package com.wangyang.bioinfo.web;

import com.wangyang.bioinfo.pojo.enums.ProjectStatus;
import com.wangyang.bioinfo.pojo.vo.KeyAndValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyang
 * @date 2021/6/13
 */
@RestController
@RequestMapping("/api/enum")
public class EMUMController {

    @GetMapping("/projectStatuses")
    public List<KeyAndValue> projectStatuses(){
        List<KeyAndValue> keyAndValues = new ArrayList<>();
        for(ProjectStatus projectStatus: ProjectStatus.values()){
            KeyAndValue keyAndValue = new KeyAndValue(projectStatus.getCode(),projectStatus.getValue());
            keyAndValues.add(keyAndValue);
        }
        return keyAndValues;
    }
}
