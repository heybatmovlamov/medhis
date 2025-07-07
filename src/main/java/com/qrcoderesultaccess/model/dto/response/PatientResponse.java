package com.qrcoderesultaccess.model.dto.response;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PatientResponse {

    private List<Integer> id;
}
