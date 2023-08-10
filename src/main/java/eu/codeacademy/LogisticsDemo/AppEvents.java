package eu.codeacademy.LogisticsDemo;

import eu.codeacademy.LogisticsDemo.entities.UserEntity;
import eu.codeacademy.LogisticsDemo.enumerators.Roles;
import eu.codeacademy.LogisticsDemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AppEvents {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @EventListener(ApplicationReadyEvent.class)
    public void startApp() {
        if (userRepository.findByUsername("sss") == null) {
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername("sss");
            userEntity.setPassword(passwordEncoder.encode("sss"));
            userEntity.setRole(Roles.ADMIN);
            userRepository.save(userEntity);
        }
    }
}
