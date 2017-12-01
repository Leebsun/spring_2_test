package com.iu.s2_test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private Car car;
	@Inject
	private SmartPhone smartPhone;
	@Inject
	private Movie movie;
	@Inject
	private Idol idol;
	
	@RequestMapping(value="/fileUpload5", method=RequestMethod.POST)
	public void fileUpload2(MultipartHttpServletRequest request){
		Map<String, MultipartFile> map=request.getFileMap();
		Iterator<String> its=map.keySet().iterator();
		while(its.hasNext()){
			System.out.println(its.next());
			map.get(its.next());
		}
		
		Iterator<String> it=request.getFileNames();
		while(it.hasNext()){
			System.out.println(it.next());
	
	
			
		}
	}
	
	@RequestMapping(value="/fileUpload4", method=RequestMethod.POST)
	public void fileUpload(MultipartHttpServletRequest request){
		System.out.println("title : "+request.getParameter("title"));
		List<MultipartFile> ar=request.getFiles("f1");
		for(MultipartFile file: ar){
			System.out.println(file.getOriginalFilename());
		}

			
			
		}
		
		
	
	
	@RequestMapping(value="/fileUpload3", method=RequestMethod.POST)
	public void fileUpload(FileDTO fileDTO){
		System.out.println(fileDTO.getTitle());
		for(MultipartFile file : fileDTO.getF1()){
			System.out.println(file.getOriginalFilename());
			
			
		}
		
		
	}
	
	@RequestMapping(value="/fileUpload2", method=RequestMethod.POST)
	public void fileUpload( @RequestParam(value="f1")MultipartFile [] files){
		for(MultipartFile file : files){
			System.out.println(file.getOriginalFilename());
			System.out.println(file.getName());
			
		}
		
		
	}
	
	@RequestMapping(value="/fileUpload", method=RequestMethod.GET)
	public void fileUpload(){}
	
	@RequestMapping(value="/fileUpload", method=RequestMethod.POST)
	public void fileUpload(Model model, @RequestParam(value="f1")MultipartFile file, HttpSession session){
		String filePath = session.getServletContext().getRealPath("resources/upload");
		File f = new File(filePath);
		
		if(!f.exists()){
			f.mkdirs();
		}
		//a.jpg
		String fileName = file.getOriginalFilename();
		fileName=fileName.substring(fileName.lastIndexOf("."));
		String name=UUID.randomUUID().toString();
		fileName = name+fileName;
		
		f= new File(filePath, fileName);
		
		try {
			file.transferTo(f);
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*try {
			byte [] ar=file.getBytes();
			f=new File(filePath, fileName);
			FileOutputStream fo = new FileOutputStream(f);
			fo.write(ar);
			fo.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		
	}
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		idol = new Idol();
		
		System.out.println("Team : "+idol.getTeam());
		System.out.println("Members : "+idol.getMembers());
		System.out.println("=======================");
		System.out.println("TITLE : "+movie.getTitle());
		System.out.println("Price : "+movie.getPrice());
		System.out.println("Point : "+movie.getPoint());
		System.out.println("Brand : "+smartPhone.getBrand());
		System.out.println("Color : "+smartPhone.getColor());
		System.out.println("price : "+smartPhone.getPrice());
		
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("car", car);
		return "home";
	}
	
}
