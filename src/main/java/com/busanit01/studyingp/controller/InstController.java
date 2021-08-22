package com.busanit01.studyingp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.busanit01.studyingp.dto.ClassDTO;
import com.busanit01.studyingp.dto.ClassDetailDTO;
import com.busanit01.studyingp.service.ClassDetailService;
import com.busanit01.studyingp.service.ClassService;
import com.busanit01.studyingp.util.Utility;

@Controller
public class InstController {
	
	@Autowired
	private ClassService classService;
	
	@Autowired
	private ClassDetailService classDetailService;
	
	@RequestMapping(value = "/editClsOut", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView editClsOut(@RequestParam("cls_code") String cls_code) {
		ClassDTO selCls = new ClassDTO();
		
		selCls = classService.getClsOne(cls_code);
		
		Map<String, ClassDTO> params = new HashMap<String, ClassDTO>();
		
		params.put("selCls", selCls);
		
		return Utility.direction("editclsout", params);
	}
	
	@RequestMapping(value = "/editClsDetail", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView editClsDetail(@RequestParam("cls_code") String cls_code) {
		List<ClassDetailDTO> clsDetailList = new ArrayList<ClassDetailDTO>();
		
		clsDetailList = classDetailService.getClsDetailByClsCode(cls_code);
		
		Map<String, List<ClassDetailDTO>> params = new HashMap<String, List<ClassDetailDTO>>();
		
		params.put("clsDetailList", clsDetailList);
		
		return Utility.direction("editclsdetail", params);
	}
	
	@RequestMapping(value = "doEditClsDetail", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView doEditClsDetail(String cls_code, String clsd_content, String clsd_url, String cls_totlect) {
		List<ClassDetailDTO> clsDetailList = new ArrayList<ClassDetailDTO>(Integer.valueOf(cls_totlect));
		String[] clsd_content_arr = clsd_content.split(",");
		String[] clsd_url_arr = clsd_url.split(",");
		
		for(int i = 0; i < clsDetailList.size(); i++) {
			ClassDetailDTO clsDetail = new ClassDetailDTO();
			clsDetail.setClsd_lect(i + 1);
			clsDetail.setClsd_content(clsd_content_arr[i]);
			clsDetail.setClsd_url(clsd_url_arr[i]);
			clsDetailList.add(i, clsDetail);
		}		
		return null;
	}
}
