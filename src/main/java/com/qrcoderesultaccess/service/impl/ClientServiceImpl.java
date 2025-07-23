package com.qrcoderesultaccess.service.impl;

import com.qrcoderesultaccess.config.CloudClient;
import com.qrcoderesultaccess.config.util.SecurityUtils;
import com.qrcoderesultaccess.model.dto.CloudDto;
import com.qrcoderesultaccess.service.ClientService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {

    private final CloudClient client;
    private final SecurityUtils securityUtils;

    public List<Integer> uploadToCloud(CloudDto cloudDto) {
        String clinicId = "1";
        String privateKey = "clinic1PrivateKey";
        String timestamp = securityUtils.getCurrentTimestamp();
        String nonce = securityUtils.generateNonce();

        String publicKey = securityUtils.generatePublicKey(clinicId, timestamp, nonce);
        String encryptedKey = securityUtils.generateHmac(privateKey, publicKey);
        log.info("📤 Göndərilməyə hazır olan sorğu:");
        log.info("Clinic ID       : {}", clinicId);
        log.info("Timestamp       : {}", timestamp);
        log.info("Nonce           : {}", nonce);
        log.info("Public Key      : {}", publicKey);
        log.info("Encrypted Key   : {}", encryptedKey);
        log.info("CloudDto JSON   : {}", cloudDto);

        return client.uploadToCloud(
                clinicId,
                timestamp,
                nonce,
                publicKey,
                encryptedKey,
                cloudDto
        );
    }
}
