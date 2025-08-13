'use client';
import React, { useState } from 'react';

const Home = () => {
  const [notes, setNotes] = useState<string[]>([]);
  const [selectedNoteIndex, setSelectedNoteIndex] = useState<number | null>(null);
  const [newNote, setNewNote] = useState('');
  const [comments, setComments] = useState<string[]>([]);
  const [newComment, setNewComment] = useState('');
  const [hovered, setHovered] = useState<{ note: boolean; task: boolean }>({ note: false, task: false });

  const addNote = () => {
    if (newNote.trim() === '') return;
    setNotes([...notes, newNote.trim()]);
    setNewNote('');
  };

  const updateNote = (index: number) => {
    const updated = prompt('수정할 내용을 입력하세요', notes[index]);
    if (updated && updated.trim() !== '') {
      const updatedNotes = [...notes];
      updatedNotes[index] = updated.trim();
      setNotes(updatedNotes);
    }
  };

  const deleteNote = (index: number) => {
    const updatedNotes = [...notes];
    updatedNotes.splice(index, 1);
    setNotes(updatedNotes);
    setSelectedNoteIndex(null);
    setComments([]);
  };

  const addComment = () => {
    if (newComment.trim() === '') return;
    setComments([...comments, newComment.trim()]);
    setNewComment('');
  };

  const deleteComment = (index: number) => {
    const updated = [...comments];
    updated.splice(index, 1);
    setComments(updated);
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

            {/* Notes */}
            <li
                className="py-2 px-3 hover:bg-gray-200 rounded cursor-pointer relative"
                onMouseEnter={() => setHovered({ ...hovered, note: true })}
                onMouseLeave={() => setHovered({ ...hovered, note: false })}
            >
              <a href="/note" className="block w-full h-full">Notes</a>
              {hovered.note && (
                  <button
                      className="absolute top-1 right-1 bg-blue-500 text-white p-1 rounded-full text-sm"
                      onClick={() => document.getElementById('noteInput')?.focus()}
                  >
                    +
                  </button>
              )}
            </li>

            {/* Tasks */}
            <li
                className="py-2 px-3 hover:bg-gray-200 rounded cursor-pointer relative"
                onMouseEnter={() => setHovered({ ...hovered, task: true })}
                onMouseLeave={() => setHovered({ ...hovered, task: false })}
            >
              <a href="/task" className="block w-full h-full">Tasks</a>
              {hovered.task && (
                  <button
                      className="absolute top-1 right-1 bg-blue-500 text-white p-1 rounded-full text-sm"
                      onClick={() => alert('할 일 추가는 아직 구현되지 않았습니다')}
                  >
                    +
                  </button>
              )}
            </li>
          </ul>
        </div>

        {/* 메인 콘텐츠 */}
        <div className="flex-1 p-6 overflow-y-auto">
          <h1 className="text-2xl font-bold mb-4">Notion 클론에 오신 것을 환영합니다</h1>

          {/* 노트 목록 */}
          <div className="p-4 bg-white rounded shadow-md">
            <h2 className="text-lg font-semibold mb-2">📌 노트 목록</h2>
            <ul className="space-y-2">
              {notes.map((note, index) => (
                  <li
                      key={index}
                      className="p-4 bg-gray-100 rounded shadow flex justify-between items-center cursor-pointer"
                      onClick={() => setSelectedNoteIndex(index)}
                  >
                    <span className="flex-1 text-gray-800">{note}</span>
                    <div className="flex gap-2 ml-2">
                      <button onClick={(e) => { e.stopPropagation(); updateNote(index); }} className="text-gray-500 hover:text-gray-700">⋮</button>
                      <button onClick={(e) => { e.stopPropagation(); deleteNote(index); }} className="text-red-500 hover:text-red-700">✕</button>
                    </div>
                  </li>
              ))}
            </ul>
          </div>

          {/* 노트 작성 */}
          <div className="p-4 bg-white rounded shadow-md mt-6">
            <h2 className="text-lg font-semibold">📝 새 노트 작성</h2>
            <textarea
                id="noteInput"
                className="w-full p-2 border rounded mt-2"
                placeholder="새로운 노트를 작성하세요..."
                value={newNote}
                onChange={(e) => setNewNote(e.target.value)}
            />
            <button
                onClick={addNote}
                className="mt-2 px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-600"
            >
              작성
            </button>
          </div>

          {/* 댓글 영역 */}
          {selectedNoteIndex !== null && (
              <div className="p-4 bg-white rounded shadow-md mt-6">
                <h2 className="text-lg font-semibold">💬 댓글</h2>
                <ul className="space-y-2 mt-4">
                  {comments.map((comment, idx) => (
                      <li
                          key={idx}
                          className="p-3 bg-gray-200 rounded flex justify-between items-center"
                      >
                        <span>{comment}</span>
                        <button
                            onClick={() => deleteComment(idx)}
                            className="text-red-500 hover:text-red-700"
                        >
                          ✕
                        </button>
                      </li>
                  ))}
                </ul>
                <div className="flex mt-4">
                  <input
                      className="w-full p-2 border rounded-l text-sm"
                      placeholder="댓글을 작성하세요..."
                      value={newComment}
                      onChange={(e) => setNewComment(e.target.value)}
                      onKeyDown={(e) => e.key === 'Enter' && addComment()}
                  />
                  <button
                      onClick={addComment}
                      className="px-4 bg-blue-500 text-white rounded-r hover:bg-blue-600 text-sm"
                  >
                    등록
                  </button>
                </div>
              </div>
          )}
        </div>
      </div>
  );
};

export default Home;
