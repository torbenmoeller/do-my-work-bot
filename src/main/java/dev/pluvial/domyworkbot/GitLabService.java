package dev.pluvial.domyworkbot;

import lombok.extern.log4j.Log4j2;
import org.gitlab4j.api.GitLabApi;
import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.models.Project;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
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
        log.info("Get projects from GitLab");
        try {
            return gitLabApi.getProjectApi().getProjects();
        } catch (GitLabApiException e) {
            log.info("Error during get projects from GitLab", e);
        }
        return new ArrayList<>();
    }

}
