package java7.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@RequestMapping(value="/init")
	public ModelAndView init(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("init");
		
		return mv;
	}
}
