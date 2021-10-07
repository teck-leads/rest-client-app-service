package com.techleads.app.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyData {
	
	private Integer id;
    private String email;
    private String first_name;
   private String last_name;
   private String avatar;

}
