package uz.project.template.service;

import org.springframework.data.domain.Pageable;
import uz.project.template.base.ApiResponse;
import uz.project.template.dto.AttendanceDto;
import uz.project.template.entity.enums.AttendanceStatus;

public interface AttendanceService {

    ApiResponse<?> create(AttendanceDto dto);

    ApiResponse<?> getOne(Long id);

    ApiResponse<?> getAll(Pageable pageable);

    ApiResponse<?> getAllByUserId(Long userId, Pageable pageable);

    ApiResponse<?> getAllByGroupAndStatus(Long groupId, AttendanceStatus status, Pageable pageable);

    ApiResponse<?> update(AttendanceDto dto);

    ApiResponse<?> delete(Long id);

}
