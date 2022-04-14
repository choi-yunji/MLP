package org.multicampus.mlp.common;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {
	 

	//�뙆�씪紐낆씠 以묐났�맆�븣 (1)...(2) .....  洹몃┝(1).jpg,  洹몃┝(2).jpg
	//�뿰�룄 �썡 �씪 �떆媛� 珥� 諛�由ъ큹  �옖�뜕媛� 留뚮뱾�뼱�꽌 �뙆�씪紐낆쑝濡� �븯湲곕룄 �븳�떎 

	public static String getFileName(String contextPath , String orifilename)
	{
		 String filePath = contextPath ;
		 int pos = orifilename.lastIndexOf(".");      //.瑜� 湲곗��쑝濡�    
		 String ext = orifilename.substring(pos+1);     //�뙆�씪紐낃낵 
		 String oriFile = orifilename.substring(0, pos-1);  //�솗�옣�옄濡� 
					 
		 String filename = orifilename; 
		
		 File newFile = new File(filePath+"/" +filename); 
		 int i=1;
		 while(newFile.exists())  
		 {
			
			 filename = oriFile + "("+i+")." + ext; 
			 i++;
			 newFile = new File(filePath + "/" +filename);
			 
		 }
		 
		 return filename;
	}
	
	//�뙆�씪�쓣 吏��젙�맂 �뤃�뜑�뿉 �뾽濡쒕뱶 �썑 �뙆�씪�씠由꾩쓣 諛섑솚�븳�떎 
	//泥ル쾲吏몄씤�옄 : �뙆�씪�씠 �뾽濡쒕뱶 �맆 �뵒�젆�넗由�, �몢踰덉㎏�씤�옄 �뙆�씪
	public static String upload(String uploadDir,  MultipartFile multipartFile) throws IOException
	{

		String fileName = getFileName(uploadDir, multipartFile.getOriginalFilename());
		//�깉濡쒖슫 �뙆�씪紐� 
		Path uploadPath = Paths.get(uploadDir); //�뾽濡쒕뱶�븷 �떎�젣 寃쎈줈瑜� 媛��졇���꽌 
        
        if (!Files.exists(uploadPath)) { //�뵒�젆�넗由ш� 議댁옱�븯吏� �븡�쑝硫� 
            try {
				Files.createDirectories(uploadPath);//�뵒�젆�넗由� 留뚮뱾湲� 
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
         
        //�뙆�씪 �뾽濡쒕뱶�떆 諛섎뱶�떆 臾쇰━�쟻寃쎈줈(�젅���쟻 寃쎈줈)瑜� �궗�슜�뻽�뒗�뜲 �긽���쟻 寃쎈줈 �궗�슜�씠 媛��뒫�븿 
        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);  //�뙆�씪 寃쎈줈 �옟湲� 
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            //�긽���쟻寃쎈줈瑜� �씠�슜�빐�꽌 �뙆�씪 �뾽濡쒕뱶瑜� �븳�떎 
        } catch (IOException ioe) {        
            throw new IOException("Could not save image file: " + fileName, ioe);
        }    
        
        return fileName;
	
		
	}
	
	
	
	public static void upload(String uploadDir, List<MultipartFile> fileList,
			List<String> fileNameList)
	{

			
		//java.io.File
		File file = new File(uploadDir);
		if( !file.exists())
		{
			file.mkdir();
		}
		
		//System.out.println("filesize : " + fileList.size());
		
		if( fileList!=null && fileList.size()>0)
		{
			 for(MultipartFile multipartFile : fileList)
			 {		
				 try {
					String filename = upload(uploadDir,  multipartFile);
					fileNameList.add(filename);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
			 }
				
							 }
		}
		
	}
	
	



