package com.bit.mvc.member;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bit.mvc.domain.Report;

@Controller
public class FileUploadController {

	//파일을 받을 경로
	String path = "/uploadfile";
	
	@RequestMapping("/fileupload/uploadForm")
	public String getForm() {
		
		return "fileupload/uploadForm";
	}
	
	
	@RequestMapping(value = "/fileupload/upload1", method = RequestMethod.POST)
	//MultipartFile를 통해 파일을 가져올수있는 파일객체를 생성할 수 있다.
	public String upload1(@RequestParam("sno") String sno, @RequestParam("report") MultipartFile file, Model model, HttpServletRequest request) {
	
		//파일저장
		String dir = request.getSession().getServletContext().getRealPath(path);
		try {
			if(!file.isEmpty() && file.getSize() > 0) {
				file.transferTo(new File(dir, sno+"_"+file.getOriginalFilename()));
			}
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("sno", sno);
		//파일이름
		model.addAttribute("fileName", file.getOriginalFilename());
		//파일사이즈
		model.addAttribute("fileSize",file.getSize());
		
		return "fileupload/upload";
	}
	
	
	@RequestMapping(value = "/fileupload/upload2", method = RequestMethod.POST)
	public String upload2(MultipartHttpServletRequest request, Model model) {
	
		String sno = request.getParameter("sno");
		//MultipartHttpServletRequest를 사용해서 파일을 받아올땐 getFile을 사용해서 파일객체를 가져온다.
		MultipartFile file = request.getFile("report");
		
		model.addAttribute("sno", sno);
		//파일이름
		model.addAttribute("fileName", file.getOriginalFilename());
		//파일사이즈
		model.addAttribute("fileSize",file.getSize());
		
		return "fileupload/upload";
	}
	
	
	@RequestMapping(value = "/fileupload/upload3", method = RequestMethod.POST)
	public String upload3(Report report, Model model) {
		//이름을 따로 지어주려면 사용 ( report 객체를 통해 바로 el로 출력가능하다)
		/*
		model.addAttribute("sno", report.getSno());
		//파일이름
		model.addAttribute("fileName", report.getFileName());
		//파일사이즈
		model.addAttribute("fileSize",report.getFileSize());
		*/
		
		return "fileupload/upload";
	}
	
}
