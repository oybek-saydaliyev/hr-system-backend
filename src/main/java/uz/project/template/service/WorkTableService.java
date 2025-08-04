package uz.project.template.service;

import uz.project.template.base.ApiResponse;
import uz.project.template.dto.WorkTableDto;

public interface WorkTableService {

    ApiResponse<?> createOne(WorkTableDto dto);

    ApiResponse<?> update(WorkTableDto dto);

    ApiResponse<?> getOne(Long id);

    ApiResponse<?> getAll();

    ApiResponse<?> deleteOne(Long id);

}
