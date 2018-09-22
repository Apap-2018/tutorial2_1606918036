package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/viral")
	public String index(){
		return "viral";
	}
	
	/*@RequestMapping("/challenge")
	public String challenge(@RequestParam(value="name") String name, Model model) {
		model.addAttribute("name", name);
		return "challenge";
	}*/
	
	/*@RequestMapping("/challenge")
	public String challenge (@RequestParam(value="name",required=false) String name, Model model) {
		model.addAttribute("name",name);
		return "challenge";
	}*/
	
	/*@RequestMapping("/challenge")
	public String challenge(@RequestParam(value="name",required=false,defaultValue="kiki") String name, Model model) {
		model.addAttribute("name",name);
		return "challenge";
	}*/
	
	/*@RequestMapping("/challenge/{name}")
	public String challengePath(@PathVariable String name, Model model) {
		model.addAttribute("name", name);
		return "challenge";
	}*/
	
	@RequestMapping(value= {"/challenge","/challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if(name.isPresent()) {
			model.addAttribute("name", name.get());
		}
		else {
			model.addAttribute("name", "KB");
		}
		return "challenge";
	}
	
	@RequestMapping(value= {"/generator"})
	public String generator(@RequestParam(value="a") Integer a, @RequestParam("b") Integer b, Model model) {
		if(a==null && b==null) {
			model.addAttribute("a", 0);
			model.addAttribute("b", 0);
			model.addAttribute("kata", "hm");
		}
		else {
			model.addAttribute("a", a);
			model.addAttribute("b", b);
			model.addAttribute("kata",hm(a, b));
		}
		return "generator";
	}
	
	public String hm(int a, int b) {
		String kata= "h";
		String m="";
		if(a==0) {
			a++;
		}
		if(b==0) {
			b++;
		}
		for(int i=0;i<a;i++) {
			m=m+"m";
		}
		kata=kata+m;
		String kataTemp = kata;
		
		for(int i=1;i<b;i++) {
			kata+=" "+kataTemp;
		}
		
		return kata;
	}
}
