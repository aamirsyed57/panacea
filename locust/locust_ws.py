from locust import User, task, between
import websocket
import threading
import time

class WebSocketUser(User):
    wait_time = between(1, 3)

    def on_start(self):
        self.ws = websocket.WebSocketApp(
            "ws://localhost:8080/ws",  # Replace with your WebSocket URL
            on_message=self.on_message,
            on_error=self.on_error,
            on_close=self.on_close
        )
        self.thread = threading.Thread(target=self.ws.run_forever)
        self.thread.daemon = True
        self.thread.start()
        time.sleep(1)

    def on_stop(self):
        self.ws.close()

    def on_message(self, ws, message):
        print(f"Received: {message}")

    def on_error(self, ws, error):
        print(f"Error: {error}")

    def on_close(self, ws, close_status_code, close_msg):
        print("Connection closed")

    @task
    def send_message(self):
        self.ws.send("Hello WebSocket!")