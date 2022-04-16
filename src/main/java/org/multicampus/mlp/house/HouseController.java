package org.multicampus.mlp.house;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.multicampus.mlp.common.FileUploadUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@CrossOrigin("*")
	@RestController
	public class HouseController{
		
		@Value("${fileUploadPath}")
		String fileUploadPath;
		
		@Value("${domain}")
		String domain;
		
		@Resource(name="houseService")
		HouseService houseService;
	
	
	@RequestMapping("/house/insert")
	Map<String, String> insert(List<MultipartFile> files, HouseDto dto, HttpServletRequest req)
	{
		System.out.println("insert �� �ϱ� �� --->"+ dto.getHOUSE_ID());
		System.out.println(dto.getUser_id());
		houseService.insert(dto);
		System.out.println("house_id--------------"+ dto.getHOUSE_ID());
		
		for(MultipartFile file : files) {
			HouseImageDto imageDto = new HouseImageDto();
			String uploadDir = fileUploadPath+ "/image" ;
			
			if(file!=null)
			{
				try {
					//���ο� ���ϸ��� ��ȯ�Ѵ�. ���ϸ��� �ߺ��� �� �ִ�
					String filename=FileUploadUtil.upload(uploadDir, file);
					imageDto.setIMAGES_THUMBNAIL(domain +"/"+ uploadDir + "/"+ filename);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			imageDto.setHOUSE_ID(dto.getHOUSE_ID());
			
			houseService.image_insert(imageDto);
			
		}
		
		
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "success");
		return map;
	}
	
}
