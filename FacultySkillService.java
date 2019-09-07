package com.cg.fms.service;

import java.util.ArrayList;

import com.cg.fms.dto.FacultySkill;
import com.cg.fms.exception.FMSException;

public interface FacultySkillService {
	
	public FacultySkill getFacultySkillById(int id) throws FMSException;  
	public ArrayList<FacultySkill> getAllFacultySkills() throws FMSException;
	public FacultySkill addFacultySkill(FacultySkill facultySkill) throws FMSException;
	public FacultySkill updateFacultySkill(FacultySkill facultySkill) throws FMSException;
	public boolean deleteFacultySkill(int id) throws FMSException;


}
