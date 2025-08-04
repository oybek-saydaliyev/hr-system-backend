package uz.project.template.service;

import uz.project.template.base.ApiResponse;
import uz.project.template.dto.ExtraHolidaySettingsDto;

public interface ExtraHolidaySettingsService {
    ApiResponse<?> create(ExtraHolidaySettingsDto dto);

    ApiResponse<?> getOne(Long id);

    ApiResponse<?> getAll();

    ApiResponse<?> update(ExtraHolidaySettingsDto dto);

    ApiResponse<?> delete(Long id);
}
