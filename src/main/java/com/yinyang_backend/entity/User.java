package com.yinyang_backend.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private long userId;
	private String username;
	private String password;
	private int age;
	
	private int status;
	private LocalDateTime createTime;
	private LocalDateTime updateTime;

}
