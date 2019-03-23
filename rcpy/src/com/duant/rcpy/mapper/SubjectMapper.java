package com.duant.rcpy.mapper;

import java.util.List;

import com.duant.rcpy.domain.Subject;

public interface SubjectMapper {
	Subject selectSubjectByName(String subjectname);
	
	Subject selectByPrimaryKey(Integer subjectid);
	
	List<Subject> selectAllSubject();
	
	
}
