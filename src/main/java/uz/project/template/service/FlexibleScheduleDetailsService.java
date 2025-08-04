package uz.project.template.service;

import uz.project.template.base.ApiResponse;
import uz.project.template.dto.FlexibleScheduleDetailsDto;
import uz.project.template.entity.FlexibleScheduleDetailsEntity;

import java.util.List;

public interface FlexibleScheduleDetailsService {

    ApiResponse<?> createList(List<FlexibleScheduleDetailsDto> dtos);


    ApiResponse<?> getOne(Long id);

    ApiResponse<?> getAllByIds(List<Long> ids);

    ApiResponse<?> update(FlexibleScheduleDetailsDto dto);

    ApiResponse<?> delete(Long id);

}
