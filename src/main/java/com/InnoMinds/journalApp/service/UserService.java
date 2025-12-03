package com.InnoMinds.journalApp.service;

import com.InnoMinds.journalApp.entity.User;
import com.InnoMinds.journalApp.repo.UserRepo;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean saveNewUser(User user) {
        try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userRepo.save(user);
            return true;
        } catch (Exception e) {
            log.info("Hello guys i just checked logging");
          log.warn("HAHAAHAHAHAHAHAHA");
        //  log.error("Error occured for {} : ",user.getUserName(), e);
          log.debug("HAHAHAHAHAHAHAHAH");
          log.trace("HAHAHAHAHHAHAHAH");
          return false;
        }

    }

    public void saveAdmin(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER","ADMIN"));
        userRepo.save(user);
    }

    public void saveAdmin(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER","ADMIN"));
        userRepo.save(user);
    }

    public void saveUser(User user){
        userRepo.save(user);
    }
    public Optional<User> getById(ObjectId id) {
        return userRepo.findById(id);
    }



    public  void deleteUser(User user){
        userRepo.delete(user);
    }
   public User findByUserName(String username){
        return userRepo.findByUserName(username);
    }

    public List<User> getAll() {
        return userRepo.findAll();
    }
}
