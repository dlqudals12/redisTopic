package server12.service;

import server12.dto.MessageModel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RedisPubService {
    private final RedisTemplate<String, Object> redisTemplate;

    @Transactional
    public void sendMessage(MessageModel messageModel) {
        redisTemplate.convertAndSend("topic1", messageModel);
    }

}
