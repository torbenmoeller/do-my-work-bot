package dev.pluvial.domyworkbot;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SlackService {

    private final MethodsClient methods;

    public SlackService() {
        Slack slack = Slack.getInstance();
        String token = System.getenv("SLACK_TOKEN");
        methods = slack.methods(token);
    }

    public void chatPostMessage(String channel, String message){
        try {
        ChatPostMessageRequest request = ChatPostMessageRequest.builder()
            .channel(channel)
            .text(message)
            .build();
            ChatPostMessageResponse response = methods.chatPostMessage(request);
        } catch (IOException | SlackApiException e) {
            throw new RuntimeException(e);
        }
    }
}
