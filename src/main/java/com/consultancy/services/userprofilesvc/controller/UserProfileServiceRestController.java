package com.consultancy.services.userprofilesvc.controller;

import com.consultancy.services.userprofilesvc.model.CreateAccountRequest;
import com.consultancy.services.userprofilesvc.model.CreateAccountResponse;
import com.consultancy.services.userprofilesvc.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class UserProfileServiceRestController {

    @Autowired
    UserProfileService userProfileService;

    @GetMapping("/check")
    public Mono<String> check(){
        return  Mono.just("working....");
    }

    @PostMapping(value = "/create-account", consumes = "application/json", produces = "application/json")
    public Mono<CreateAccountResponse> createAccount(@RequestBody CreateAccountRequest createAccountRequest){
        return userProfileService.createAccount(createAccountRequest);
    }

    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public Mono<CreateAccountResponse> login(@RequestBody CreateAccountRequest createAccountRequest){
        return userProfileService.login(createAccountRequest);
    }


}
