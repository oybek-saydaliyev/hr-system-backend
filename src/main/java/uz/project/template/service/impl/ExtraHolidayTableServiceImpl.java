package uz.project.template.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.project.template.base.ApiResponse;
import uz.project.template.dto.ExtraHolidayTableDto;
import uz.project.template.entity.ExtraHolidayTableEntity;
import uz.project.template.repository.ExtraHolidayTableRepository;
import uz.project.template.service.ExtraHolidayTableService;
import uz.project.template.utils.ResMessages;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExtraHolidayTableServiceImpl implements ExtraHolidayTableService {
    private final ExtraHolidayTableRepository extraHolidayTableRepository;

    @Override
    public ApiResponse<?> create(ExtraHolidayTableDto dto) {
        try{
            ExtraHolidayTableEntity entity = ExtraHolidayTableDto.toEntity(dto, new ExtraHolidayTableEntity());
            return new ApiResponse<>(true, extraHolidayTableRepository.save(entity), ResMessages.SUCCESS);
        }catch(Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> getOne(Long id) {
        try{
            Optional<ExtraHolidayTableEntity> byId = extraHolidayTableRepository.findById(id);
            if (byId.isPresent()) {
                return new ApiResponse<>(true, byId.get(), ResMessages.SUCCESS);
            }
            return new ApiResponse<>(false, "Extra holiday table not found");
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> getAll() {
        try{
            return new ApiResponse<>(true, extraHolidayTableRepository.findAll(), ResMessages.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> update(ExtraHolidayTableDto dto) {
        try{
            Optional<ExtraHolidayTableEntity> byId = extraHolidayTableRepository.findById(dto.getId());
            if (byId.isPresent()) {
                ExtraHolidayTableEntity entity = ExtraHolidayTableDto.toEntity(dto, byId.get());
                return new ApiResponse<>(true, extraHolidayTableRepository.save(entity), ResMessages.SUCCESS);
            }
            return new ApiResponse<>(false, "Extra holiday table not found");
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> delete(Long id) {
        try{
            extraHolidayTableRepository.deleteById(id);
            return new ApiResponse<>(true, ResMessages.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }
}
