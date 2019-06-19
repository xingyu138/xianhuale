package cn.springbootxianhualemaster.services;

import cn.springbootxianhualemaster.dao.ColorMapper;
import cn.springbootxianhualemaster.pojo.Color;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("colorService")
public class ColorServiceImpl implements ColorService {
	@Autowired
	private ColorMapper colormapper;
	@Override
	public List<Color> names() {
		// TODO Auto-generated method stub
		return colormapper.names();
	}

}
