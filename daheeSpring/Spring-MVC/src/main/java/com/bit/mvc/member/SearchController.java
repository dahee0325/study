package com.bit.mvc.member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.mvc.domain.SearchType;

@Controller
public class SearchController {

	@RequestMapping("/search/search")
	public String searchForm1() {
		return "search/form";
	}
	
	
	//@ModelAttribute : 반환되는 options 을 searchType라는 이름으로 view 와 공유할수있음
	@ModelAttribute("searchType")
	public List<SearchType> getSearchType() {
		
		List<SearchType> options = new ArrayList<SearchType>();
		options.add(new SearchType(1, "전체"));
		options.add(new SearchType(2, "제목"));
		options.add(new SearchType(3, "내용"));
		options.add(new SearchType(4, "제목+내용"));
		
		return options;
	}
	
	@ModelAttribute("popularList")
	public String[] getPopularList() {
		return new String[] {"java", "JSP", "Spring", "Oracle"};
	}
	
}
