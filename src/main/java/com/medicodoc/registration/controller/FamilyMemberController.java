package com.medicodoc.registration.controller;

import com.medicodoc.registration.dto.request.FamilyMemberData;
import com.medicodoc.registration.dto.response.FamilyMemberAdditionResponse;
import com.medicodoc.registration.repository.FamilyMemberRepository;
import com.medicodoc.registration.service.FamilyMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FamilyMemberController {

    @Autowired
    FamilyMemberService familyMemberService;

    @PostMapping(value = "/addmember")
    public FamilyMemberAdditionResponse userRegistration(@RequestBody(required = true) FamilyMemberData familyMemberData) {
        String response;
        FamilyMemberAdditionResponse familyMemberAdditionResponse= new FamilyMemberAdditionResponse();
        try {
            String resp = familyMemberService.addMember(familyMemberData);
            familyMemberAdditionResponse.setFamilymemberadded(resp);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("some error occured");
            //familyMemberAdditionResponse.setFamilymemberadded("Failure");

        }
        return familyMemberAdditionResponse;
    }
}