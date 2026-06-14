package DiaTrabalhado.cadTrabDia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UpdateDayWorkRequest {

    private String contractorName;
    private String date;
    private String description;
    private Double amountDue;
}
