package Driver_package;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import comman_Api_method.common_utility_method;

public class Dynamic_driverclass {

	public static void main(String[] args)
			throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		ArrayList<String> TestCasetoRun = common_utility_method.ReadDataExcel("Testcases", "tctoexecute");
		System.out.println(TestCasetoRun);

		int count = TestCasetoRun.size();
		for (int i=1; i<count; i++) 
		{
			String Testcasename = TestCasetoRun.get(i);
			System.out.println("Test case to execute is :" + Testcasename + ".");

			// call the testcaseclass on runtime by using java.lang.reflect package
			Class<?> testclassname=Class.forName("test_classes."+Testcasename);
			
			
			// call the execute method belonging to test class captured in variable
			// testclassname by using java.lang.reflect.method class
			Method executemethod = testclassname.getDeclaredMethod("extractor");

			// set the accessibility of method true
			executemethod.setAccessible(true);

			// create the instance of testclass captured in variable name testclassname
			Object instanceoftestclass = testclassname.getDeclaredConstructor().newInstance();

			// execute the testclass captured in variable name testclass name
			executemethod.invoke(instanceoftestclass);
		}

	}
}