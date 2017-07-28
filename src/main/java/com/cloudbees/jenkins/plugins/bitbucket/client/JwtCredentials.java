package com.cloudbees.jenkins.plugins.bitbucket.client;

import com.cloudbees.plugins.credentials.CredentialsScope;
import com.cloudbees.plugins.credentials.common.StandardUsernamePasswordCredentials;
import com.cloudbees.plugins.credentials.impl.BaseStandardCredentials;
import hudson.util.Secret;

/**
 * @author Vivek Pandey
 */
public abstract class JwtCredentials extends BaseStandardCredentials implements StandardUsernamePasswordCredentials {
    public JwtCredentials(CredentialsScope scope, String id, String description) {
        super(scope, id, description);
    }

    public abstract String getAuthenticationHeaderScheme();

    public abstract String getTeamName();

    public abstract String getJwtToken();

    public abstract Secret clientKey();

    public abstract Secret sharedSecret();
}
