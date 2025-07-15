package com.qrcoderesultaccess.service;

import com.qrcoderesultaccess.model.dto.response.CloudResponse;

public interface DbFetcherService {

    CloudResponse fetchDbData();
}