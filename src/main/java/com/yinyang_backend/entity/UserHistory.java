package com.yinyang_backend.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class UserHistory implements Serializable{
	private static final long serialVersionUID = 1L;
	private long historyId;
	private long userId;
	private LocalDateTime createTime;
	
	private String title;
	private String yaosList;
}
