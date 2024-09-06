package java7.test.view;


import java.io.Writer;
import java.util.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONPView extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String callback = request.getParameter("callback");
		ObjectMapper om = new ObjectMapper();
		
		Map resultMap = new HashMap();
		Iterator<String> keys = model.keySet().iterator();
	    while( keys.hasNext() ){
	    	String key = keys.next();
	    	if(!(key.indexOf("org.springframework.validation.BindingResult") > -1)) {
	    		resultMap.put(key , model.get(key));
	    	}
	    }
	    
		String json = om.writeValueAsString(resultMap);

		response.setCharacterEncoding("utf-8");
		
		Writer out = response.getWriter();
		out.append(callback).append("(").append(json).append(")");
	}
}
