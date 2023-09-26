package com.medicodoc.registration.repository;

import com.medicodoc.registration.dto.request.RegistrationData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<RegistrationData, Integer> {
    @Query(value = "SELECT * FROM user_reg_data WHERE username like ?1 and password like ?2 ", nativeQuery = true)
    RegistrationData validateIdPassword(String username, String password);

    @Query(value = "SELECT * FROM user_reg_data WHERE username like ?1 ", nativeQuery = true)
    List<RegistrationData> getuserdetails(String username);
}
