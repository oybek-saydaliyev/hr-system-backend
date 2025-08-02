package uz.project.template.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.project.template.base.ApiResponse;
import uz.project.template.dto.UserDto;
import uz.project.template.dto.UserResponseDto;
import uz.project.template.entity.AuthUserEntity;
import uz.project.template.repository.RoleRepository;
import uz.project.template.repository.UserRepository;
import uz.project.template.service.UserService;
import uz.project.template.utils.ResMessages;

import java.util.HashSet;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public ApiResponse<?> createUser(UserDto userDto) {
        try{
            AuthUserEntity user = UserDto.toEntity(userDto, new AuthUserEntity());
            user.setRoles(new HashSet<>(roleRepository.findAllById(userDto.getRoleIds())));
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            AuthUserEntity save = userRepository.save(user);
            UserResponseDto userResponseDto = UserResponseDto.toDto(new UserResponseDto(), save);
            return new ApiResponse<>(true, userResponseDto, ResMessages.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }


    @Override
    public ApiResponse<?> updateUser(UserDto userDto) {
        try{
            Optional<AuthUserEntity> byId = userRepository.findById(userDto.getId());
            if (byId.isPresent()) {
                AuthUserEntity user = byId.get();
                user.setPassword(passwordEncoder.encode(userDto.getPassword()));
                user.setRoles(new HashSet<>(roleRepository.findAllById(userDto.getRoleIds())));
                AuthUserEntity entity = UserDto.toEntity(userDto, user);
                AuthUserEntity save = userRepository.save(entity);
                return new ApiResponse<>(true, UserResponseDto.toDto(new UserResponseDto(), save), ResMessages.SUCCESS);
            }
            return new ApiResponse<>(false, ResMessages.USER_NOT_FOUND);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> getUser(Long id) {
        try{
            Optional<AuthUserEntity> byId = userRepository.findById(id);
            if (byId.isPresent()) {
                return new ApiResponse<>(true, UserResponseDto.toDto(new UserResponseDto(), byId.get()));
            }
            return new ApiResponse<>(false, ResMessages.USER_NOT_FOUND);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> getAll(Pageable pageable) {
        try {
            return new ApiResponse<>(true, userRepository.findAll(pageable), ResMessages.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> getAllByRole(Long roleId, Pageable pageable) {
        try{
            Page<UserResponseDto> allByRoles = userRepository.findAllByRoleId(roleId, pageable);
            return new ApiResponse<>(true, allByRoles, ResMessages.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> deleteUser(Long id) {
        try{
            userRepository.deleteById(id);
            return new ApiResponse<>(true, ResMessages.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

}
