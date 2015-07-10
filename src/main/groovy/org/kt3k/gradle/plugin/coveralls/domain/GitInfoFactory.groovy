package org.kt3k.gradle.plugin.coveralls.domain

/**
 * ServiceInfoFactory is factory class of ServiceInfo.
 */
class GitInfoFactory {

    /**
     * Create ServiceInfo instance from environmental variables.
     *
     * @param env environmental variables
     * @return service information of current environment
     */
    public static GitInfo createFromEnvVar(Map<String, String> env) {
        if (repoTokenIsSet(env)) {
            GitInfo.Head head = new GitInfo.Head(
                    env['COVERALLS_GIT_ID'],
                    env['COVERALLS_GIT_MESSAGE'],
                    env['COVERALLS_GIT_AUTHOR_NAME'],
                    env['COVERALLS_GIT_AUTHOR_EMAIL'],
                    env['COVERALLS_GIT_COMMITTER_NAME'],
                    env['COVERALLS_GIT_COMMITTER_EMAIL']
            )
            return new GitInfo(env['COVERALLS_GIT_REMOTE'], env['COVERALLS_CI_BRANCH'], head)
        }

        // cannot create service info from environmental variables. (no repo_token)
        return null
    }

    private static boolean repoTokenIsSet(Map<String, String> env) {
        env.get('COVERALLS_REPO_TOKEN') != null
    }
}
