package com.qrcoderesultaccess.dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class PatientIdEntity {

    @Id
    private Long id;
}
