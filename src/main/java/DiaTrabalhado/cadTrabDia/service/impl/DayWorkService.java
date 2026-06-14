package DiaTrabalhado.cadTrabDia.service.impl;

import DiaTrabalhado.cadTrabDia.dto.CreateDayWorkRequest;
import DiaTrabalhado.cadTrabDia.dto.DayWorkDto;
import DiaTrabalhado.cadTrabDia.dto.UpdateDayWorkRequest;
import DiaTrabalhado.cadTrabDia.persistence.entities.DayWorkEntity;
import DiaTrabalhado.cadTrabDia.persistence.repositories.DayWorkRepository;
import DiaTrabalhado.cadTrabDia.service.IDayWorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class DayWorkService implements IDayWorkService {

    private  final DayWorkRepository dayWorkRepository;

    @Override
    public void createDayWork(CreateDayWorkRequest createDayWorkRequest){

        var dayWorkEntity = new DayWorkEntity();
        dayWorkEntity.setContractorName(createDayWorkRequest.getContractorName());
        dayWorkEntity.setDate(createDayWorkRequest.getDate());
        dayWorkEntity.setDescription(createDayWorkRequest.getDescription());
        dayWorkEntity.setAmountDue(createDayWorkRequest.getAmountDue());
        dayWorkRepository.save(dayWorkEntity);
    }

    @Override
public List<DayWorkDto> listDayWork() {
        var dayWorkList = dayWorkRepository.findByActive(true)
                .stream()
                .map(dayWorkEntity -> {
                    var dayWorkDto = new DayWorkDto();
                    dayWorkDto.setContractorName(dayWorkEntity.getContractorName());
                    dayWorkDto.setDate(dayWorkEntity.getDate());
                    dayWorkDto.setDescription(dayWorkEntity.getDescription());
                    dayWorkDto.setAmountDue(dayWorkEntity.getAmountDue());
                    return dayWorkDto;
                })
                .toList();
        return dayWorkList;
    }

    @Override
    public void updateDayWork(Long dayWorkId, UpdateDayWorkRequest updateDayWorkRequest) {


        var  entity = dayWorkRepository.findByDayWorkIdAndActive(dayWorkId, true)

                .orElseThrow(() -> new RuntimeException("Day Work not found"));

        if (updateDayWorkRequest.getContractorName() != null) {
            entity.setContractorName(updateDayWorkRequest.getContractorName());
        }

        if (updateDayWorkRequest.getDate() != null) {
            entity.setDate(updateDayWorkRequest.getDate());
        }

        if (updateDayWorkRequest.getDescription() != null) {
            entity.setDescription(updateDayWorkRequest.getDescription());
        }
        if (updateDayWorkRequest.getAmountDue() != null) {
            entity.setAmountDue(updateDayWorkRequest.getAmountDue());
        }

        dayWorkRepository.save(entity);
    }
    @Override
    public void deleteDayWork(Long dayWorkId) {

        DayWorkEntity entity = dayWorkRepository
                .findByDayWorkIdAndActive(dayWorkId, true)
                .orElseThrow(() ->
                        new RuntimeException("Day Work not found"));

        entity.setActive(false);
        dayWorkRepository.save(entity);
    }
    @Override
    public DayWorkDto dayworkById(Long dayWorkId) {

        var entity = dayWorkRepository
                .findByDayWorkIdAndActive(dayWorkId, true)
                .orElseThrow(() ->
                        new RuntimeException("Day Work not found"));

        var dto = new DayWorkDto();

        dto.setContractorName(entity.getContractorName());
        dto.setDate(entity.getDate());
        dto.setDescription(entity.getDescription());
        dto.setAmountDue(entity.getAmountDue());

        return dto;
    }
}
