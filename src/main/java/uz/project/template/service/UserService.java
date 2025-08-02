package uz.project.template.service;

import org.springframework.data.domain.Pageable;
import uz.project.template.base.ApiResponse;
import uz.project.template.dto.UserDto;

public interface UserService {

    ApiResponse<?> createUser(UserDto userDto);
    ApiResponse<?> updateUser(UserDto userDto);
    ApiResponse<?> getUser(Long id);
    ApiResponse<?> getAll(Pageable pageable);
    ApiResponse<?> getAllByRole(Long roleId, Pageable pageable);
    ApiResponse<?> deleteUser(Long id);

}
