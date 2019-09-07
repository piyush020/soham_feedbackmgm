package com.cg.fms.service;

import java.util.ArrayList;

import com.cg.fms.dao.FacultySkillDao;
import com.cg.fms.dao.FacultySkillDaoImpl;
import com.cg.fms.dto.FacultySkill;
import com.cg.fms.exception.FMSException;

public class FacultySkillServiceImpl implements FacultySkillService{

	FacultySkillDao dao = new FacultySkillDaoImpl();
	
	@Override
	public FacultySkill getFacultySkillById(int id) throws FMSException
	{
		return dao.getFacultySkillById(id);
	}

	@Override
	public ArrayList<FacultySkill> getAllFacultySkills() throws FMSException 
	{
		return dao.getAllFacultySkills();
	}

	@Override
	public FacultySkill addFacultySkill(FacultySkill facultySkill)
			throws FMSException 
	{
		return dao.addFacultySkill(facultySkill);
	}

	@Override
	public FacultySkill updateFacultySkill(FacultySkill facultySkill)
			throws FMSException
	{
		return dao.updateFacultySkill(facultySkill);
	}

	@Override
	public boolean deleteFacultySkill(int id) throws FMSException 
	{
		return dao.deleteFacultySkill(id);
	}

}
