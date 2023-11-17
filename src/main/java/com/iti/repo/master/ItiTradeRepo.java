package com.iti.repo.master;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iti.entity.master.ItiTrade;
import com.iti.projections.UniversalProjection;

public interface ItiTradeRepo extends JpaRepository<ItiTrade, Integer>{
	
	
	@Query(value = "select iti_code as colNo1,b.trade_name as colNo2,cast(a.strength as character varying) as colNo3 from \r\n" + 
			"ititrade a inner join ititrade_master b on a.trade_code = b.trade_code ",nativeQuery = true)
	public List<UniversalProjection> getItiProfilesWithTradeAndStrength();

}
