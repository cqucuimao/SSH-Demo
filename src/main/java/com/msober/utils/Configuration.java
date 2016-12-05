package com.msober.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

	private static int pageSize = 10;		//默認顯示10條每頁

	static {
		InputStream in = null;
		try {
			
			Properties props = new Properties();
			in = Configuration.class.getClassLoader().getResourceAsStream("default.properties");
			props.load(in);

			pageSize = Integer.parseInt(props.getProperty("pageSize"));
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	public static int getPageSize() {
		return pageSize;
	}

	public static void setPageSize(int pageSize) {
		Configuration.pageSize = pageSize;
	}

}
