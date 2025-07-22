from locust import HttpUser, task, between

class MySpringBootUser(HttpUser):
    wait_time = between(1, 3)

    @task
    def get_hello(self):
        self.client.get("/hello")

    @task
    def post_user(self):
        self.client.post("/users", json={"id": "123", "name": "Alice"})