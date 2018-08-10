package com.anynines.app.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anynines.app.model.User;
import com.anynines.app.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

  public static final String TWITTER_URL = "https://twitter.com/";
  public static final String GRAVATAR_URL = "https://www.gravatar.com/avatar/";
  public static final String TRAINING_PROJECT_APPENDIX = "_training";

  @Autowired
  private UserRepository userRepository;
  
  @RequestMapping(method = RequestMethod.POST)
  public Map<String, Object> createUser(@RequestBody Map<String, Object> userMap){
    User user = new User(userMap.get("firstname").toString(), userMap.get("lastname").toString());

    Map<String, Object> response = new LinkedHashMap<>();
    response.put("message", "User created successfully");
    response.put("user", userRepository.save(user));
    return response;
  }

  @RequestMapping(method = RequestMethod.GET, value="/{userId}")
  public Optional<User> getUserDetails(@PathVariable("userId") String userId){
    return userRepository.findById(userId);
  }

  @RequestMapping(method = RequestMethod.PUT, value="/{userId}")
  public Map<String, Object> editUser(@PathVariable("userId") String userId, @RequestBody Map<String, Object> userMap){
    User user = new User(userMap.get("firstname").toString(), userMap.get("lastname").toString());
    user.setId(userId);

    Map<String, Object> response = new LinkedHashMap<>();
    response.put("message", "User Updated successfully");
    response.put("user", userRepository.save(user));
    return response;
  }

  @RequestMapping(method = RequestMethod.DELETE, value="/{userId}")
  public Map<String, String> deleteUser(@PathVariable("userId") String userId){
    userRepository.deleteById(userId);
    Map<String, String> response = new HashMap<>();
    response.put("message", "User deleted successfully");
    
    return response;
  }
  
  @RequestMapping(method = RequestMethod.GET)
  public Map<String, Object> getAllUsers(){
    List<User> users = userRepository.findAll();
    Map<String, Object> response = new LinkedHashMap<>();
    response.put("totalUsers", users.size());
    response.put("users", users);
    return response;
  }
}
