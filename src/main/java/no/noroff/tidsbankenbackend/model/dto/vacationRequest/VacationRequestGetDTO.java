package no.noroff.tidsbankenbackend.model.dto.vacationRequest;


import lombok.Data;
import no.noroff.tidsbankenbackend.model.VacationRequestStatus;

import java.sql.Date;
import java.util.Set;

@Data
public class VacationRequestGetDTO {
    private int id;
    private String title;
    private Date periodStart;
    private Date periodEnd;
    private VacationRequestStatus status;
    private int user;
    private int admin;
    private Set<Integer> comments;
}
