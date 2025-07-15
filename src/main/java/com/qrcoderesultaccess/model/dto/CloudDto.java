package com.qrcoderesultaccess.model.dto;

import java.util.LinkedList;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CloudDto {

    @Builder.Default
    private LinkedList<LocalDto> cloudResponseList = new LinkedList<>();
}
