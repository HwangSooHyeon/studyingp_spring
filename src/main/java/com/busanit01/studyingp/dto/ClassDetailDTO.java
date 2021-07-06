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
public class ClassDetailDTO {
	
	// 강의상세번호(PK)
	private int clsd_code;
	// 강의 URL
	private String clsd_url;
	// 강사 번호(FK)
	private int mem_code;
	// 연동되는 강의 번호(FK)
	private int cls_code;
	// 강의 회차
	private int clsd_lect;
	// 강의 상세 내용
	private String clsd_content;
	// 강의 상세 삭제 여부
	private int clsd_delete;
	// 강의 전체 차수
	private int cls_totlect;
}
