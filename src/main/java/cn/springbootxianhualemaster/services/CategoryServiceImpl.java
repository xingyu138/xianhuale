package cn.springbootxianhualemaster.services;



import cn.springbootxianhualemaster.dao.CategoryMapper;
import cn.springbootxianhualemaster.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryMapper catemapper;
	@Override
	public List<Category> names() {
		
		return catemapper.names();
	}

}
