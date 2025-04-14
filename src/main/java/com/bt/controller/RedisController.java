package com.bt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.redis.core.ValueOperations;

@RestController
public class RedisController {

    @Autowired
    private ValueOperations<String, String> valueOps;

    @GetMapping("/set")
    public String setKey(@RequestParam String key, @RequestParam String value) {
        valueOps.set(key, value);
        return "Set key: " + key + " with value: " + value;
    }

    @GetMapping("/get")
    public String getKey(@RequestParam String key) {
        return valueOps.get(key);
    }

    @GetMapping("/delete")
    public String deleteKey(@RequestParam String key) {
        Boolean deleted = valueOps.getOperations().delete(key);
        return deleted ? "Deleted key: " + key : "Key not found!";
    }
}
