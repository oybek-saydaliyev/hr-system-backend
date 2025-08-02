package uz.project.template.controlller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.project.template.base.ApiResponse;
import uz.project.template.dto.UserDto;
import uz.project.template.service.AuthService;
import uz.project.template.service.UserService;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody UserDto userDto) {
        return ApiResponse.controller(userService.createUser(userDto));
    }

    @GetMapping("/me")
    public HashMap<String, Object> getMe(String accessToken) {
        return authService.getMe(accessToken);
    }

    @PutMapping("/update")
    public ResponseEntity<?> getUpdate(@RequestBody UserDto userDto) {
        return ApiResponse.controller(userService.updateUser(userDto));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(@RequestParam int page, @RequestParam int size) {
        return ApiResponse.controller(userService.getAll(PageRequest.of(page, size)));
    }

    @GetMapping("/getAllByRole")
    public ResponseEntity<?> getAllByRole(@RequestParam Long roleId, @RequestParam int page, @RequestParam int size) {
        return ApiResponse.controller(userService.getAllByRole(roleId, PageRequest.of(page, size)));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Long userId) {
        return ApiResponse.controller(userService.deleteUser(userId));
    }

}
