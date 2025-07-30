package uz.project.template.controlller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.project.template.base.ApiResponse;
import uz.project.template.dto.EndpointPermissionDto;
import uz.project.template.service.EndPointPermissionService;

@RestController
@RequestMapping("/api/v1/endpoint/permission")
public class EndPointPermission {

    private final EndPointPermissionService endPointPermissionService;

    public EndPointPermission(EndPointPermissionService endPointPermissionService) {
        this.endPointPermissionService = endPointPermissionService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody EndpointPermissionDto dto){
        return ApiResponse.controller(endPointPermissionService.create(dto));
    }

    @GetMapping("/getOne")
    public ResponseEntity<?> getOne(@RequestParam Long id){
        return ApiResponse.controller(endPointPermissionService.getOne(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return ApiResponse.controller(endPointPermissionService.getAll());
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody EndpointPermissionDto dto){
        return ApiResponse.controller(endPointPermissionService.update(dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ApiResponse.controller(endPointPermissionService.delete(id));
    }

}
