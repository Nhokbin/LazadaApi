package com.dav.lazada.connect;

import java.util.logging.Logger;

public class DBService {
	private static final Logger LOGGER = Logger.getLogger("DBService");

	static{
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			LOGGER.severe("Cant load driver for JDBC");
		}
	}
}
