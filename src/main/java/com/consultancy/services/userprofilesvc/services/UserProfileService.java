package com.consultancy.services.userprofilesvc.services;

import com.consultancy.services.userprofilesvc.entity.UserAccount;
import com.consultancy.services.userprofilesvc.model.CreateAccountRequest;
import com.consultancy.services.userprofilesvc.model.CreateAccountResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class UserProfileService {

    public  Mono<CreateAccountResponse> createAccount(CreateAccountRequest createAccountRequest){
        Configuration cf = new Configuration().configure().addAnnotatedClass(UserAccount.class);
        ServiceRegistry sfr = new ServiceRegistryBuilder().applySettings(cf.getProperties()).buildServiceRegistry();
        SessionFactory sf =  cf.buildSessionFactory(sfr);
        Session session = sf.openSession();
        UserAccount userAccount = new UserAccount();
        userAccount.setEmailId(createAccountRequest.getEmailId());
        userAccount.setPassword(createAccountRequest.getPassword());
        Transaction tr = session.beginTransaction();
        session.save(userAccount);
        tr.commit();
        return null;

    }

    public  Mono<CreateAccountResponse> login(CreateAccountRequest createAccountRequest){
        Configuration cf = new Configuration().configure().addAnnotatedClass(UserAccount.class);
        SessionFactory sf =  cf.buildSessionFactory();
        Session session = sf.openSession();
        UserAccount userAccount = new UserAccount();
        userAccount.setEmailId(createAccountRequest.getEmailId());
        userAccount.setPassword(createAccountRequest.getPassword());
        Transaction tr = session.beginTransaction();
        UserAccount retrievedAccount = (UserAccount) session.get(UserAccount.class, createAccountRequest.getEmailId());
        tr.commit();
        CreateAccountResponse response = new CreateAccountResponse();
        if(retrievedAccount.getPassword() !=null && retrievedAccount.getPassword().equals(createAccountRequest.getPassword())){

            response.setResponseMsg("Account logged in");
        }else {
            response.setResponseMsg("UserName or Password is incorrect");
        }
        return Mono.just(response);

    }



}
