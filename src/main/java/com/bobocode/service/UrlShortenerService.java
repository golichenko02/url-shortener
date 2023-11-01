package com.bobocode.service;

import com.bobocode.enity.Url;
import com.bobocode.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class UrlShortenerService {
    private final UrlRepository urlRepository;

    public URI shortenUrl(String originalUrl) {
        String randomString = RandomStringUtils.random(7);
        String shortenedUrl = Base64.getUrlEncoder().encodeToString(randomString.getBytes());
        Url savedUrl = urlRepository.save(new Url(shortenedUrl, originalUrl));
        return createFullShortenedUrl(savedUrl.getShortenedUrl());
    }

    public URI getOriginalUrl(String shortenedUrl) {
        return urlRepository.findById(shortenedUrl)
                .map(Url::getOriginalUrl)
                .map(URI::create)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Not found original url by: " + shortenedUrl));
    }

    private URI createFullShortenedUrl(String shortenedUrl) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .replacePath(shortenedUrl)
                .build()
                .toUri();
    }

}
