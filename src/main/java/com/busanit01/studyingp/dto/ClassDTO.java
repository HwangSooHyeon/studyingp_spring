package com.busanit01.studyingp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ClassDTO {

	private int cls_code;
	private String cls_category;
	private String cls_name;
	private int mem_code;
	private int cls_price;
	private String cls_time;
	private String cls_period;
	private int cls_delete;
	private String cls_content;
	private String cls_img;
	private String cls_url;
	private int cls_totlect;
}

