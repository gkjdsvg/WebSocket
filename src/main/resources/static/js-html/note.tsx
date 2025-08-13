fetch("http://localhost:8089/note/create", {
    method: "POST",
    headers: {
        "Content-Type": "application/json"
    },
    body: JSON.stringify({
        username: "User",
        content: "This is a note."
    })
});