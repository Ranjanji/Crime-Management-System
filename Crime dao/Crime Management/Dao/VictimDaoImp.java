package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Utility.DButil;
import Dto.VictimsDto;
import Exceptions.VictimExceptions;
import Connection.ConnectionClass;

public class VictimDaoImp implements VictimDao{

	@Override
	public List<VictimsDto> getVictimsOfCrime(int crimeId) throws VictimExceptions {
		
		List<VictimsDto> victims = new ArrayList<>();
		
		try(Connection conn=DButil.ProvideConnection()){
			
			PreparedStatement ps =  conn.prepareStatement("select v.name, v.age, v.gender, v.address, c.description from victimsofcrime vc inner join crime c inner join victim v on vc.victimid = v.victimid and c.crimeid = vc.crimeid where c.crimeid = ?;");
			ps.setInt(1, crimeId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				String description = rs.getString("description");
				victims.add(new VictimsDto(name, age, gender, address, description));
			}
			if(victims.size()==0)
				throw new VictimExceptions("No victims found");
		}catch(SQLException e) {
			throw new VictimExceptions(e.getMessage());
		}
		return victims;
	}
	
}
