package com.qrcoderesultaccess.dao.repository;

import com.qrcoderesultaccess.dao.entity.PatientIdEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PatientRepository extends JpaRepository<PatientIdEntity, Integer> {

    @Query(value = "CALL check_new_lis_reports_patient()", nativeQuery = true)
    List<Integer> getPatientIds();
}
