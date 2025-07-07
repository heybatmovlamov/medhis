package com.qrcoderesultaccess.model.dto.response;

import lombok.Data;

@Data
public class PatientInfoResponse {
    private String patientName;
    private String secretCode;
    private String qrCode;
}
