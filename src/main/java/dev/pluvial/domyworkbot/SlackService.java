package dev.pluvial.domyworkbot;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Log4j2
public class SlackService {

    private final MethodsClient methods;

    public SlackService() {
        Slack slack = Slack.getInstance();
        String token = System.getenv("SLACK_TOKEN");
        methods = slack.methods(token);
    }

    public void chatPostMessage(String channel, String message){
        log.info("post message to chat");
        try {
        ChatPostMessageRequest request = ChatPostMessageRequest.builder()
            .channel(channel)
            .text(message)
            .build();
            ChatPostMessageResponse response = methods.chatPostMessage(request);
        } catch (IOException | SlackApiException e) {
            log.error("Error during post message to chat", e);
        }
    }
}
