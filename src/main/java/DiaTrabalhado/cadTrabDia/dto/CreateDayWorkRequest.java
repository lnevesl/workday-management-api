package DiaTrabalhado.cadTrabDia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateDayWorkRequest {

    private String contractorName;
    private String date;
    private String description;
    private Double amountDue;


}
