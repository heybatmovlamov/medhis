package com.qrcoderesultaccess.dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;
import lombok.Data;

@Data
@Entity
public class PatientEntity {

    @Id
    private UUID id;
    private String patientName;
    private Integer secretCode;
    private Integer qrCode;
}
