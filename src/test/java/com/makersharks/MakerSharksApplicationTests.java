package com.makersharks;

import com.makersharks.controllers.AuthController;
import com.makersharks.payloads.reponse.MessageResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.makersharks.payloads.register.RegisterUserRequest;
import com.makersharks.payloads.response.UserResponse;
import com.makersharks.service.AuthService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class MakerSharksApplicationTests {

	@InjectMocks
	private AuthController authController;

	@Mock
	private AuthService authService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testRegisterUser_Success() {
		RegisterUserRequest request = new RegisterUserRequest("john_doe", "john@example.com", "Password@123", 1990L, "123 Main St", "About John");

		ResponseEntity<MessageResponse> response = authController.registerUser(request);

		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertEquals("User has been successfully created!", Objects.requireNonNull(response.getBody()).getMessage());
	}

	@Test
	void testFetchUsers_Success() {
		UserResponse userResponse = new UserResponse("john_doe", 1990L, "123 Main St", "About John", LocalDateTime.now());
		when(authService.fetchUser("john_doe")).thenReturn(userResponse);
		ResponseEntity<UserResponse> response = authController.fetchUsers("john_doe");
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
}

