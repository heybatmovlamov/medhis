package com.qrcoderesultaccess.model.dto.response;

import java.util.LinkedList;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CloudResponse {

    @Builder.Default
    private LinkedList<LocalResponse> cloudResponseList = new LinkedList<>();
}
