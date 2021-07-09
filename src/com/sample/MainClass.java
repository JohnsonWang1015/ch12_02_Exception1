package com.sample;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		do {
			// catch() 內，子類別寫前方，父類別寫後方
			try {
				System.out.print("輸入被除數 a = ");
				int a = scanner.nextInt();
				System.out.print("輸入除數 b = ");
				int b = scanner.nextInt();
				int c = a / b;
				System.out.printf("%d / %d = %d%n", a, b, c);
				break;
			} catch(ArithmeticException ex) {	// 子類別 
				System.out.println("事情大條了，除數不可為 0!");
				System.out.println("[異常]" + ex);
				//ex.printStackTrace();
				
			} catch(InputMismatchException ex) {	// 子類別
				System.out.println("[異常] 輸入資料格式錯誤");
				//ex.printStackTrace();
				scanner.nextLine(); // 清空
				
			} catch(Exception ex) {	// 父類別
				System.out.println("其他異常...");
			} finally {
				System.out.println("finally{}...");
			}
		}while(true);
		
		System.out.println("-----------------------");
		
		System.out.println("6 / 2 => " + myDiv(6, 2));
		System.out.println("8 / 0 => " + myDiv(8, 0));
		System.out.println("9 / 4 => " + myDiv(9, 4));
		
	}
	
	private static int myDiv(int a, int b) {
		if(b == 0) {
			System.out.println("除數為 0 異常發生!");
			return 0;
		}
		return a / b;
	}

}

/*
 * Throwable：(1)Error (2)Exception
 * UnChecked Exception：RuntimeException => ArithmeticException...
 * Checked Exception：除了 RuntimeException 及 Error 外都是 Checked Exception (ex:SQLException)
 * 
 * try-catch {} 例外處理
 */
