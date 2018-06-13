package com.saven.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class GapsIndexRowMapper implements RowMapper<GapsIndex> {

	@Override
	public GapsIndex mapRow(ResultSet row, int rowNum) throws SQLException {
		GapsIndex gap = new GapsIndex();
		gap.setMinute(row.getLong("minute"));
		gap.setFlavor(row.getString("flavor"));
		gap.setFeed(row.getString("feed"));
		gap.setRecv(row.getLong("recv"));
		gap.setMiss(row.getLong("miss"));
		gap.setFill(row.getLong("fill"));
		return gap;
	}

}
