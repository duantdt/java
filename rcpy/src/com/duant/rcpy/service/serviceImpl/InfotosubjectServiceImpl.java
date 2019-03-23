package com.duant.rcpy.service.serviceImpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.duant.rcpy.domain.Infotosubject;
import com.duant.rcpy.mapper.InfotosubjectMapper;
import com.duant.rcpy.service.InfotosubjectService;

@Transactional
@Service
public class InfotosubjectServiceImpl implements InfotosubjectService,Serializable {

	
	private static final long serialVersionUID = -1854021752940406377L;
	@Autowired
	private InfotosubjectMapper infotosubjectMapper;
	
	@Override
	public int insert(Infotosubject its) {
		return infotosubjectMapper.insert(its);
	}

	@Override
	public int deleteByPrimaryKey(Integer infoid,Integer subjectid) {
		return infotosubjectMapper.deleteByPrimaryKey(infoid, subjectid);
	}

	@Override
	public int updateByPrimaryKey(Infotosubject its) {
		return infotosubjectMapper.updateByPrimaryKey(its);
	}

	@Override
	public List<Infotosubject> selectAllByPrimaryKey(Integer infoid) {
		return infotosubjectMapper.selectAllByPrimaryKey(infoid);
	}

	@Override
	public List<Integer> selectSubjectIdByPrimaryKey(Integer infoid, Integer semester) {
		return infotosubjectMapper.selectSubjectIdByPrimaryKey(infoid, semester);
	}

	@Override
	public Infotosubject selectSubjectIdByIAndS(Integer infoid, Integer subjectid) {
		return infotosubjectMapper.selectSubjectIdByIAndS(infoid, subjectid);
	}

}
