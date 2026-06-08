package com.smart.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComplaintModel {
	private int ticketId;
	private int studentId;
	private int categoryId;
	private String priority;
	private String description;
	private String status;
	private String createdTime;
}
