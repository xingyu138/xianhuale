package cn.springbootxianhualemaster.util;

/**
 * 获取分页的起始页
 * @author leo
 * 2019年3月9日
 */
public class PageUtil {
	public static Integer getPageStart(Integer pageNum,Integer pageSize){
		return (pageNum-1)*pageSize;
	}
}
