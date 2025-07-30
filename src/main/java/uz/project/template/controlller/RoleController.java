package uz.project.template.controlller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.project.template.base.ApiResponse;
import uz.project.template.dto.RoleDto;
import uz.project.template.service.RoleService;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody RoleDto dto){
        return ApiResponse.controller(roleService.create(dto));
    }

    @GetMapping("/getOne")
    public ResponseEntity<?> getOne(@RequestParam Long id){
        return ApiResponse.controller(roleService.getOne(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return ApiResponse.controller(roleService.getAll());
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody RoleDto dto){
        return ApiResponse.controller(roleService.update(dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ApiResponse.controller(roleService.delete(id));
    }

}
