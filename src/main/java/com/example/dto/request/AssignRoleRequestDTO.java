package com.example.dto.request;

public class AssignRoleRequestDTO {

	private Long userId;

    private String role;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getRole() {
		return role;
	}

	public AssignRoleRequestDTO(Long userId, String role) {
		super();
		this.userId = userId;
		this.role = role;
	}

	public void setRole(String role) {
		this.role = role;
	}
    
}
