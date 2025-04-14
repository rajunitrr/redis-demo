package com.bt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bt.service.RedisService;

@RestController
@RequestMapping("/redis2")
public class RedisController2 {

	private final RedisService redisService;

    public RedisController2(RedisService redisService) {
        this.redisService = redisService;
    }

    @GetMapping("/set")
    public ResponseEntity<String> set(@RequestParam String key, @RequestParam String value) {
        redisService.setValue(key, value);
        return ResponseEntity.ok("Set key: " + key);
    }

    @GetMapping("/get")
    public ResponseEntity<String> get(@RequestParam String key) {
        String value = redisService.getValue(key);
        return ResponseEntity.ok("Value: " + value);
    }
}
