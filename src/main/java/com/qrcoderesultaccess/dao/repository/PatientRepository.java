package com.qrcoderesultaccess.dao.repository;

import com.qrcoderesultaccess.dao.entity.PatientIdEntity;
import com.qrcoderesultaccess.dao.entity.PatientInfoDto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PatientRepository extends JpaRepository<PatientIdEntity, Integer> {

    @Query(value = "CALL check_new_lis_reports_patient()", nativeQuery = true)
    List<Integer> getPatientIds();

    @Query(value = "CALL get_patient_qr_secret_code(:p_id)", nativeQuery = true)
    List<PatientInfoDto> getPatientInfo(@Param("p_id") Long id);
}
