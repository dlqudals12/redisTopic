package server21.service;

import server21.dto.MessageModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisSubService implements MessageListener {

    public static List<String> messageList = new ArrayList<>();

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onMessage(Message message, byte[] pattern) {
        try {
            MessageModel messageModel = objectMapper.readValue(message.getBody(), MessageModel.class);
            messageList.add(message.toString());

            log.info("\n----------------------------------------------------------------------- \n" +
                    "From: " + messageModel.getSender() + "\n" +
                    "Server Name: Server21 \n" +
                    "Receive Msg: " + messageModel.getContext() + "\n" +
                    "----------------------------------------------------------------------- ");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
