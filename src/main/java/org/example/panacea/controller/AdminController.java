package org.example.panacea.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class AdminController {

    @GetMapping("/websocket")
    @Operation(summary = "How to use the WebSocket API")
    public Map<String, String> websocketInfo() {
        Map<String, String> doc = new LinkedHashMap<>();
        doc.put("WebSocket Endpoint", "/ws-game");
        doc.put("Send to (STOMP)", "/app/game.send/{roomId}");
        doc.put("Subscribe to", "/topic/room/{roomId}");
        doc.put("Message Format", "{ \"type\": \"move\", \"player\": \"Alice\", \"roomId\": \"123\", \"move\": \"left\" }");
        return doc;
    }


}
