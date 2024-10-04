public class SumFloat {
	public static void main(String[] args) {
		float sum = 0;
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
	
	private static float addToSum(StringBuilder number, float sum) {
        if (!number.isEmpty()) {
            sum += Float.parseFloat(number.toString());
            number.setLength(0);  
        }
        return sum;
	}
}

	