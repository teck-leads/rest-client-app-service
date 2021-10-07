package com.techleads.app.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
	
	private Integer page;
	private Integer per_page;
	private Integer total;
	private Integer  total_pages;
	private List<MyData> data;
	private MySupport support;

}
