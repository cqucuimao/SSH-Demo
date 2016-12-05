package com.msober.xmldata;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.dbunit.DatabaseUnitException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.msober.base.BaseTest;
import com.msober.utils.TestUtils;

public class CreateUserXmlData extends BaseTest{
	
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void createUserInsertData() throws FileNotFoundException, SQLException, DatabaseUnitException, IOException {
		List<String> tables = new ArrayList<String>();
		tables.add("user");
		tables.add("role");
		tables.add("customer");
		TestUtils.exportData(dataSource.getConnection(), tables, "D:\\user_inserts.xml");
	}
}
