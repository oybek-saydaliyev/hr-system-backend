package uz.project.template.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.project.template.base.ApiResponse;
import uz.project.template.dto.AttendanceDto;
import uz.project.template.entity.AttendanceEntity;
import uz.project.template.entity.enums.AttendanceStatus;
import uz.project.template.repository.AttendanceRepository;
import uz.project.template.service.AttendanceService;
import uz.project.template.utils.ResMessages;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {
    private final AttendanceRepository attendanceRepository;

    @Override
    public ApiResponse<?> create(AttendanceDto dto) {
        try{
            AttendanceEntity attendanceEntity = AttendanceDto.toEntity(dto, new AttendanceEntity());
            AttendanceEntity save = attendanceRepository.save(attendanceEntity);
            return new ApiResponse<>(true, save, ResMessages.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> getOne(Long id) {
        try{
            Optional<AttendanceEntity> byId = attendanceRepository.findById(id);
            if (byId.isPresent()) {
                return new ApiResponse<>(true, byId.get(), ResMessages.SUCCESS);
            }
            return new ApiResponse<>(false, "Attendance not found");
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> getAll(Pageable pageable) {
        try{
            return new ApiResponse<>(true, attendanceRepository.findAll(pageable), ResMessages.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> getAllByUserId(Long userId, Pageable pageable) {
        try{
            Page<AttendanceEntity> allByUserId = attendanceRepository.findAllByUserId(userId, pageable);
            return new ApiResponse<>(true, allByUserId, ResMessages.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> getAllByGroupAndStatus(Long groupId, AttendanceStatus status, Pageable pageable) {
        try{
            Page<AttendanceEntity> allByUserGroupIdAndStatus = attendanceRepository.findAllByUser_GroupIdAndStatus(groupId, status, pageable);
            return new ApiResponse<>(true, allByUserGroupIdAndStatus, ResMessages.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> update(AttendanceDto dto) {
        try{
            Optional<AttendanceEntity> byId = attendanceRepository.findById(dto.getId());
            if (byId.isPresent()) {
                AttendanceEntity attendanceEntity = AttendanceDto.toEntity(dto, byId.get());
                AttendanceEntity save = attendanceRepository.save(attendanceEntity);
                return new ApiResponse<>(true, save, ResMessages.SUCCESS);
            }
            return new ApiResponse<>(false, "Attendance not found");
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> delete(Long id) {
        try{
            attendanceRepository.deleteById(id);
            return new ApiResponse<>(true, ResMessages.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }
}
