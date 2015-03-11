/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fun.codechef.competitors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 *
 * @author Juned
 */

/*
Example
Input:
2
AbcDef
1 2
aaaaaaaaa
5 5

Output:
4
3
*/

 class Main implements Runnable {

 

	private void solve() throws IOException {

		String S = this.nextToken();

		int M = this.nextInt();

		int P = this.nextInt();

		int[] next = getnext( S );

		int len = S.length();

		int loop = len - next[len];

		if( len % loop != 0 )

			loop = len;

		
		int sum = 0;

		for( int i = 0; i < len + len; i ++ ){

			if ( i % 2 == 0 )

				sum += M;

			else

				sum += P;

			sum %= len;

			if ( sum % loop == 0 ){

				System.out.println( i + 1 );

				return;

			}

		}

	}

 

	private int[] getnext(String str) {

		// TODO Auto-generated method stub

		int i = -1, j = 0;

		int len = str.length();

		int[] next = new int[ len + 1 ];

		next[0] = -1;

		while( j < len )

			if ( i == -1 || str.charAt( i ) == str.charAt( j ) ){

				i ++;

				j ++;

				next[j] = i;

			}

			else

				i = next[i];

		return next;

	}

 

	public static void main(String[] args) {

		new Main().run();

	}

 

	BufferedReader reader;

	StringTokenizer tokenizer;

	PrintWriter writer;

 

	public void run() {

		try {

			reader = new BufferedReader(new InputStreamReader(System.in));

			tokenizer = null;

			writer = new PrintWriter(System.out);

			int t = this.nextInt();

			for ( int i = 0; i < t; i ++ )

				solve();

			reader.close();

			writer.close();

		} catch (Exception e) {

			//e.printStackTrace();

			System.exit(0);

		}

	}

 

	boolean hasNext() throws IOException {

		while (tokenizer == null || !tokenizer.hasMoreTokens()) {

			String nextLine = reader.readLine();

			if (nextLine == null)

				return false;

			tokenizer = new StringTokenizer(nextLine);

		}

 

		return true;

	}

 

	int nextInt() throws IOException {

		return Integer.parseInt(nextToken());

	}

 

	long nextLong() throws IOException {

		return Long.parseLong(nextToken());

	}

 

	double nextDouble() throws IOException {

		return Double.parseDouble(nextToken());

	}

 

	String nextLine() throws IOException {

		return reader.readLine();

	}

	String nextToken() throws IOException {

		while (tokenizer == null || !tokenizer.hasMoreTokens()) {

			tokenizer = new StringTokenizer(reader.readLine());

		}

 

		return tokenizer.nextToken();

	}

 

	BigInteger nextBigInteger() throws IOException {

		while (tokenizer == null || !tokenizer.hasMoreTokens()) {

			tokenizer = new StringTokenizer(reader.readLine());

		}

 

		return new BigInteger(tokenizer.nextToken());

	}

}

