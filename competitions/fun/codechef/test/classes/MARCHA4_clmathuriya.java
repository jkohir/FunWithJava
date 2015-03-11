package fun.codechef.test.classes;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MARCHA4_clmathuriya {

	public static List<String> firstKList = new ArrayList<String>(30000);
	public static List<String> lastKList = new ArrayList<String>(30000);
	public static List<Integer> numbers = new ArrayList<Integer>(30000);
	
	static int testCount;

	static BufferedOutputStream out;

	static int modValue = 1000000000;

	static byte[] spaceb;

	static byte[] eolb;

	public class Big {

		long a;

		long b;

		long c;

		public Big(long x, long y, long z) {

			a = x;

			b = y;

			c = z;

		}

	}

	public static Big multiply(Big p, Big q) {

		long p1 = p.a * q.a;

		long p2 = p.a * q.b + p.b * q.a;

		long p3 = p.a * q.c + p.b * q.b + p.c * q.a;

		long p4 = p.b * q.c + p.c * q.b;

		long p5 = p.c * q.c;

		p4 += p5 / modValue;

		p3 += p4 / modValue;

		p2 += p3 / modValue;

		p1 += p2 / modValue;

		long p0 = p1 / modValue;

		p1 %= modValue;

		p2 %= modValue;

		p3 %= modValue;

		p4 %= modValue;

		p5 %= modValue;

		if (p0 > 0) {

			return main.new Big(p0, p1, p2);

		} else if (p1 > 0) {

			return main.new Big(p1, p2, p3);

		} else if (p2 > 0) {

			return main.new Big(p2, p3, p4);

		} else if (p3 > 0) {

			return main.new Big(p3, p4, p5);

		} else if (p4 > 0) {

			return main.new Big(p4, p5, 0);

		} else {

			return main.new Big(p5, 0, 0);

		}

	}

	static MARCHA4_clmathuriya main;

	public static void main(String[] args) throws Exception {

		execute();

	}

	public static long execute() throws Exception {
		 long startTime = System.nanoTime();
	    firstKList.clear();
	    lastKList.clear(); 
		main = new MARCHA4_clmathuriya();
		FileInputStream fileIn = new FileInputStream(new File("D:\\Google Drive\\Books\\My code musings\\Codechef\\MARCHA4\\MARCHA4-random-input.txt"));
		InputStreamReader fileInStream = new InputStreamReader(fileIn);
//		InputStreamReader fileInStream = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(fileInStream);

		out = new BufferedOutputStream(System.out);

		spaceb = " ".getBytes();

		String eol = System.getProperty("line.separator");

		eolb = eol.getBytes();

		try {

			String str = br.readLine();

			testCount = Integer.parseInt(str);

			for (int i = 0; i < testCount; i++) {

				str = br.readLine();

				int spaceIndex = str.indexOf(new String(" "));

				String str1 = str.substring(0, spaceIndex);

				str = str.substring(spaceIndex + 1, str.length());

				int a = Integer.parseInt(str1);
				numbers.add(a);

				int b = Integer.parseInt(str);

				outputFirstK(a, b);

				outputLastK(a, b);

			}

			out.flush();

		} catch (IOException ioe) {

			ioe.printStackTrace();

		}

		 long end = System.nanoTime();

		// System.err.println("time takne = " + (end-startTime));
		 return end-startTime;
	}

	public static void outputFirstK(int n, int k) throws Exception {

		Big b = getPow(n);

		String str1 = new Long(b.a).toString();

		String str2 = new Long(b.b).toString();

		while (str2.length() < 9) {

			str2 = "0".concat(str2);

		}

		String str = str1.concat(str2).substring(0, k);
		firstKList.add(str);
//		out.write(str.getBytes());

		;

//		out.write(spaceb);

	}

	public static Big getPow(int n) {

		Big a = main.new Big(n, 0, 0);

		Big ans = main.new Big(1, 0, 0);

		Big pow = a;

		while (n > 0) {

			if ((n % 2) == 1) {

				ans = multiply(ans, pow);

			}

			pow = multiply(pow, pow);

			n /= 2;

		}

		return ans;

	}

	public static void outputLastK(int n, int k) throws Exception {

		long sp = new Double(Math.pow(10, k)).longValue();

		long result = getPow(n, n, sp);

		String x = new Long(result).toString();

		while (x.length() < k) {

			x = "0".concat(x);

		}
		lastKList.add(x);
//		out.write(x.getBytes());

//		out.write(eolb);

	}

	public static long getPow(long a, long b, long sp) {

		long ans = 1;

		long pow = a;

		while (b > 0) {

			if ((b % 2) == 1) {

				ans *= pow;

				ans %= sp;

			}

			pow *= pow;

			pow %= sp;

			b /= 2;

		}

		return ans;

	}

}
