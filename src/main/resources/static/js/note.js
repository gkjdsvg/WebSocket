// 노트 추가 버튼 표시
function showAddButton(id) {
    document.getElementById(id).classList.remove("hidden");
}

// 노트 추가 버튼 숨기기
function hideAddButton(id) {
    document.getElementById(id).classList.add("hidden");
}

// 노트 작성 입력창 표시
function showNoteInput() {
    document.getElementById("noteInputSection").classList.remove("hidden");
}

// 노트 추가 기능
function addNote() {
    let noteInput = document.getElementById("noteInput");
    let noteContainer = document.getElementById("noteContainer");
    let noteText = noteInput.value.trim();

    if (noteText === "") return;

    let li = document.createElement("li");
    li.className = "p-4 bg-white rounded shadow flex justify-between items-center cursor-pointer";
    li.onclick = function () {
        document.getElementById("commentSection").classList.remove("hidden");
    };

    let span = document.createElement("span");
    span.textContent = noteText;
    span.className = "flex-1 text-gray-800";

    let menuBtn = document.createElement("button");
    menuBtn.textContent = "⋮";
    menuBtn.className = "text-gray-500 ml-2 hover:text-gray-700";
    menuBtn.onclick = function (event) {
        event.stopPropagation();
        let newText = prompt("수정할 내용을 입력하세요", span.textContent);
        if (newText !== null && newText.trim() !== "") {
            span.textContent = newText;
        }
    };

    let deleteBtn = document.createElement("button");
    deleteBtn.textContent = "✕";
    deleteBtn.className = "text-red-500 ml-2 hover:text-red-700";
    deleteBtn.onclick = function (event) {
        event.stopPropagation();
        noteContainer.removeChild(li);
    };

    li.appendChild(span);
    li.appendChild(menuBtn);
    li.appendChild(deleteBtn);
    noteContainer.appendChild(li);

    noteInput.value = "";
    document.getElementById("noteInputSection").classList.add("hidden");
}

function handleCommentInput(event) {
    let commentInput = document.getElementById("commentInput");
    if (event.key === "Enter" && commentInput.value.trim() !== "") {
        addComment(commentInput.value);
        commentInput.value = "";
    }
}

function addComment(commentText) {
    let commentsContainer = document.getElementById("commentsContainer");
    let li = document.createElement("li");
    li.className = "p-4 bg-gray-200 rounded-lg shadow flex justify-between items-center";

    let span = document.createElement("span");
    span.textContent = commentText;
    span.className = "flex-1 cursor-pointer text-gray-800";

    let deleteBtn = document.createElement("button");
    deleteBtn.textContent = "✕";
    deleteBtn.className = "text-red-500 ml-2 hover:text-red-700";
    deleteBtn.onclick = function () {
        commentsContainer.removeChild(li);
    };

    li.appendChild(span);
    li.appendChild(deleteBtn);
    commentsContainer.appendChild(li);
}