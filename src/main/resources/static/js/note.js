
fetch('localhost:8089/note/create',
    {
        method: "POST",
        headers {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({"content": "집에 보내줘","username":"User"})
    }).then(response => {
        if (response.ok) {
            window.location.href = "/note";
    }else {
            alert("노트 생성 실패");
        }
});