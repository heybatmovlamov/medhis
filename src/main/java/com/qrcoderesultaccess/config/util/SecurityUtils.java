package com.qrcoderesultaccess.config.util;

import java.util.UUID;
import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityUtils {

    // 🔐 Dinamik public key yarat (hash ilə)
    public String generatePublicKey(String clinicId, String timestamp, String nonce) {

        // istəsən SHA-256 ilə normal hash də istifadə edə bilərsən

        return HmacUtils.hmacSha256Hex("Private_Key", clinicId + timestamp + nonce);
    }

    // 🔐 Encrypted key yarat (public key + private key)
    public String generateHmac(String privateKey, String dataToSign) {
        return HmacUtils.hmacSha256Hex(privateKey, dataToSign);
    }

    // 🕒 Hal-hazırkı timestamp (millis cinsindən)
    public String getCurrentTimestamp() {
        return String.valueOf(System.currentTimeMillis());
    }

    // 🔄 Random nonce (təkrarlanmasın deyə)
    public String generateNonce() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 12);
    }
}
