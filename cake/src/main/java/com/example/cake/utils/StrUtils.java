package com.example.cake.utils;

import java.util.ArrayList;
import java.util.List;

public class StrUtils {

	public static Integer[] getInt(String str) {
		String[] arr = str.split(",");
		List<Integer> list = new ArrayList<Integer>();
		for(String s : arr) {
			s = s.trim();
			if(s != null && !"".equals(s)) {
				list.add(Integer.valueOf(s));
			}
		}
		return list.toArray(new Integer[list.size()]);
	}
}
