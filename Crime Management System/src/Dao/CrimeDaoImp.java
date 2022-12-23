package Dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Utility.DButil;

import Dto.CrimesDoneByCriminalDto;
import Exceptions.CrimeExceptions;
import Bean.Crime;
import Connection.ConnectionClass;

public class CrimeDaoImp implements Crimedao{
	//Resister the crime
	@Override
	public String registerCrime(String dateofcrime,String description,int policeStationId,
			   String detailDescription,String status) throws CrimeExceptions{
	
		String message = "Not Inserted..";
		try(Connection conn=DButil.ProvideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("insert into crime(dateofcrime,description,policeStationId,detailDescription,status) values(?,?,?,?,?)");
	
			ps.setString(1, dateofcrime);
			ps.setString(2, description);
			ps.setInt(3, policeStationId);
			ps.setString(4, detailDescription);
			ps.setString(5, status);
			
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "Crime Registered Sucessfully !";
		
		} catch (SQLException e) {
			message = e.getMessage();
		}	
		return message;
	}
	
	//Get all Crime List
	public List<Crime> getAllCrimes()throws CrimeExceptions{
		List<Crime> crimes = new ArrayList<>();
		
		try(Connection conn=DButil.ProvideConnection()){
			PreparedStatement st = conn.prepareStatement("select * from crime");
			ResultSet rs =  st.executeQuery();
			while(rs.next()) {
				int crimeId = rs.getInt("crimeid");
				Date date = rs.getDate("dateofcrime");
				String desc = rs.getString("description");
				String detailDesc = rs.getString("detailDescription");
				int policeStationId = rs.getInt("policestationid");
				String status = rs.getString("status");
				crimes.add(new Crime(crimeId, desc, policeStationId,detailDesc, status,date));
			}
			if(crimes.size()==0)
				throw new CrimeExceptions("No records present");
		}catch(SQLException e) {
			throw new CrimeExceptions(e.getMessage());
		}
		return crimes;
	}

    //Get List of Crimes of Criminal list
	@Override
	public List<CrimesDoneByCriminalDto> getCrimesOfACriminal(int criminalId) throws CrimeExceptions {
		
		List<CrimesDoneByCriminalDto> crimes = new ArrayList<>();
		
		try(Connection conn = ConnectionClass.getConnection()){
			PreparedStatement ps =  conn.prepareStatement("select cr.name, c.dateofcrime, c.description, c.detailDescription from criminalsofcrime coc inner join criminal cr inner join crime c on coc.criminalid = cr.criminalid and coc.crimeid = c.crimeid where cr.criminalid=?;");
			ps.setInt(1, criminalId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				Date dateOfCrime = rs.getDate("dateofcrime");
				String description = rs.getString("description");
				String detailDesc = rs.getString("detailDescription");
				crimes.add(new CrimesDoneByCriminalDto(dateOfCrime,name, description, detailDesc));
			}
			if(crimes.size()==0) {
				throw new CrimeExceptions("No Crimes Found");
			}
		}catch(SQLException e) {
			throw new CrimeExceptions(e.getMessage());
		}
		return crimes;
	}
}
