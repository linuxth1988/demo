package org.ith.t2013524;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class SpringDetector
{
	// use a Groundhog or class derived from Groundhog
	public static <T extends Dog> void detectSpring(Class<T> type) throws Exception
	{
		Constructor<T> ghog = type.getConstructor(int.class);
		Map<Dog, Prediction> map = new HashMap<Dog, Prediction>();

		for (int i = 0; i < 10; i++)
			map.put(ghog.newInstance(i), new Prediction());

		System.out.println("map = " + map);

		Dog gh = ghog.newInstance(3);

		System.out.println("looking up prdiction for " + gh);

		if (map.containsKey(gh))
			System.out.println(map.get(gh));
		else
			System.err.println("the Key not found: " + gh);
	}

	public static void main(String[] args) throws Exception
	{
		detectSpring(Dog.class);
	}
}
