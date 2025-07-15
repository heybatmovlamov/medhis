package com.qrcoderesultaccess.model.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class LocalDto {

    private Integer id;
    private PatientInfoDto patientInfo;
    private List<LisReportsInfoDto> lisReportsInfo;
}
