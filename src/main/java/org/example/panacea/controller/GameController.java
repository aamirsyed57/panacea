package org.example.panacea.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.example.panacea.model.GameMessage;
import org.example.panacea.pubsub.MessagePublisher;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class GameController {

    private final SimpMessagingTemplate messagingTemplate;
    private final MessagePublisher publisher;

    private final Map<String, List<String>> roomPlayers = new HashMap<>();

    public GameController(SimpMessagingTemplate messagingTemplate, MessagePublisher publisher) {
        this.messagingTemplate = messagingTemplate;
        this.publisher = publisher;
    }


    @PostMapping("/join")
    @Operation(summary = "Join a game room")
    public String joinRoom(@RequestParam String roomId, @RequestParam String player) {
        roomPlayers.computeIfAbsent(roomId, k -> new ArrayList<>()).add(player);
        return player + " joined " + roomId;
    }

    @GetMapping("/rooms")
    @Operation(summary = "Get all game rooms")
    public Set<String> listRooms() {
        return roomPlayers.keySet();
    }

    @GetMapping("/room/{roomId}/players")
    @Operation(summary = "List players in a room")
    public List<String> listPlayers(@PathVariable String roomId) {
        return roomPlayers.getOrDefault(roomId, List.of());
    }

    @MessageMapping("/game.send") // listens to /app/game.send
    @Operation(summary = "WebSocket connection instructions")
    public void sendGameMove(GameMessage message) {
        String roomTopic = "/topic/room/" + message.getRoomId();
        messagingTemplate.convertAndSend(roomTopic, message);
    }

    @PostMapping("/publish")
    @Operation(summary = "publish a message to pub sub")
    public void publishMessage(@RequestParam String message) {
        publisher.publish(message);
    }
}