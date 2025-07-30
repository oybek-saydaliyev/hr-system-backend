package uz.project.template.service;

import uz.project.template.base.ApiResponse;
import uz.project.template.dto.AttendanceDto;
import uz.project.template.entity.enums.AttendanceStatus;

public interface AttendanceService {

    ApiResponse<?> create(AttendanceDto dto);

    ApiResponse<?> getOne(Long id);

    ApiResponse<?> getAll();

    ApiResponse<?> getAllByUserId(Long userId);

    ApiResponse<?> getAllByGroupAndStatus(Long groupId, AttendanceStatus status);

    ApiResponse<?> update(AttendanceDto dto);

    ApiResponse<?> delete(Long id);

}
