package com.hanghae.cinema;

import jakarta.persistence.Embeddable;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

@Embeddable
public class UrlString {
    private String url;

    protected UrlString() {}

    public UrlString(final String url) {
        validate(url);
        this.url = url;
    }

    private void validate(final String url) {
        try {
            new URL(url);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("url 형식이 이상합니다", e);
        }
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UrlString urlString = (UrlString) o;
        return Objects.equals(url, urlString.url);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(url);
    }
}
