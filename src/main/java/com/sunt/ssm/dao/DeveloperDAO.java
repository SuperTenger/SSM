package com.sunt.ssm.dao;

import com.sunt.ssm.model.DeveloperModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeveloperDAO {
    List<DeveloperModel> getAllDevelopers();

    DeveloperModel getDeveloper(String id);

    boolean addDeveloper(DeveloperModel developerModel);

    boolean updateDeveloper(@Param("id")String id,@Param("name")String name);

    boolean deleteDeveloper(String id);
}
