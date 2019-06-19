package cn.springbootxianhualemaster.services;


import cn.springbootxianhualemaster.dao.FlowersMapper;
import cn.springbootxianhualemaster.pojo.Flowers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("flowersService")
public class FlowersServiceImpl implements FlowersService {
	@Autowired
	private FlowersMapper flowersmapper;
	@Override
	public List<Flowers> names() {
		// TODO Auto-generated method stub
		return flowersmapper.names();
	}

}
