/*
 * Rise and fall of power
 */
package fun.codechef.test.classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MARCHA4 {
	public static List<String> firstKList = new ArrayList<String>(30000);
	public static List<String> lastKList = new ArrayList<String>(30000);
	public static List<Integer> numbers = new ArrayList<Integer>(30000);
	
	public static void main(String[] args) throws IOException {
		execute();
	}

	public static long execute() throws IOException {
		firstKList.clear();
		lastKList.clear();
		long start = System.nanoTime();
		FileInputStream fileIn = new FileInputStream(new File("D:\\Google Drive\\Books\\My code musings\\Codechef\\MARCHA4\\MARCHA4-random-input.txt"));
		Scanner scanner = new Scanner(fileIn);
//		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for(int i=0; i<t; i++){
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			numbers.add(n);
			firstK(n, k);
			lastKDigits(n, k);
		}
		scanner.close();
		long end = System.nanoTime();
//		System.out.println("Your program completed in: "+(end-start)/1000000 + " ms");
//		long result = 999999999L * 999999999L;
//		result = (result * result)%(long)Math.pow(10, 18);
//		System.out.println(result);
//		System.out.println(getDigitCount(BigInteger.valueOf(1234567890123456789L)));
		return (end-start);
	}

	private static void firstKDigits(int n, int k) throws IOException {
		double logVal = Math.log10(n);
		BigDecimal logBD = new BigDecimal(logVal);
		logBD.setScale(20, RoundingMode.HALF_UP);
		logBD = logBD.multiply(new BigDecimal(n));
		logBD = logBD.subtract(new BigDecimal(logBD.longValueExact()));
		logBD = logBD.add(new BigDecimal(k-1));
		double exponential = logVal-Math.floor(logVal)+k-1;
		long result = (long)Math.pow(10, exponential);
		System.out.println(result);
	}
	
	private static void firstK(int n, int k) throws IOException{
		int digits = (""+n).length();
		int maxDigitsNeeded = k+digits;
		long result = fastExponentiation(new BigInteger(""+n),new BigInteger(""+n), maxDigitsNeeded);
		digits = (""+result).length();
		long divisor = (long)Math.pow(10, digits-k);
		result = result/divisor;
		firstKList.add(result+"");
//		System.out.print(result);
	}

	// calculates x^n mod divisor
	private static long fastExponentiation(BigInteger x, BigInteger n, int maxDigitsNeeded) {
		if (n.compareTo(BigInteger.ONE) == 0)
			return x.longValueExact();
		long divisor = 1;
		if (n.mod(BigInteger.valueOf(2)).compareTo(BigInteger.ZERO) == 0) {
			x = x.multiply(x);
			int digits = getDigitCount(x);
			if (digits > maxDigitsNeeded) {
				divisor = (long) Math.pow(10, digits - maxDigitsNeeded);
			}
			x = x.divide(BigInteger.valueOf(divisor));
			return fastExponentiation(x, n.divide(BigInteger.valueOf(2)), maxDigitsNeeded);
		} else {
			BigInteger temp = x.multiply(x);
			int digits = getDigitCount(temp);
			if (digits > maxDigitsNeeded) {
				divisor = (long) Math.pow(10, digits - maxDigitsNeeded);
			}
			temp = temp.divide(BigInteger.valueOf(divisor));
			long result = fastExponentiation(temp, n.subtract(BigInteger.ONE).divide(BigInteger.valueOf(2)), maxDigitsNeeded);
			// System.out.println(result);
			divisor = 1;
			x = x.multiply(BigInteger.valueOf(result));
			digits = getDigitCount(x);
			if (digits > 18) {
				divisor = (long) Math.pow(10, digits - 18);
			}
			x = x.divide(BigInteger.valueOf(divisor));
			return x.longValueExact();
		}
	}

	private static int getDigitCount(BigInteger number) {
	  double factor = Math.log(2) / Math.log(10);
	  int digitCount = (int) (factor * number.bitLength() + 1);
	  if (BigInteger.TEN.pow(digitCount - 1).compareTo(number) > 0) {
	    return digitCount - 1;
	  }
	  return digitCount;
	}
	
	private static void lastKDigits(int n, int k) throws IOException {
		long divisor = (long)Math.pow(10, k);
//		Long result = 1L;
//		for (int i = 0; i < n; i++) {
//			result=(result*n)%divisor;
//			if(result == 1 || result == 0){
//				result = result*n%divisor;
//				break;
//			}
//		}
		BigInteger bigN = BigInteger.valueOf(n);
		bigN = bigN.modPow(bigN, BigInteger.valueOf(divisor));
		StringBuilder resultStr = new StringBuilder(bigN.toString());
		while(resultStr.length()<k){
			resultStr.replace(0, 0, "0");
		}
		lastKList.add(resultStr.toString());
//		System.out.println(resultStr.replace(0, 0, " "));
	}

}
