package Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Dto.CriminalArrestedDto;
import Dto.CriminalsCrimeDto;

import Bean.Criminal;
import Utility.DButil;
import Connection.ConnectionClass;

import Exceptions.CriminalExceptions;

public class CriminalDaoImp implements CriminalDao{
	//Resister the crime
	@Override
	public String registerCriminal(String name,int age,String gender,String address,
			int policeStationId,String mark) throws CriminalExceptions{
		String message = "Not Inserted..";
		try(Connection conn=DButil.ProvideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("insert into criminal(name,age,gender,address,policeStationId,mark) values(?,?,?,?,?,?)");
	
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, gender);
			ps.setString(4,address);
			ps.setInt(5, policeStationId);
			ps.setString(6,mark);
			
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "Criminal Registered Sucessfully !";
		
		} catch (SQLException e) {
			message = e.getMessage();
		}	
		return message;
	}

	//Get all Criminals List
	@Override
	public List<Criminal> getAllCriminals() throws CriminalExceptions {
		
		List<Criminal> criminals = new ArrayList<>();
		
		try(Connection conn = ConnectionClass.getConnection()){
			PreparedStatement ps =  conn.prepareStatement("select * from criminal");
			ResultSet rs =  ps.executeQuery();
			while(rs.next()) {
				int criminalId = rs.getInt("criminalid");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				String mark = rs.getString("mark");
				int policeStationId = rs.getInt("policeStationId");
				criminals.add(new Criminal(name, age, gender, address, mark, policeStationId));
			}
			if(criminals.size()==0)
				throw new CriminalExceptions("No criminals found");
		}catch(SQLException e) {
			throw new CriminalExceptions(e.getMessage());
		}
		
		return criminals;
	}

	//Get list of Criminals arrested before
	@Override
	public List<CriminalArrestedDto> getCriminalsArrestedBefore() throws CriminalExceptions {
		
		List<CriminalArrestedDto> criminals = new ArrayList<>();
		
		try(Connection conn=DButil.ProvideConnection()){    
			PreparedStatement ps =  conn.prepareStatement("select name, age, gender, address, mark, policestationname from criminal cr inner join police_station ps on cr.policeStationId = ps.policestationid;");
			ResultSet rs =  ps.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				String mark = rs.getString("mark");
				String policeStationName = rs.getString("policestationname");
				criminals.add(new CriminalArrestedDto(name, age, gender, address, mark, policeStationName));
			}
			if(criminals.size()==0)
				throw new CriminalExceptions("No criminals found");
		}catch(SQLException e) {
			throw new CriminalExceptions(e.getMessage());
		}
		
		return criminals;
	}

	//Get list of Criminal's crime
	@Override
	public List<CriminalsCrimeDto> getCriminalsForCrime(int crimeId) throws CriminalExceptions {
		
		List<CriminalsCrimeDto> criminals = new ArrayList<>();
		
		try(Connection conn = ConnectionClass.getConnection()){
			PreparedStatement ps = conn.prepareStatement("select cr.name, cr.age, cr.gender, cr.address, cr.mark, c.description from criminalsofcrime coc inner join criminal cr inner join crime c on coc.criminalid = cr.criminalid and coc.crimeid = c.crimeid where c.crimeid = ?;");
			ps.setInt(1, crimeId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				String mark = rs.getString("mark");
				String description = rs.getString("description");
				criminals.add(new CriminalsCrimeDto(name, age, gender, mark,address, description));
			}
			if(criminals.size()==0)
				throw new CriminalExceptions("No criminals found");
		}catch(SQLException e) {
			throw new CriminalExceptions(e.getMessage());
		}
		return criminals;
	}
	
	

}