package com.login.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.login.datatransferobject.LoginDTO;

@FeignClient(name = "playstation")
public interface UserClient {

    @GetMapping("/api/username/{username}")
    LoginDTO getUserByUsername(@PathVariable("username") String username);
}

