package com.qrcoderesultaccess.dao.repository;

import com.qrcoderesultaccess.dao.entity.PatientIdEntity;
import com.qrcoderesultaccess.model.dto.response.LisReportsInfoResponse;
import com.qrcoderesultaccess.model.dto.response.PatientInfoResponse;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PatientRepository extends JpaRepository<PatientIdEntity, Integer> {

    @Query(value = "CALL check_new_lis_reports_patient()", nativeQuery = true)
    Set<Integer> getPatientIds();

    @Query(value = "CALL get_patient_qr_secret_code(:p_id)", nativeQuery = true)
    Optional<PatientInfoResponse> getPatientInfo(@Param("p_id") Long id);

    @Query(value = "CALL check_new_lis_reports(:p_id)", nativeQuery = true)
    List<LisReportsInfoResponse> getNewLisReport(@Param("p_id") Long id);
}
