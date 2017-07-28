package com.cloudbees.jenkins.plugins.bitbucket.client;

import org.apache.commons.httpclient.Credentials;

/**
 * @author Vivek Pandey
 */
public class JwtHttpClientCredentials implements Credentials{
    private final String scheme;
    private final String token;

    public JwtHttpClientCredentials(String scheme, String token) {
        this.scheme = scheme;
        this.token = token;
    }

    public String getScheme() {
        return scheme;
    }

    public String getToken() {
        return token;
    }

    public String getAuthorizationHeader(){
        return scheme+" "+token;
    }
}
