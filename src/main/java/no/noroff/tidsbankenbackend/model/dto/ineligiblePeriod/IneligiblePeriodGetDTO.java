package no.noroff.tidsbankenbackend.model.dto.ineligiblePeriod;


import lombok.Data;

import java.sql.Date;

/**
 * Ineligible period DTO for get operations
 */
@Data
public class IneligiblePeriodGetDTO {
    private int id;
    private Date periodStart;
    private Date periodEnd;
    private int user;
}
