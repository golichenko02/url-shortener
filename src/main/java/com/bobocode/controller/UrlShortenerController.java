package com.bobocode.controller;

import com.bobocode.dto.OriginalUrlDto;
import com.bobocode.service.UrlShortenerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class UrlShortenerController {
    private final UrlShortenerService urlShortenerService;

    @PostMapping("/shortenUrl")
    public ResponseEntity<String> shortUrl(@RequestBody OriginalUrlDto originalUrlDto) {
        URI shortenedUrl = urlShortenerService.shortenUrl(originalUrlDto.originalUrl());
        return ResponseEntity.created(shortenedUrl).build();
    }

    @GetMapping("/{shortenedUrl}")
    public ResponseEntity<?> redirectByShortenUrl(@PathVariable String shortenedUrl) {
        return ResponseEntity
                .status(HttpStatus.MOVED_PERMANENTLY)
                .location(urlShortenerService.getOriginalUrl(shortenedUrl))
                .build();
    }

    @ExceptionHandler
    public ResponseEntity<?> handleClientException(HttpClientErrorException exception) {
        return ResponseEntity.status(exception.getStatusCode()).body(exception.getMessage());
    }
}
