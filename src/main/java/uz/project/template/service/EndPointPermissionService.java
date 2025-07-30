package uz.project.template.service;

import uz.project.template.base.ApiResponse;
import uz.project.template.dto.EndpointPermissionDto;

import java.util.List;

public interface EndPointPermissionService {

    ApiResponse<?> create(EndpointPermissionDto dto);

    ApiResponse<?> getOne(Long id);

    ApiResponse<?> getAll();

    ApiResponse<?> update(EndpointPermissionDto dto);

    ApiResponse<?> delete(Long id);

    List<String> getRequiredPermissions(String path, String method);

}
