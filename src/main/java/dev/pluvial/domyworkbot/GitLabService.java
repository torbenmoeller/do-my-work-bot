package dev.pluvial.domyworkbot;

import org.gitlab4j.api.GitLabApi;
import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.models.Project;

import java.util.List;

public class GitLabService {

    private final GitLabApi gitLabApi;

    public GitLabService() {
        String gitlabUrl = "http://your.gitlab.server.com";
        String personalAccessToken = "YOUR_PERSONAL_ACCESS_TOKEN";
        gitLabApi = new GitLabApi(gitlabUrl, personalAccessToken);
    }

    public void acceptMergeRequest(){

    }

    public List<Project> getProjects() {
        try {
            return gitLabApi.getProjectApi().getProjects();
        } catch (GitLabApiException e) {
            throw new RuntimeException(e);
        }
    }
}
