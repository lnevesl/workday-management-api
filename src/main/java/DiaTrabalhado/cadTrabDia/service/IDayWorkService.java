package DiaTrabalhado.cadTrabDia.service;

import DiaTrabalhado.cadTrabDia.dto.CreateDayWorkRequest;
import DiaTrabalhado.cadTrabDia.dto.DayWorkDto;
import DiaTrabalhado.cadTrabDia.dto.UpdateDayWorkRequest;

import java.util.List;

public interface IDayWorkService {

    void createDayWork(CreateDayWorkRequest createDayWorkRequest);
    List<DayWorkDto> listDayWork();
    DayWorkDto dayworkById(Long dayWorkId);
    void updateDayWork(Long dayWorkId, UpdateDayWorkRequest request);
    void deleteDayWork(Long dayWorkId);
}
