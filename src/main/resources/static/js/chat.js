stompClient.subscribe('/topic/chat', (response) => {
    console.log("받은 메시지:", response.body);
});

stompClient.debug = console.log;
