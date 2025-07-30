package uz.project.template.controlller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.project.template.base.ApiResponse;
import uz.project.template.dto.PermissionDto;
import uz.project.template.service.PermissionService;

@RestController
@RequestMapping("/api/v1/permission")
public class PermissionController {

    private final PermissionService permissionService;

    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PermissionDto dto) {
        return ApiResponse.controller(permissionService.create(dto));
    }

    @GetMapping("/getOne")
    public ResponseEntity<?> getOne(@RequestParam Long id) {
        return ApiResponse.controller(permissionService.getOne(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return ApiResponse.controller(permissionService.getAll());
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody PermissionDto dto) {
        return ApiResponse.controller(permissionService.update(dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ApiResponse.controller(permissionService.delete(id));
    }

}
