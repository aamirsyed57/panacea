# 🚀 Load Testing with Locust

This project demonstrates how to perform load testing using [Locust](https://locust.io/) for both:

- REST APIs (e.g., Spring Boot endpoints)
- WebSocket-based services

---

## 📦 Prerequisites

- Python 3.8+
- pip

### Install dependencies:

```bash
pip install -r requirements.txt
```

### 📂 Project Structure

```
.
├── locust_http.py     # Load test for REST API
├── locust_ws.py       # Load test for WebSocket
├── requirements.txt   # pip dependecies
├── README.md          # You're here

```


## 🧪 Load Testing HTTP Endpoints
Sample: locust_http.py

### Run with UI
```
locust -f locust_http.py
```
Open http://localhost:8089 and enter:
- Host: http://localhost:8080
- Users: 100
- Spawn rate: 10

### Headless Mode
```
locust -f locust_http.py --headless -u 100 -r 10 -t 1m --host http://localhost:8080 --csv=report
```

## 🌐 Load Testing WebSocket Endpoints
Sample: locust_ws.py

### Run WebSocket Test
```
locust -f locust_ws.py --headless -u 10 -r 2 -t 30s
```
Note: WebSocket performance metrics are not tracked automatically by Locust. You can add custom metrics using request_success and request_failure events.

## 📈 Exporting Reports
```
locust -f locust_http.py --headless -u 100 -r 10 -t 1m --host http://localhost:8080 --csv=results
```
This will generate:
- results_stats.csv
- results_failures.csv

## ✅ Tips
- Use @task(weight=n) to prioritize tasks.
- You can simulate authentication by adding a login() step in on_start.
- Combine multiple user types to simulate real-world traffic patterns.

## 📚 References
- https://docs.locust.io
- https://pypi.org/project/websocket-client