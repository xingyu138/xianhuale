package cn.springbootxianhualemaster.services;


import cn.springbootxianhualemaster.dao.PurposeMapper;
import cn.springbootxianhualemaster.pojo.Purpose;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("purposeService")
public class PurposeServiceImpl implements PurposeService {
	@Resource
	private PurposeMapper purposemapper;
	@Override
	public List<Purpose> names() {
		// TODO Auto-generated method stub
		return purposemapper.names();
	}

}
