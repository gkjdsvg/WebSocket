"use client";
import { useState } from "react";

export default function Home() {
    const [taskInputVisible, setTaskInputVisible] = useState(false);
    const [taskText, setTaskText] = useState("");
    const [tasks, setTasks] = useState<string[]>([]);
    const [hoveredButton, setHoveredButton] = useState<string | null>(null);

    const addTask = () => {
        if (taskText.trim() === "") return;
        setTasks([...tasks, taskText.trim()]);
        setTaskText("");
        setTaskInputVisible(false);
    };

    const updateTask = (index: number) => {
        const newText = prompt("수정할 내용을 입력하세요", tasks[index]);
        if (newText !== null && newText.trim() !== "") {
            const newTasks = [...tasks];
            newTasks[index] = newText.trim();
            setTasks(newTasks);
        }
    };

    const deleteTask = (index: number) => {
        const newTasks = [...tasks];
        newTasks.splice(index, 1);
        setTasks(newTasks);
    };

    return (
        <div className="flex h-screen bg-gray-100">
            {/* 사이드바 */}
            <div className="w-64 bg-white p-4 shadow-md">
                <h2 className="text-lg font-bold mb-4">My Notion</h2>
                <ul>
                    <li className="py-2 px-3 hover:bg-gray-200 rounded cursor-pointer">
                        <a href="/home" className="block w-full h-full">Home</a>
                    </li>
                    <li
                        className="py-2 px-3 hover:bg-gray-200 rounded cursor-pointer relative"
                        onMouseEnter={() => setHoveredButton("note")}
                        onMouseLeave={() => setHoveredButton(null)}
                    >
                        <a href="/note" className="block w-full h-full">Notes</a>
                        {hoveredButton === "note" && (
                            <button
                                className="absolute top-1 right-1 bg-blue-500 text-white p-1 rounded-full"
                                onClick={() => alert("Note 추가")}
                            >+</button>
                        )}
                    </li>
                    <li
                        className="py-2 px-3 hover:bg-gray-200 rounded cursor-pointer relative"
                        onMouseEnter={() => setHoveredButton("task")}
                        onMouseLeave={() => setHoveredButton(null)}
                    >
                        <a href="/task" className="block w-full h-full">Tasks</a>
                        {hoveredButton === "task" && (
                            <button
                                className="absolute top-1 right-1 bg-blue-500 text-white p-1 rounded-full"
                                onClick={() => setTaskInputVisible(true)}
                            >+</button>
                        )}
                    </li>
                </ul>
            </div>

            {/* 메인 콘텐츠 */}
            <div className="flex-1 p-6">
                <h1 className="text-2xl font-bold mb-4">Notion 클론에 오신 것을 환영합니다</h1>

                {/* 태스크 목록 */}
                <div className="p-4 bg-white rounded shadow-md">
                    <h2 className="text-lg font-semibold">📌 태스크 목록</h2>
                    <ul className="mt-2 space-y-2">
                        {tasks.map((task, index) => (
                            <li
                                key={index}
                                className="p-4 bg-white rounded shadow flex justify-between items-center cursor-pointer"
                            >
                                <span className="flex-1 text-gray-800">{task}</span>
                                <button
                                    className="text-gray-500 ml-2 hover:text-gray-700"
                                    onClick={(e) => {
                                        e.stopPropagation();
                                        updateTask(index);
                                    }}
                                >⋮</button>
                                <button
                                    className="text-red-500 ml-2 hover:text-red-700"
                                    onClick={(e) => {
                                        e.stopPropagation();
                                        deleteTask(index);
                                    }}
                                >✕</button>
                            </li>
                        ))}
                    </ul>
                </div>

                {/* 태스크 작성 섹션 */}
                {taskInputVisible && (
                    <div className="p-4 bg-white rounded shadow-md mt-6">
                        <h2 className="text-lg font-semibold">📝 새 태스크 작성</h2>
                        <textarea
                            className="w-full p-2 border rounded mt-2"
                            placeholder="새로운 태스크를 작성하세요..."
                            value={taskText}
                            onChange={(e) => setTaskText(e.target.value)}
                        />
                        <button
                            onClick={addTask}
                            className="mt-2 px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-600"
                        >
                            작성
                        </button>
                    </div>
                )}
            </div>
        </div>
    );
}
