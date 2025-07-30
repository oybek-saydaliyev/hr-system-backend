package uz.project.template.repository;

import uz.project.template.base.BaseRepository;
import uz.project.template.entity.EndpointPermissionEntity;

import java.util.List;

public interface EndpointPermissionRepository extends BaseRepository<uz.project.template.entity.EndpointPermissionEntity> {
    List<EndpointPermissionEntity> findAllByHttpMethod(String httpMethod);
}