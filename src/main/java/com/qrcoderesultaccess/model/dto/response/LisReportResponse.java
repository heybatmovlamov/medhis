package com.qrcoderesultaccess.model.dto.response;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LisReportResponse {
    private Integer uniqueId;
    private Integer sesId;
    private Integer orderId;
    private Integer blankId;
    private Integer cooperativeId;
    private Integer patientId;
    private String fileName;
    private Timestamp registrationTime;
    private Timestamp approveTime;
}
