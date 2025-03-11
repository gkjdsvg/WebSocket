//package com.example.WebSocket.controller;
//
//import com.example.WebSocket.DTO.LoginRequest;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.http.MediaType;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//
//
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//@WithMockUser(username = "test@example.com", password = "123456", roles = {"USER"})
//class AuthControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @BeforeEach
//    void setUp() {
//        // 필요한 설정 (예: 기본적인 사용자 등록 등)
//    }
//
//    @Test
//    public void login_Return_JwtToken() throws Exception {
//        String jsonRequest = "{\"username\":\"tester\",\"password\":\"password123\"}";
//
//        mockMvc.perform(post("/api/auth/login")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(jsonRequest))
//                .andExpect(status().isOk())  // 200 응답 기대
//                .andExpect(jsonPath("$.token").exists());  // JWT 토큰이 반환되는지 확인
//    }
//
//    @Test
//    void login_ShouldReturnJwtToken() throws Exception {
//        // 테스트할 로그인 요청 데이터
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setUsername("test@example.com"); // 테스트할 사용자명
//        loginRequest.setPassword("123456"); // 테스트할 패스워드
//
//        // 요청을 JSON 형태로 변환
//        String jsonRequest = objectMapper.writeValueAsString(loginRequest);
//
//        // POST 요청을 보내고 응답을 받음
//        ResultActions result = mockMvc.perform(post("/api/auth/login")
//                .with(csrf())
//                .contentType("application/json")
//                .content(jsonRequest));
//
//        // 응답 상태가 200 OK인지, 토큰이 포함되어 있는지 확인
//        result.andExpect(status().isOk())  // HTTP 상태가 OK
//                .andExpect(jsonPath("$.token").exists());  // JSON 응답에서 "token" 필드가 존재하는지 확인
//    }
//
//}