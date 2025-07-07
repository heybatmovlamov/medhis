package com.qrcoderesultaccess.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientInfoDto {
    private String patientName;
    private String secretCode;
    private String qrCode;
}
