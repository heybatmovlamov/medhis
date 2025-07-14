package com.qrcoderesultaccess.model.dto.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class LocalResponse {

    private Integer id;
    private PatientInfoResponse patientInfo;
    private List<LisReportsInfoResponse> lisReportsInfo;
}
