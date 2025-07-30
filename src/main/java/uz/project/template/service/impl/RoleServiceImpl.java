package uz.project.template.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.project.template.base.ApiResponse;
import uz.project.template.dto.RoleDto;
import uz.project.template.entity.PermissionEntity;
import uz.project.template.entity.RoleEntity;
import uz.project.template.repository.PermissionRepository;
import uz.project.template.repository.RoleRepository;
import uz.project.template.service.RoleService;
import uz.project.template.utils.ResMessages;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    @Override
    public ApiResponse<?> create(RoleDto dto) {
        try{
            RoleEntity entity = RoleDto.toEntity(dto, new RoleEntity());
            if (dto.getPermissions() != null && !dto.getPermissions().isEmpty()) {
                entity.setPermissions(new HashSet<>(permissionRepository.findAllById(dto.getPermissions())));
            }
            RoleEntity save = roleRepository.save(entity);
            return new ApiResponse<>(true, save, ResMessages.SUCCESS);
        }catch(Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> getOne(Long id) {
        try{
            Optional<RoleEntity> byId = roleRepository.findById(id);
            if (byId.isPresent()) {
                return new ApiResponse<>(true, byId.get(), ResMessages.SUCCESS);
            }
            return new ApiResponse<>(false, "Role not found");
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> getAll() {
        try{
            return new ApiResponse<>(true, roleRepository.findAll(), ResMessages.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> update(RoleDto dto) {
        try{
            Optional<RoleEntity> byId = roleRepository.findById(dto.getId());
            if (byId.isPresent()) {
                RoleEntity entity = byId.get();
                if (dto.getPermissions() != null && !dto.getPermissions().isEmpty()) {
                    entity.setPermissions(new HashSet<>(permissionRepository.findAllById(dto.getPermissions())));
                }
                RoleEntity save = roleRepository.save(RoleDto.toEntity(dto, entity));
                return new ApiResponse<>(true, save, ResMessages.SUCCESS);
            }
            return new ApiResponse<>(false, "Role not found");
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> delete(Long id) {
        try{
            roleRepository.deleteById(id);
            return new ApiResponse<>(true, ResMessages.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }
}
