package org.multicampus.mlp.help.domain.controller;

import java.io.IOException;
import java.util.HashMap;

import org.multicampus.mlp.common.FileUploadUtil;
import org.multicampus.mlp.help.domain.HelpDto;
import org.multicampus.mlp.help.service.HelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


//http://localhost:9090/help/guideList
@CrossOrigin("*")
@RequestMapping("/help")
@RestController 
public class HelpController {
	
	@Value("${fileUploadPath}")  //src/main/resources/application.properies �� ���� �о�´� 
	String fileUploadPath;
	
	@Value("${domain}")
	String domain;

	@Autowired 
	HelpService service;
	
	@GetMapping(value="/guideList")
	HashMap<String, Object> guideList(HelpDto dto){
		
		System.out.println("****"+ dto.getKeyword());
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("guideList", service.getGuideList());
		map.put("highLightList", service.getHighLightList(dto));
			
		return map;
	}
	
	@GetMapping(value="/view/{id}")
	HelpDto guideView(@PathVariable("id")int id)
	{
		return service.getGuideView(id);
	}
	
	//��� ������ �����ϱ� - JSON ���·� �޾ƿ´� 
	//������ �����ؾ� �ϴ� ��찡 �ְ�  -  form �±׿� enctype="multipart/form-data"
	//FormData ��� ��ü�� ���ؼ� ������ ������ 
	//���������� MultipartFile ��ü�� ����ؼ� ���� ������ �Ѵ� 
	//postman body - form-data  �������۽� ����Ѵ�. 
	
	//jsp��ſ� react�� ó�� react �� �������� ��� �ֱ⸸ �ϸ�ȴ�.
	//MultipartFile file_image (Ű��)
	@PostMapping(value="/save")   // /help/save
	HashMap<String, String> save( MultipartFile file_image, HelpDto dto)
	{
		String uploadDir = fileUploadPath+ "/image";
		HashMap<String, String> map =new HashMap<String, String>();
		String filename="";
		
		try {
			filename= FileUploadUtil.upload(uploadDir, file_image);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		dto.setCenter_image(domain +"/"+ uploadDir + "/"+ filename);
		dto.setImage_name(filename);
		
		service.insert(dto);
		
		map.put("result", "success");
		return map;
	}
	
	
	//���� ������ ���ʿ䰡 ���� ��쿡 - �׳� JSON 
	// {title:"����", contents:"����"}   �̷��� �ؼ� ������ �ȴ�. 
	//postman ������ body �±׿� x-www-form-urlencoded  �� �����ؼ� Ű�� ���� ������ 
	
	
}








