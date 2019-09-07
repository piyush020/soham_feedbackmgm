package com.cg.fms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cg.fms.dto.FacultySkill;
import com.cg.fms.exception.FMSException;
import com.cg.fms.util.DBUtil;

public class FacultySkillDaoImpl implements FacultySkillDao {

	Connection con = DBUtil.getConnection();
	ResultSet rs = null;
	PreparedStatement ps = null;
	Statement  st = null;
	
	@Override
	public FacultySkill getFacultySkillById(int id) throws FMSException {

		String qry = "select * from faculty_skill where faculty_id=?";
		FacultySkill fs =null;
		try 
		{
			ps = con.prepareStatement(qry);
			ps.setInt(id, 1);
			rs = ps.executeQuery();
			if(rs.next())
			{
				int fId = rs.getInt(1);
				String skill = rs.getString(2);
				fs = new FacultySkill(fId, skill);
			}
		} 
		catch (SQLException e)
		{
			throw new FMSException(e.getMessage());
		}
		
		
		return fs;
	}

	@Override
	public ArrayList<FacultySkill> getAllFacultySkills() throws FMSException {
		
		String qry = "select * from faculty_skill";
		ArrayList<FacultySkill> list = new ArrayList<FacultySkill>();
		try
		{
			st = con.createStatement();
			rs = st.executeQuery(qry);
			while (rs.next()) {
				int id = rs.getInt(1);
				String skill = rs.getString(2);
				FacultySkill fs = new FacultySkill(id, skill);
				list.add(fs);
			}
		}
		catch (SQLException e)
		{
			throw new FMSException(e.getMessage());
		}

		return list;
	}

	@Override
	public FacultySkill addFacultySkill(FacultySkill facultySkill)
			throws FMSException {
		
		String qry = "insert into faculty_skill values(?,?)";
		FacultySkill fs = null;
		try
		{
			ps = con.prepareStatement(qry);
			ps.setInt(1, facultySkill.getFacultyId());
			ps.setString(2, facultySkill.getSkillSet());
			int add = ps.executeUpdate();
			if(add > 0)
			{
				fs = facultySkill;
			}
		}
		catch (SQLException e) 
		{
			throw new FMSException(e.getMessage());
		}
		
		return fs;
	}

	@Override
	public FacultySkill updateFacultySkill(FacultySkill facultySkill)
			throws FMSException {
		String qry ="update faculty_skill set skill_set=? where faculty_id=?";
		FacultySkill fs = null;
		try 
		{
			ps = con.prepareStatement(qry);
			ps.setInt(1, facultySkill.getFacultyId());
			ps.setString(2, facultySkill.getSkillSet());
			int updated = ps.executeUpdate();
			if(updated > 0)
			{
				fs = facultySkill;
			}
		} 
		catch (SQLException e) 
		{
			throw new FMSException(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean deleteFacultySkill(int id) throws FMSException {
		
		String qry = "delete from faculty_skill where faculty_id=?";
		boolean flag = false;
		try 
		{
			ps= con.prepareStatement(qry);
			ps.setInt(1, id);
			int deleted = ps.executeUpdate();
			if(deleted > 0)
			{
				flag = true;
			}
			
		} 
		catch (SQLException e) 
		{
			throw new FMSException(e.getMessage());
		}
		
		return flag;
	}

}
