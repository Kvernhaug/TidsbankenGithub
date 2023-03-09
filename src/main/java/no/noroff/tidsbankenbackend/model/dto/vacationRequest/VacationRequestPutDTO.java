package no.noroff.tidsbankenbackend.model.dto.vacationRequest;


import lombok.Data;

import java.sql.Date;

@Data
public class VacationRequestPutDTO {
    private int id;
    private String title;
    private Date periodStart;
    private Date periodEnd;
}
