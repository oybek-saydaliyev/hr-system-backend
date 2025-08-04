package uz.project.template.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.project.template.base.ApiResponse;
import uz.project.template.dto.SimpleScheduleDetailsDto;
import uz.project.template.entity.SimpleScheduleDetailsEntity;
import uz.project.template.repository.SimpleScheduleDetailsRepository;
import uz.project.template.service.SimpleScheduleDetailService;
import uz.project.template.utils.ResMessages;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SimpleScheduleDetailServiceImpl implements SimpleScheduleDetailService {
    private final SimpleScheduleDetailsRepository simpleScheduleDetailsRepository;

    @Override
    public ApiResponse<?> create(SimpleScheduleDetailsDto dto) {
        try{
            SimpleScheduleDetailsEntity simpleScheduleDetailsEntity = SimpleScheduleDetailsDto.toEntity(dto, new SimpleScheduleDetailsEntity());
            return new ApiResponse<>(true, simpleScheduleDetailsRepository.save(simpleScheduleDetailsEntity), ResMessages.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> getOne(Long id) {
        try{
            Optional<SimpleScheduleDetailsEntity> byId = simpleScheduleDetailsRepository.findById(id);
            if (byId.isPresent()) {
                return new ApiResponse<>(true, byId.get(), ResMessages.SUCCESS);
            }
            return new ApiResponse<>(false, "Data not found");
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> getAll() {
        try{
            return new ApiResponse<>(true, simpleScheduleDetailsRepository.findAll(), ResMessages.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> update(SimpleScheduleDetailsDto dto) {
        try{
            Optional<SimpleScheduleDetailsEntity> byId = simpleScheduleDetailsRepository.findById(dto.getId());
            if (byId.isPresent()) {
                SimpleScheduleDetailsEntity simpleScheduleDetailsEntity = SimpleScheduleDetailsDto.toEntity(dto, byId.get());
                return new ApiResponse<>(true, simpleScheduleDetailsRepository.save(simpleScheduleDetailsEntity), ResMessages.SUCCESS);
            }
            return new ApiResponse<>(false, "Data not found");
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> delete(Long id) {
        try{
            simpleScheduleDetailsRepository.deleteById(id);
            return new ApiResponse<>(true, ResMessages.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }
}
