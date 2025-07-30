package uz.project.template.service;

import uz.project.template.base.ApiResponse;
import uz.project.template.dto.PermissionDto;

public interface PermissionService {

    ApiResponse<?> create(PermissionDto permissionDto);

    ApiResponse<?> getOne(Long id);

    ApiResponse<?> getAll();

    ApiResponse<?> update(PermissionDto permissionDto);

    ApiResponse<?> delete(Long id);

}
