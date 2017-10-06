package com.cloudbees.jenkins.plugins.bitbucket.client;

import com.cloudbees.plugins.credentials.CredentialsScope;
import com.cloudbees.plugins.credentials.common.StandardUsernamePasswordCredentials;
import com.cloudbees.plugins.credentials.impl.BaseStandardCredentials;
import hudson.util.Secret;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * Bitbucket Cloud JWT Credentials.
 *
 * Reference document: https://developer.atlassian.com/cloud/bitbucket/authentication-for-apps/
 *
 * @author Vivek Pandey
 */
public abstract class BitbucketConnectJwtCredentials extends BaseStandardCredentials
        implements StandardUsernamePasswordCredentials {
    /**
     * Constructor
     *
     * @param scope scope of credentials
     * @param id credentials id
     * @param description description
     */
    public BitbucketConnectJwtCredentials(@CheckForNull CredentialsScope scope, @CheckForNull String id,
                                          @CheckForNull String description) {
        super(scope, id, description);
    }

    /**
     * Bitbucket team name.
     *
     * @return team name
     */
    public abstract @Nonnull String getTeamName();

    /**
     * JWT token.
     *
     * @return jwt token
     */
    public abstract @Nonnull String getJwtToken();

    /**
     * Bitbucket Connect client key.
     *
     * @return client key
     */
    public abstract @Nonnull Secret clientKey();

    /**
     * Bitbucket Connect shared secret.
     *
     * @return shared secret
     */
    public abstract @Nonnull Secret sharedSecret();
}
