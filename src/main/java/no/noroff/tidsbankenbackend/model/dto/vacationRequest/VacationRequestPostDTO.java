package no.noroff.tidsbankenbackend.model.dto.vacationRequest;


import lombok.Data;
import no.noroff.tidsbankenbackend.model.VacationRequestStatus;

import java.sql.Date;

@Data
public class VacationRequestPostDTO {
    private String title;
    private Date periodStart;
    private Date periodEnd;
    private VacationRequestStatus status;
    private int user;
}
