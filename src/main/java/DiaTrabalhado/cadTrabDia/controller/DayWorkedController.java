package DiaTrabalhado.cadTrabDia.controller;


import DiaTrabalhado.cadTrabDia.dto.CreateDayWorkRequest;
import DiaTrabalhado.cadTrabDia.dto.DayWorkDto;
import DiaTrabalhado.cadTrabDia.dto.UpdateDayWorkRequest;
import DiaTrabalhado.cadTrabDia.service.IDayWorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DayWorkedController {

    private final IDayWorkService iDayWorkService;

    @PostMapping(path = "/dayWork")
    public String createDayWork(@RequestBody CreateDayWorkRequest createDayWorkRequest){
        if (createDayWorkRequest.getContractorName() == null){
            return "The Contractor Name field is required!";
        }
        if (createDayWorkRequest.getDate() == null){
            return "The Date field is required!";
        }
        if (createDayWorkRequest.getDescription() == null) {
            return "The Description field is required!";
        }
        if (createDayWorkRequest.getAmountDue() == null){
            return "The amount due field is required!";
        }
        iDayWorkService.createDayWork(createDayWorkRequest);
        return "Day Work sucessefuly registered";
    }

    @GetMapping(path = "/dayWork")
    public List<DayWorkDto> listCliente(){
        return iDayWorkService.listDayWork();
    }

    @GetMapping(path = "/dayWork/{dayWorkId}")
    public DayWorkDto DayWorkById(@PathVariable Long dayWorkId){
        return iDayWorkService.dayworkById(dayWorkId);
    }

    @PutMapping("/dayWork/{dayWorkId}")
    public String updateDayWork(
            @PathVariable Long dayWorkId,
            @RequestBody UpdateDayWorkRequest updateDayWorkRequest
    ) {
        iDayWorkService.updateDayWork(dayWorkId, updateDayWorkRequest);
        return "Customer updated successfully!";
    }

    @DeleteMapping("/dayWork/{dayWorkId}")
    public String deleteDayWork(@PathVariable Long dayworkId) {
        iDayWorkService.deleteDayWork(dayworkId);
        return "Customer deleted successfully!";
    }

}
