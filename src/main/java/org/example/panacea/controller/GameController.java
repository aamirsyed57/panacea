package org.example.panacea.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.example.panacea.dto.GameMessage;
import org.example.panacea.dto.RoomInput;
import org.example.panacea.entity.Room;
import org.example.panacea.pubsub.MessagePublisher;
import org.example.panacea.service.GameRoomService;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@RestController
public class GameController {

    private final SimpMessagingTemplate messagingTemplate;
    private final MessagePublisher publisher;

    private final Map<String, List<String>> roomPlayers = new HashMap<>();
    private final GameRoomService gameRoomService;
    private int page;
    private int size;

    public GameController(SimpMessagingTemplate messagingTemplate, MessagePublisher publisher, GameRoomService gameRoomService) {
        this.messagingTemplate = messagingTemplate;
        this.publisher = publisher;
        this.gameRoomService = gameRoomService;
    }

    @PostMapping("/room")
    @Operation(summary = "Join a game room")
    public Room createRoom(@RequestBody RoomInput roomInput, @RequestHeader("X-User-Id") String userId) {
        //roomPlayers.computeIfAbsent(roomId, k -> new ArrayList<>()).add(player);
        return gameRoomService.createRoom(roomInput.name, userId);
    }


    @PostMapping("/join")
    @Operation(summary = "Create a room for a game")
    public String joinRoom(@RequestParam String roomId, @RequestParam String player) {
        roomPlayers.computeIfAbsent(roomId, k -> new ArrayList<>()).add(player);
        return player + " joined " + roomId;
    }

    @GetMapping(value = "/rooms")
    @Operation(summary = "Get all game rooms")
    public List<Room> listRooms(@RequestParam(required = false) Optional<Integer> page, @RequestParam(required = false) Optional<Integer> size) {
        return gameRoomService.getAllRooms();
        //return roomPlayers.keySet();
    }

    @GetMapping("/room/{roomId}/players")
    @Operation(summary = "List players in a room")
    public List<String> listPlayers(@PathVariable String roomId) {
        return roomPlayers.getOrDefault(roomId, List.of());
    }

    @MessageMapping("/game.send/{roomId}") // listens to /app/game.send
    @Operation(summary = "WebSocket connection instructions")
    public void sendGameMove(@RequestBody GameMessage message, @DestinationVariable("roomId") String roomId) {
        String roomTopic = "/topic/room/" + roomId;
        log.info("Received message for Room {}", roomId);
        messagingTemplate.convertAndSend(roomTopic, message);
    }

    @PostMapping("/publish")
    @Operation(summary = "publish a message to pub sub")
    public void publishMessage(@RequestParam String message) {
        publisher.publish(message);
    }
}