package com.letsrun.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;

public class ObjectMapperUtil {

	private static ObjectMapper mapper = null;

	public static ObjectMapper build() {
		if (mapper == null) {
			mapper = new ObjectMapper();
			mapper.registerModule(new JodaModule());
		}
		return mapper;
	}

}
