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
	public List<Crime> getAllCrimes()throws CrimeExceptions{
		List<Crime> crimes = new ArrayList<>();
		
		try(Connection conn=DButil.ProvideConnection()){
			PreparedStatement st = conn.prepareStatement("select * from crime");
			ResultSet rs =  st.executeQuery();
			while(rs.next()) {
				int crimeId = rs.getInt("crimeid");
				Date date = rs.getDate("dateofcrime");
				String desc = rs.getString("description");
				String detailDesc = rs.getString("detail_desc");
				int areaId = rs.getInt("areaid");
				int policeStationId = rs.getInt("policestationid");
				String status = rs.getString("status");
				crimes.add(new Crime(areaId, desc, policeStationId,detailDesc, status,date));
			}
			if(crimes.size()==0)
				throw new CrimeExceptions("No records present");
		}catch(SQLException e) {
			throw new CrimeExceptions(e.getMessage());
		}
		return crimes;
	}

	@Override
	public List<CrimesDoneByCriminalDto> getCrimesOfACriminal(int criminalId) throws CrimeExceptions {
		
		List<CrimesDoneByCriminalDto> crimes = new ArrayList<>();
		
		try(Connection conn = ConnectionClass.getConnection()){
			PreparedStatement ps =  conn.prepareStatement("select cr.name, c.dateofcrime, c.description, c.detail_desc from criminalsofcrime coc inner join criminal cr inner join crime c on coc.criminalid = cr.criminalid and coc.crimeid = c.crimeid where cr.criminalid=?;");
			ps.setInt(1, criminalId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				Date dateOfCrime = rs.getDate("dateofcrime");
				String description = rs.getString("description");
				String detailDesc = rs.getString("detail_desc");
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
