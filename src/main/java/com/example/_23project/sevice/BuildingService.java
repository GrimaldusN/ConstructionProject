package com.example._23project.sevice;

import com.example._23project.entity.Building;

public interface BuildingService {
    Building getBuildingById(String id);

    String removeBuildingById(String id);
}
