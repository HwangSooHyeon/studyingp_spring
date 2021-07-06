package com.busanit01.studyingp.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.busanit01.studyingp.dto.ClassDTO;
import com.busanit01.studyingp.dto.MemberDTO;
import com.busanit01.studyingp.service.ClassService;
import com.busanit01.studyingp.service.MemberService;
import com.busanit01.studyingp.util.Utility;

@Controller
public class UploadController {
	//private static final String FILE_PATH = "C:\\Users\\mikae\\Desktop\\studyingp_spring\\studyingp_spring\\src\\main\\webapp\\resources\\img";
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private ClassService classService;
	
	@RequestMapping(value = "/doUpload", method = RequestMethod.POST)
	public ModelAndView doUpload(ClassDTO clsDTO, 
			@RequestParam("cls_img_file")MultipartFile file,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String fileName = file.getOriginalFilename();
		
		// 파일 경로
		String file_path = request.getSession().getServletContext().getRealPath("/resources/img/");

		// cls_img 이름
		clsDTO.setCls_img(fileName);
		
		// clsDTO에 mem_code 할당
		HttpSession session = request.getSession();
		MemberDTO memDTO = (MemberDTO) session.getAttribute("currentUser");
		memDTO = memberService.getMemById(memDTO);
		
		clsDTO.setMem_code(memDTO.getMem_code());		
		
		int result = classService.uploadCls(clsDTO, memDTO);
		
		if(!file.getOriginalFilename().isEmpty() && result == 1) {
			file.transferTo(new File(file_path, fileName));
			String msg = "업로드에 성공했습니다. 확인 버튼을 누르면 메인화면으로 갑니다.";
			Map<String, String> params = new HashMap<String, String>();
			params.put("msg", msg);
			return Utility.direction("afterupload", params);
		}else if(!file.getOriginalFilename().isEmpty() && result == 0) {
			String msg = "db 업로드에 실패했습니다. 확인 버튼을 누르면 메인화면으로 갑니다.";
			Map<String, String> params = new HashMap<String, String>();
			params.put("msg", msg);
			return Utility.direction("afterupload", params);
		}else if(file.getOriginalFilename().isEmpty() && result == 1) {
			String msg = "이미지 업로드에 실패했습니다. 확인 버튼을 누르면 메인화면으로 갑니다.";
			Map<String, String> params = new HashMap<String, String>();
			params.put("msg", msg);
			return Utility.direction("afterupload", params);
		}else {
			String msg = "업로드에 실패했습니다. 확인 버튼을 누르면 메인화면으로 갑니다.";
			Map<String, String> params = new HashMap<String, String>();
			params.put("msg", msg);
			return Utility.direction("afterupload", params);
		}
	}
}
