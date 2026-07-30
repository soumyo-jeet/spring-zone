package in.soumyo.CRUDSpringBoot.service;


import in.soumyo.CRUDSpringBoot.AuthUtil;
import in.soumyo.CRUDSpringBoot.StudentEntity;
import in.soumyo.CRUDSpringBoot.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private AuthenticationManager authenticationManager;
    private AuthUtil authUtil;


    public AuthService(AuthenticationManager authenticationManager,
                       AuthUtil authUtil
    ) {
        this.authenticationManager = authenticationManager;
        this.authUtil = authUtil;
    }

    public String login (String name, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(name, password)
        );

        StudentEntity student = (StudentEntity) authentication.getPrincipal();

        String token = authUtil.generateAccessToken(student);

        return token;
    }

}
