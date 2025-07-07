package com.qrcoderesultaccess.dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class PatientEntity {

    @Id
    private Integer id;
    private String patientName;
    private String secretCode;
    private String qrCode;
}
