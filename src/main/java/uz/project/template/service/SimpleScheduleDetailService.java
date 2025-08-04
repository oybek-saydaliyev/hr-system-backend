package uz.project.template.service;

import uz.project.template.base.ApiResponse;
import uz.project.template.dto.SimpleScheduleDetailsDto;

public interface SimpleScheduleDetailService {

    ApiResponse<?> create(SimpleScheduleDetailsDto dto);

    ApiResponse<?> getOne(Long id);

    ApiResponse<?> getAll();

    ApiResponse<?> update(SimpleScheduleDetailsDto dto);

    ApiResponse<?> delete(Long id);

}
