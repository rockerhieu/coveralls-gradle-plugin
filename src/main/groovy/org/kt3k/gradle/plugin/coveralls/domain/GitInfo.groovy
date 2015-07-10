package org.kt3k.gradle.plugin.coveralls.domain

/**
 * @author rockerhieu on 7/9/15.
 */
class GitInfo {
    final List<String> remotes;
    final String branch;
    final Head head;

    GitInfo(String remote, String branch, Head head) {
        this.remotes = new ArrayList<>(1)
        this.remotes.add(remote)
        this.branch = branch
        this.head = head
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        GitInfo gitInfo = (GitInfo) o

        if (branch != gitInfo.branch) return false
        if (head != gitInfo.head) return false
        if (remotes != gitInfo.remotes) return false

        return true
    }

    int hashCode() {
        int result
        result = (remotes != null ? remotes.hashCode() : 0)
        result = 31 * result + (branch != null ? branch.hashCode() : 0)
        result = 31 * result + (head != null ? head.hashCode() : 0)
        return result
    }

    static class Head {
        final String id;
        final String message;
        final String author_name;
        final String author_email;
        final String committer_name;
        final String committer_email;

        Head(String id, String message, String author_name, String author_email, String committer_name, String committer_email) {
            this.id = id
            this.message = message
            this.author_name = author_name
            this.author_email = author_email
            this.committer_name = committer_name
            this.committer_email = committer_email
        }

        boolean equals(o) {
            if (this.is(o)) return true
            if (getClass() != o.class) return false

            Head head = (Head) o

            if (author_email != head.author_email) return false
            if (author_name != head.author_name) return false
            if (committer_email != head.committer_email) return false
            if (committer_name != head.committer_name) return false
            if (id != head.id) return false
            if (message != head.message) return false

            return true
        }

        int hashCode() {
            int result
            result = (id != null ? id.hashCode() : 0)
            result = 31 * result + (message != null ? message.hashCode() : 0)
            result = 31 * result + (author_name != null ? author_name.hashCode() : 0)
            result = 31 * result + (author_email != null ? author_email.hashCode() : 0)
            result = 31 * result + (committer_name != null ? committer_name.hashCode() : 0)
            result = 31 * result + (committer_email != null ? committer_email.hashCode() : 0)
            return result
        }
    }
}
