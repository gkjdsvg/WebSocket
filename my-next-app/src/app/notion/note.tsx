'use client';
import React, { useEffect, useState } from 'react';
import { usePathname, useRouter } from 'next/navigation';

const Home = () => {
  const pathname = usePathname();
  const router = useRouter();
  const [showNoteCreate, setShowNoteCreate] = useState(false);

  useEffect(() => {
    if (pathname === '/note/create') {
      setShowNoteCreate(true);
    }
  }, [pathname]);

  const closeModal = () => {
    router.push('/note');
    setShowNoteCreate(false);
  };

  const saveNote = () => {
    fetch("http://localhost:8089/note/create", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ title: "User", content: "This is a note." }),
    });
    closeModal();
  };

  return (
      <div className="bg-gray-100 h-screen flex">
        {/* 사이드바 */}
        <div className="w-64 bg-white p-4 shadow-md">
          <h2 className="text-lg font-bold mb-4">My Notion</h2>
          <ul>
            <li className="py-2 px-3 hover:bg-gray-200 rounded cursor-pointer">
              <a href="/home" className="block w-full h-full">Home</a>
            </li>
            <li className="py-2 px-3 hover:bg-gray-200 rounded cursor-pointer relative">
              <a href="/note" className="block w-full h-full">Notes</a>
              <button
                  onClick={() => router.push('/note/create')}
                  className="absolute top-1 right-1 bg-blue-500 text-white p-1 rounded-full"
              >
                +
              </button>
            </li>
            <li className="py-2 px-3 hover:bg-gray-200 rounded cursor-pointer relative">
              <a href="/task" className="block w-full h-full">Tasks</a>
              <button
                  className="absolute top-1 right-1 bg-blue-500 text-white p-1 rounded-full"
                  onClick={() => alert("할 일 추가 구현 필요")}
              >
                +
              </button>
            </li>
          </ul>
        </div>

        {/* 메인 콘텐츠 */}
        <div className="flex-1 p-6 overflow-y-auto">
          <h1 className="text-2xl font-bold mb-4">📌 노트 목록</h1>
          <div className="p-4 bg-white rounded shadow-md" id="noteSection">
            <ul id="noteContainer" className="mt-2 space-y-2">
              {/* 노트 아이템 예시 */}
              <li className="p-3 bg-gray-100 rounded">✏️ 여기에 노트가 표시될 예정입니다.</li>
            </ul>
          </div>
        </div>

        {/* 노트 작성 모달 */}
        {showNoteCreate && (
            <div className="fixed inset-0 bg-gray-900 bg-opacity-50 flex justify-center items-center z-50">
              <div className="bg-white p-6 rounded shadow-lg w-1/2">
                <h2 className="text-lg font-semibold mb-4">📝 새 노트 작성</h2>
                <textarea
                    className="w-full p-2 border rounded h-40"
                    placeholder="새로운 노트를 작성하세요..."
                ></textarea>
                <div className="mt-4 flex justify-end">
                  <button
                      onClick={saveNote}
                      className="px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-600"
                  >
                    저장
                  </button>
                  <button
                      onClick={closeModal}
                      className="ml-2 px-4 py-2 bg-gray-300 rounded hover:bg-gray-400"
                  >
                    취소
                  </button>
                </div>
              </div>
            </div>
        )}
      </div>
  );
};

export default Home;
