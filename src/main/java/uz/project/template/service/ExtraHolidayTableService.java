package uz.project.template.service;


import uz.project.template.base.ApiResponse;
import uz.project.template.dto.ExtraHolidayTableDto;

public interface ExtraHolidayTableService {

    ApiResponse<?> create(ExtraHolidayTableDto dto);

    ApiResponse<?> getOne(Long id);

    ApiResponse<?> getAll();

    ApiResponse<?> update(ExtraHolidayTableDto dto);

    ApiResponse<?> delete(Long id);

}
