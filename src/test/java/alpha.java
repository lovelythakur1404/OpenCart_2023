import org.apache.commons.lang3.RandomStringUtils;

public class alpha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		alpha a = new alpha();
		String result = a.rendomalpha();
		System.out.println(result);

	}

	public String rendomalpha() // return randome string
	{
		String genetratealph = RandomStringUtils.randomAlphanumeric(10);
		return (genetratealph);
	}

}
