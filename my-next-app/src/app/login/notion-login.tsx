'use client';

import { useState } from 'react';
import { FaUser, FaLock } from 'react-icons/fa';

export default function Home() {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleLogin = async () => {
        try {
            const response = await fetch('/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ username, password }),
            });

            const data = await response.json();

            if (data.success) {
                alert('회원가입이 성공했습니다!');
                window.location.href = '/home';
            } else {
                alert('회원가입 실패');
            }
        } catch (error) {
            console.error('Error:', error);
            alert('에러가 발생했습니다.');
        }
    };

    return (
        <div style={styles.body}>
            <div style={styles.background}>
                <div style={{ ...styles.circle, ...styles.circle1 }} />
                <div style={{ ...styles.circle, ...styles.circle2 }} />
            </div>
            <div style={styles.container}>
                <div>
                    <h2 style={styles.title}>로그인</h2>
                    <div style={styles.inputBox}>
                        <FaUser style={styles.icon} />
                        <input
                            type="text"
                            placeholder="이름"
                            required
                            value={username}
                            onChange={(e) => setUsername(e.target.value)}
                            style={styles.input}
                        />
                    </div>
                    <div style={styles.inputBox}>
                        <FaLock style={styles.icon} />
                        <input
                            type="password"
                            placeholder="비밀번호"
                            required
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            style={styles.input}
                        />
                    </div>
                    <button style={styles.button} onClick={handleLogin}>
                        로그인
                    </button>
                </div>
            </div>
        </div>
    );
}

const styles: { [key: string]: React.CSSProperties } = {
    body: {
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
        height: '100vh',
        background: '#f0f0f0',
        position: 'relative',
        overflow: 'hidden',
        fontFamily: 'Poppins, sans-serif',
    },
    background: {
        position: 'absolute',
        width: '100%',
        height: '100%',
        overflow: 'hidden',
    },
    circle: {
        position: 'absolute',
        borderRadius: '50%',
        background: '#a0e7e5',
        opacity: 0.3,
    },
    circle1: {
        width: 500,
        height: 500,
        top: -150,
        left: -150,
    },
    circle2: {
        width: 400,
        height: 400,
        bottom: -120,
        right: -120,
    },
    container: {
        position: 'relative',
        background: 'white',
        padding: 40,
        boxShadow: '0px 5px 20px rgba(0,0,0,0.1)',
        borderRadius: 15,
        textAlign: 'center',
        width: 450,
        zIndex: 1,
    },
    title: {
        fontSize: 24,
        marginBottom: 30,
    },
    inputBox: {
        display: 'flex',
        alignItems: 'center',
        border: '1px solid #ccc',
        borderRadius: 5,
        padding: 10,
        marginBottom: 20,
        background: 'white',
    },
    icon: {
        color: '#888',
        marginRight: 10,
    },
    input: {
        border: 'none',
        outline: 'none',
        flex: 1,
        fontSize: 16,
    },
    button: {
        width: '100%',
        padding: 14,
        background: '#a0e7e5',
        border: 'none',
        borderRadius: 5,
        fontSize: 18,
        color: 'white',
        cursor: 'pointer',
    },
};
