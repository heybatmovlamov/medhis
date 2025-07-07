package com.qrcoderesultaccess.model.dto.response;

import java.util.Set;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PatientResponse {

    private Set<Integer> id;
}
