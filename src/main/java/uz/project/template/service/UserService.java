package uz.project.template.service;

import uz.project.template.base.ApiResponse;
import uz.project.template.dto.UserDto;

public interface UserService {

    ApiResponse<?> createUser(UserDto userDto);
    ApiResponse<?> updateUser(UserDto userDto);
    ApiResponse<?> getUser(String id);

}
