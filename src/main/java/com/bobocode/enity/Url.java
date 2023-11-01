package com.bobocode.enity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@AllArgsConstructor
@Getter
@RedisHash("urls")
public class Url {

    @Id
    private String shortenedUrl;

    private String originalUrl;
}
