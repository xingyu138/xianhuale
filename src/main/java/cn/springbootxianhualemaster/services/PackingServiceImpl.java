package cn.springbootxianhualemaster.services;


import cn.springbootxianhualemaster.dao.PackingMapper;
import cn.springbootxianhualemaster.pojo.Packing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("packingService")
public class PackingServiceImpl implements PackingService {
	@Autowired
	private PackingMapper packingmapper;
	@Override
	public List<Packing> names() {
		// TODO Auto-generated method stub
		return packingmapper.names();
	}

}
