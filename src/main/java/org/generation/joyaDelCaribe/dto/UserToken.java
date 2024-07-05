package org.generation.joyaDelCaribe.dto;

public class UserToken {
	private final String accessToken;

	public UserToken(String accessToken) {
		super();
		this.accessToken = accessToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

}
