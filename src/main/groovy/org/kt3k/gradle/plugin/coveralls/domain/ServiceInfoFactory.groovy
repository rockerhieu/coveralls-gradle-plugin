package org.kt3k.gradle.plugin.coveralls.domain

/**
 * ServiceInfoFactory is factory class of ServiceInfo.
 */
class ServiceInfoFactory {

    /**
     * Create ServiceInfo instance from environmental variables.
     *
     * @param env environmental variables
     * @return service information of current environment
     */
    public static ServiceInfo createFromEnvVar(Map<String, String> env) {

        if (repoTokenIsSet(env)) {
            return new ServiceInfo(
                    env['COVERALLS_CI_NAME'] ?: 'other',
                    env['COVERALLS_CI_BUILD_NUMBER'],
                    env['COVERALLS_CI_BUILD_URL'],
                    env['COVERALLS_CI_BRANCH'],
                    env['COVERALLS_CI_PULL_REQUEST'],
                    env['COVERALLS_REPO_TOKEN']
            )
        }

        // cannot create service info from environmental variables. (no repo_token, not travis)
        return null

    }

    private static boolean repoTokenIsSet(Map<String, String> env) {
        env.get('COVERALLS_REPO_TOKEN') != null
    }

}
