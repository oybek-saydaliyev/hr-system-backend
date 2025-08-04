package uz.project.template.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.project.template.base.ApiResponse;
import uz.project.template.dto.ExtraHolidaySettingsDto;
import uz.project.template.entity.ExtraHolidaySettingsEntity;
import uz.project.template.repository.ExtraHolidaySettingsRepository;
import uz.project.template.service.ExtraHolidaySettingsService;
import uz.project.template.utils.ResMessages;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExtraHolidaySettingsServiceImpl implements ExtraHolidaySettingsService {

    private final ExtraHolidaySettingsRepository extraHolidaySettingsRepository;

    @Override
    public ApiResponse<?> create(ExtraHolidaySettingsDto dto) {
        try{
            ExtraHolidaySettingsEntity entity = ExtraHolidaySettingsDto.toEntity(dto, new ExtraHolidaySettingsEntity());
            return new ApiResponse<>(true, extraHolidaySettingsRepository.save(entity), ResMessages.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> getOne(Long id) {
        try{
            Optional<ExtraHolidaySettingsEntity> byId = extraHolidaySettingsRepository.findById(id);
            if (byId.isPresent()) {
                return new ApiResponse<>(true, byId.get(), ResMessages.SUCCESS);
            }
            return new ApiResponse<>(false, "Extra holiday settings not found");
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> getAll() {
        try {
            return new ApiResponse<>(true, extraHolidaySettingsRepository.findAll(), ResMessages.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> update(ExtraHolidaySettingsDto dto) {
        try{
            Optional<ExtraHolidaySettingsEntity> byId = extraHolidaySettingsRepository.findById(dto.getId());
            if (byId.isPresent()) {
                ExtraHolidaySettingsEntity entity = ExtraHolidaySettingsDto.toEntity(dto, byId.get());
                return new ApiResponse<>(true, extraHolidaySettingsRepository.save(entity), ResMessages.SUCCESS);
            }
            return new ApiResponse<>(false, "Extra holiday settings not found");
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> delete(Long id) {
        try{
            extraHolidaySettingsRepository.deleteById(id);
            return new ApiResponse<>(true, ResMessages.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }
}
