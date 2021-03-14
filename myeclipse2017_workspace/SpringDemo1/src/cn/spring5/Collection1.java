package cn.spring5;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Collection1 {
	private List<String> list;
	private Set<String> set;
	private Map<String, Integer> map;
	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}

	public void setSet(Set<String> set) {
		this.set = set;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Collection1 [list=" + list + ", set=" + set + ", map=" + map + "]";
	}
	
}
