package uz.project.template.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import uz.project.template.base.ApiResponse;
import uz.project.template.dto.EndpointPermissionDto;
import uz.project.template.entity.EndpointPermissionEntity;
import uz.project.template.repository.EndpointPermissionRepository;
import uz.project.template.repository.PermissionRepository;
import uz.project.template.service.EndPointPermissionService;
import uz.project.template.utils.ResMessages;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EndPointPermissionServiceImpl implements EndPointPermissionService {
    private final EndpointPermissionRepository endpointPermissionRepository;
    private final PermissionRepository permissionRepository;

    @Override
    public ApiResponse<?> create(EndpointPermissionDto dto) {
        try {
            EndpointPermissionEntity endpointPermissionEntity = EndpointPermissionDto.toEntity(dto, new EndpointPermissionEntity());
            if (dto.getPermissionId() != null) {
                endpointPermissionEntity.setPermission(permissionRepository.findById(dto.getPermissionId()).orElse(null));
            }
            return new ApiResponse<>(true, endpointPermissionRepository.save(endpointPermissionEntity), ResMessages.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> getOne(Long id) {
        try{
            Optional<EndpointPermissionEntity> byId = endpointPermissionRepository.findById(id);
            if (byId.isPresent()) {
                return new ApiResponse<>(true, byId.get(), ResMessages.SUCCESS);
            }
            return new ApiResponse<>(false, "Endpoint Permission Not Found");
        }catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> getAll() {
        try {
            return new ApiResponse<>(true, endpointPermissionRepository.findAll(), ResMessages.SUCCESS);
        }catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> update(EndpointPermissionDto dto) {
        try{
            Optional<EndpointPermissionEntity> byId = endpointPermissionRepository.findById(dto.getId());
            if (byId.isPresent()) {
                EndpointPermissionEntity endpointPermissionEntity = EndpointPermissionDto.toEntity(dto, byId.get());
                if (dto.getPermissionId() != null) {
                    endpointPermissionEntity.setPermission(permissionRepository.findById(dto.getPermissionId()).orElse(endpointPermissionEntity.getPermission()));
                }
                return new ApiResponse<>(true, endpointPermissionRepository.save(endpointPermissionEntity), ResMessages.SUCCESS);
            }
            return new ApiResponse<>(false, "Endpoint Permission Not Found");
        }catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> delete(Long id) {
        try{
            endpointPermissionRepository.deleteById(id);
            return new ApiResponse<>(true, ResMessages.SUCCESS);
        }catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public List<String> getRequiredPermissions(String path, String method) {
        List<EndpointPermissionEntity> allByHttpMethod = endpointPermissionRepository.findAllByHttpMethod(method);
        return allByHttpMethod.stream()
                .filter(mapping -> matchesPattern(mapping.getEndPointPattern(), path))
                .map(mapping -> mapping.getPermission().getName())
                .collect(Collectors.toList());
    }

    private boolean matchesPattern(String pattern, String uri){
        AntPathMatcher matcher = new AntPathMatcher();
        return matcher.match(pattern, uri);
    }
}
