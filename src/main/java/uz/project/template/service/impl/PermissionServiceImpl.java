package uz.project.template.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.project.template.base.ApiResponse;
import uz.project.template.base.BaseDto;
import uz.project.template.dto.PermissionDto;
import uz.project.template.entity.PermissionEntity;
import uz.project.template.repository.PermissionRepository;
import uz.project.template.service.PermissionService;
import uz.project.template.utils.ResMessages;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;

    @Override
    public ApiResponse<?> create(PermissionDto permissionDto) {
        try{
            PermissionEntity permissionEntity = PermissionDto.toEntity(permissionDto, new PermissionEntity());
            PermissionEntity save = permissionRepository.save(permissionEntity);
            return new ApiResponse<>(true, save, ResMessages.SUCCESS);
        }catch(Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> getOne(Long id) {
        try{
            Optional<PermissionEntity> byId = permissionRepository.findById(id);
            if (byId.isPresent()) {
                return new ApiResponse<>(true, byId.get(), ResMessages.SUCCESS);
            }
            return new ApiResponse<>(false, "Permission not found");
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> getAll() {
        try{
            return new ApiResponse<>(true, permissionRepository.findAll(), ResMessages.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> update(PermissionDto permissionDto) {
        try{
            Optional<PermissionEntity> byId = permissionRepository.findById(permissionDto.getId());
            if (byId.isPresent()) {
                PermissionEntity permissionEntity = PermissionDto.toEntity(permissionDto, byId.get());
                PermissionEntity save = permissionRepository.save(permissionEntity);
                return new ApiResponse<>(true, save, ResMessages.SUCCESS);
            }
            return new ApiResponse<>(false, "Permission not found");
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> delete(Long id) {
        try{
            permissionRepository.deleteById(id);
            return new ApiResponse<>(true, ResMessages.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }
}
