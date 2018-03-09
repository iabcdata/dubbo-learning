package io.iabc.common.utils;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

public class AssertUtils {
	public static boolean isNull(Object obj) {
		if (obj == null)
			return true;
		if(obj instanceof Collection)
			return ((Collection) obj).isEmpty();
		if(obj instanceof Array)
			return Array.getLength(obj) == 0;
		if(obj instanceof Map)
			return ((Map) obj).isEmpty();
		return false;
	}
}
