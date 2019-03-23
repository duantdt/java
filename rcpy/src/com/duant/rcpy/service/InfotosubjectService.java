package com.duant.rcpy.service;

import java.util.List;

import com.duant.rcpy.domain.Infotosubject;

public interface InfotosubjectService {
	/**
	 * 插入
	 * @param its
	 * @return
	 */
	public int insert(Infotosubject its);
	
	/**
	 * 通过infoid 和subjectid 删除此科目
	 * @param infoid
	 * @param subjectid
	 * @return
	 */
	int deleteByPrimaryKey(Integer infoid,Integer subjectid);
	
	
	/**
	 * 通过
	 * @param Infotosubject更新
	 * @return
	 */
	int updateByPrimaryKey(Infotosubject its);
	
	/**
	 * 通过infoid查询所有Infotosubject
	 * @param infoid
	 * @return
	 */
	List<Infotosubject> selectAllByPrimaryKey(Integer infoid);
	
	/**
	 * 通过infoid 和 semester 查询所有subjectid
	 * @param infoid
	 * @param semester
	 * @return
	 */
	List<Integer> selectSubjectIdByPrimaryKey(Integer infoid,Integer semester);
	
	/**
	 * 查询Infotosubject
	 * @param infoid
	 * @param subjectid
	 * @return
	 */
	Infotosubject selectSubjectIdByIAndS(Integer infoid,Integer subjectid);
	
}
