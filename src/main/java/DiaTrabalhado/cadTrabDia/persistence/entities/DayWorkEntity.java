package DiaTrabalhado.cadTrabDia.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Table(name = "tb_workday", schema = "public")
public class DayWorkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "workday_id" , nullable = false)
    private Long dayWorkId;

    @Setter
    @Column(name = "contractor_name" , nullable = false )
    private String contractorName;

    @Setter
    @Column(name = "date" , nullable = false )
    private String date;

    @Setter
    @Column(name = "description" , nullable = false )
    private String description;
    @Setter
    @Column(name = "amount_due" , nullable = false )
    private Double amountDue;

    @Setter
    @Column(name = "active" , nullable = false )
    private Boolean active;

}
