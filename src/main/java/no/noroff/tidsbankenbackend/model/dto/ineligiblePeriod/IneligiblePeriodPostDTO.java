package no.noroff.tidsbankenbackend.model.dto.ineligiblePeriod;

import lombok.Data;

import java.sql.Date;


@Data
public class IneligiblePeriodPostDTO {
    private Date periodStart;
    private Date periodEnd;
    private int creator;
}
