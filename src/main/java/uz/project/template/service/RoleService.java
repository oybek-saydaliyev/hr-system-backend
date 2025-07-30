package uz.project.template.service;

import uz.project.template.base.ApiResponse;
import uz.project.template.dto.RoleDto;

public interface RoleService {

    ApiResponse<?> create(RoleDto dto);

    ApiResponse<?> getOne(Long id);

    ApiResponse<?> getAll();

    ApiResponse<?> update(RoleDto dto);

    ApiResponse<?> delete(Long id);

}
