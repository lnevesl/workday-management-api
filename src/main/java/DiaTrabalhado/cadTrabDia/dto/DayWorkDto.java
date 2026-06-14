package DiaTrabalhado.cadTrabDia.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DayWorkDto {

    private String contractorName;
    private String date;
    private String description;
    private Double amountDue;
}
