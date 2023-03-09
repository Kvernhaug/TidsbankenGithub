package no.noroff.tidsbankenbackend.model.dto.ineligiblePeriod;

import lombok.Data;

import java.sql.Date;

@Data
public class IneligiblePeriodPutDTO {
    private int id;
    private Date periodStart;
    private Date periodEnd;
    private int creator;
}
