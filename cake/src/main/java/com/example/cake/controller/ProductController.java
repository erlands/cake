package com.example.cake.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.cake.entity.Page;
import com.example.cake.entity.Product;
import com.example.cake.entity.Result;
import com.example.cake.service.ProductService;
import com.example.cake.utils.StrUtils;

@Controller
public class ProductController {
	@Autowired
	private ProductService service;

	@RequestMapping("/admin/product/list")
	@ResponseBody
	public Page<Product> list(Integer page, Integer rows) {
		if (page == null) {
			page = 1;
		}

		if (rows == null) {
			rows = 10;
		}

		return this.service.list(page, rows);
	}
	
	@RequestMapping("/admin/product/add")
	@ResponseBody
	public String add(HttpServletRequest request,Product pro,MultipartFile file) throws Exception {
		if(!file.isEmpty()) {
			String fileName = saveFile(request, file);
			pro.setImg("/u/"+fileName);
		}
		
		pro.init();
		
		service.save(pro);
		return "ok";
	}
	
	@RequestMapping("/admin/product/delete")
	@ResponseBody
	public Result delete(String ids) {
		Integer[] idArr = StrUtils.getInt(ids);
		if(idArr != null && idArr.length > 0) {
			service.delete(idArr);
		}
		return new Result().ok("");
	}
	
	@RequestMapping("/admin/product/update")
	@ResponseBody
	public String update(Product bean,MultipartFile file,HttpServletRequest request) throws Exception {
		if(!file.isEmpty()) {
			String fileName = saveFile(request, file);
			bean.setImg("/u/"+fileName);
		}
		this.service.update(bean);
		return "ok";
	}
	
	public static void main(String[] args) {
		String originalFilename = "微信图片_20180407122048.jpg";
		String fileName = "11213213431321" + originalFilename.substring(originalFilename.indexOf("."), originalFilename.length());
		System.out.println(fileName);
	}

	@RequestMapping("/admin/product/toList")
	public String toList() {
		return "/admin/product/list";
	}

	@RequestMapping("/admin/product/toAdd")
	public String toAdd() {
		return "/admin/product/add";
	}
	@RequestMapping("/admin/product/toEdit")
	public String toEdit(int id,Model model) {
		Product bean = this.service.get(id);
		model.addAttribute("pro", bean);
		return "/admin/product/edit";
	}
	
	private String saveFile(HttpServletRequest request,MultipartFile file) throws Exception{
		long ms = System.currentTimeMillis();
		String originalFilename = file.getOriginalFilename();
		String fileName = ms + originalFilename.substring(originalFilename.indexOf("."), originalFilename.length());
		String path = request.getServletContext().getRealPath("/u") + "/" + fileName;
		
		File newFile = new File(path);
		file.transferTo(newFile);
		
		return fileName;
	}
}
