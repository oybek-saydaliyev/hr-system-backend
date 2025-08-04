package uz.project.template.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.project.template.base.ApiResponse;
import uz.project.template.dto.WorkTableDto;
import uz.project.template.entity.WorkTableEntity;
import uz.project.template.repository.WorkTableRepository;
import uz.project.template.service.WorkTableService;
import uz.project.template.utils.ResMessages;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkTableServiceImpl implements WorkTableService {

    private final WorkTableRepository workTableRepository;

    @Override
    public ApiResponse<?> createOne(WorkTableDto dto) {
        try{
            WorkTableEntity workTableEntity = WorkTableDto.toEntity(dto, new WorkTableEntity());
            return new ApiResponse<>(true, workTableRepository.save(workTableEntity), ResMessages.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> update(WorkTableDto dto) {
        try{
            Optional<WorkTableEntity> byId = workTableRepository.findById(dto.getId());
            if (byId.isPresent()) {
                WorkTableEntity workTableEntity = WorkTableDto.toEntity(dto, byId.get());
                return new ApiResponse<>(true, workTableRepository.save(workTableEntity), ResMessages.SUCCESS);
            }
            return new ApiResponse<>(false, "WorkTable not found");
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> getOne(Long id) {
        try{
            Optional<WorkTableEntity> byId = workTableRepository.findById(id);
            if (byId.isPresent()) {
                return new ApiResponse<>(true, byId.get(), ResMessages.SUCCESS);
            }
            return new ApiResponse<>(false, "WorkTable not found");
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> getAll() {
        try{
            return new ApiResponse<>(true, workTableRepository.findAll(), ResMessages.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> deleteOne(Long id) {
        try {
            workTableRepository.deleteById(id);
            return new ApiResponse<>(true, ResMessages.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }
}
