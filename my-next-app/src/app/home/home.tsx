'use client';
import React from 'react';

const Home = () => {
  return (
      <div className="bg-gray-100 h-screen flex flex-col">
        {/* 상단 네비게이션 바 */}
        <div className="flex justify-between items-center bg-white p-4 shadow-md">
          <h2 className="text-lg font-bold">My Notion</h2>
          <div>
            <button className="px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-600">
              로그인
            </button>
            <button className="px-4 py-2 bg-gray-300 text-black rounded hover:bg-gray-400 ml-2">
              회원가입
            </button>
          </div>
        </div>

        {/* 전체 레이아웃 */}
        <div className="flex flex-1">
          {/* 사이드바 */}
          <div className="w-64 bg-white p-4 shadow-md">
            <ul>
              <li className="py-2 px-3 hover:bg-gray-200 rounded cursor-pointer">
                <a href="/home" className="block w-full h-full">Home</a>
              </li>
              <li className="py-2 px-3 hover:bg-gray-200 rounded cursor-pointer relative">
                <a href="/note" className="block w-full h-full">Notes</a>
                <button className="absolute top-1 right-1 bg-blue-500 text-white p-1 rounded-full">
                  +
                </button>
              </li>
              <li className="py-2 px-3 hover:bg-gray-200 rounded cursor-pointer relative">
                <a href="/task" className="block w-full h-full">Tasks</a>
                <button className="absolute top-1 right-1 bg-blue-500 text-white p-1 rounded-full">
                  +
                </button>
              </li>
            </ul>
          </div>

          {/* 메인 콘텐츠 */}
          <div className="flex-1 p-6 overflow-y-auto">
            <h1 className="text-2xl font-bold mb-4">Welcome to Notion Clone</h1>

            <div className="space-y-4">
              <div className="p-4 bg-white rounded shadow-md">
                <h2 className="text-lg font-semibold">📌 To-Do List</h2>
                <ul>
                  <li><input type="checkbox" className="mr-2" /> Learn HTML & CSS</li>
                  <li><input type="checkbox" className="mr-2" /> Build a Notion Clone</li>
                  <li><input type="checkbox" className="mr-2" /> Explore JavaScript</li>
                </ul>
              </div>

              <div className="p-4 bg-white rounded shadow-md">
                <h2 className="text-lg font-semibold">📝 Notes</h2>
                <p className="text-gray-700">
                  This is a simple Notion-like UI created with Tailwind CSS.
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>
  );
};

export default Home;
