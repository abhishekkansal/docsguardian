package com.medicodoc.registration.service.impl;

import com.medicodoc.registration.dto.request.FamilyMemberData;
import com.medicodoc.registration.dto.request.RegistrationData;
import com.medicodoc.registration.repository.FamilyMemberRepository;
import com.medicodoc.registration.repository.RegistrationRepository;
import com.medicodoc.registration.service.FamilyMemberService;
import com.medicodoc.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class FamilyMemberServiceImpl implements FamilyMemberService {

    @Autowired
    private FamilyMemberRepository familyMemberRepository;

    @Override
    public String addMember(FamilyMemberData familyMemberData){
        try {
            familyMemberRepository.save(familyMemberData);//.toString();
            return "Success";
        }
        catch (Exception ex){
            ex.printStackTrace();
            return "Failure";
        }

    }
}
