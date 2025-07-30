package uz.project.template.service;

import uz.project.template.base.ApiResponse;
import uz.project.template.dto.GroupDto;

public interface GroupService {

    ApiResponse<?> create(GroupDto dto);

    ApiResponse<?> getOne(Long id);

    ApiResponse<?> getAll();

    ApiResponse<?> update(GroupDto dto);

    ApiResponse<?> delete(Long id);
}
