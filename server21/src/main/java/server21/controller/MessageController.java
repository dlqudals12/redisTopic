package server21.controller;

import server21.dto.MessageModel;
import server21.dto.ResponseDefault;
import server21.service.RedisPubService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/api/redis_message")
public class MessageController {

    private final RedisPubService redisPubService;

    @PostMapping(value = "/post")
    public ResponseDefault postMsg(@RequestBody MessageModel messageModel) {
        messageModel.setSender("MainServer");

        redisPubService.sendMessage(messageModel);

        return new ResponseDefault();
    }
}
