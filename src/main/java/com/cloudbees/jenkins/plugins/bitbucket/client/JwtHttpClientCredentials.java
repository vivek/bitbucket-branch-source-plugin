package com.cloudbees.jenkins.plugins.bitbucket.client;

import org.apache.commons.httpclient.Credentials;

import javax.annotation.Nonnull;

/**
 * JWT specific HttpClient Credentials implementation
 *
 * @author Vivek Pandey
 */
public class JwtHttpClientCredentials implements Credentials{
    private final String jwtToken;

    public JwtHttpClientCredentials(@Nonnull String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public @Nonnull String getJwtToken(){
        return jwtToken;
    }
}
