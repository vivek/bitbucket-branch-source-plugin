package com.cloudbees.jenkins.plugins.bitbucket.client;

import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.auth.AuthenticationException;
import org.apache.commons.httpclient.auth.RFC2617Scheme;

/**
 * JWT HTTP authentication scheme.
 *
 * Bitbucket Connect specific JWT authentication based scheme.
 *
 * @author Vivek Pandey
 */
public class BitbucketConnectJwtAuthScheme extends RFC2617Scheme {
    public static final String scheme="jwt";
    private boolean complete;

    public BitbucketConnectJwtAuthScheme() {
        super();
        this.complete = false;
    }

    @Override
    public String getSchemeName() {
        return scheme;
    }

    @Override
    public boolean isConnectionBased() {
        return false;
    }

    @Override
    public boolean isComplete() {
        return complete;
    }

    @Override
    public String authenticate(Credentials credentials, String method, String uri) throws AuthenticationException {
        return auth(credentials);
    }

    @Override
    public String authenticate(Credentials credentials, HttpMethod method) throws AuthenticationException {
        return auth(credentials);
    }

    private String auth(Credentials credentials){
        if(!(credentials instanceof JwtHttpClientCredentials)){
            throw new IllegalArgumentException("Must be JwtCredentials instance");
        }
        return  "JWT " + ((JwtHttpClientCredentials) credentials).getJwtToken();
    }
}
