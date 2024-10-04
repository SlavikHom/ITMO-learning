public class Sum {
	public static void main(String[] args) {
		int sum = 0;
		StringBuilder number = new StringBuilder();
		for (int j = 0; j < args.length; j++) {
			String probablyNumbers = args[j];
			for (int i = 0; i < probablyNumbers.length(); i++) {
				char digit = probablyNumbers.charAt(i);
				if (!Character.isWhitespace(digit)) {
					number.append(digit);
				} else {
					sum = addToSum(number, sum);
				}
			}
		sum = addToSum(number, sum);
		}
		System.out.println(sum);
	}
	
	private static int addToSum(StringBuilder number, int sum) {
        if (!number.isEmpty()) {
            sum += Integer.parseInt(number.toString());
            number.setLength(0);  
        }
        return sum;
	}
}

	