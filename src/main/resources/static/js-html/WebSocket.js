const socket = new SockJS("http://localhost:8080/ws"); // 서버의 WebSocket 엔드포인트
const stompClient = Stomp.over(socket);

stompClient.connect({}, () => {
    console.log("WebSocket 연결됨!");

    // 메시지 구독
    stompClient.subscribe("/topic/messages", (message) => {
        console.log("받은 메시지:", JSON.parse(message.body));
    });

    // 메시지 보내기
    stompClient.send("/app/chat", {}, JSON.stringify("Hello, Server!"));
});

stompClient.connect(
    { Authorization: "Bearer YOUR_JWT_TOKEN" },
    () => {
        console.log("Connected!");
    },
    (error) => {
        console.error("Connection Error: ", error);
    }
);