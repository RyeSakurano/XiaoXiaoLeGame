package exception;

import java.io.*;

/* 防沉迷模式：
 * 限定30分钟后强制休息5分钟（正在进行的局可先完成）
 * 实现思路：
 * 记录上次开始的时间，在每局完结的时候比较，若不超过30分钟则可继续进行
 * 【可以添加的：图形界面的倒计时】
 * 记录休息开始的时间（初始值：1970年1月1日0:00）【要用文件记录】，每局开始时比较，若超过5分钟可允许开始，并修改开始、休息时间
 */

/* main函数调用：
 * main() {
 * 		Addiction.init();
 * 		while (true) {
 * 			Addiction.rest(Addiction.judgeRest());
 * 			basePlay();
 * 			if (Addiction.judgePlay())
 * 				Addiction.rest(PLAY);
 * 		}
 * 	}
 */
public class Addiction {
	public static final long REST = 300000L;
	public static final long PLAY = 1800000L;
	private static long game_begin_time = -1L;
	private static long rest_begin_time = 0L;
	
	/* 加在main函数的开始 */
	public static void init() {
		try {
			File f = new File("rest.txt");
			if (!f.exists()) {
				DataOutputStream fout = new DataOutputStream(new FileOutputStream("rest.txt"));
				fout.writeLong(0);
				fout.close();
			}
		} catch (IOException e) {
		}
	}
	
	
	public static void rest(long t) {
		try {
			Thread.sleep(t);
		} catch (Exception e) {
			System.exit(0);
		}
	}
	
	/* 计算休息剩余时间（毫秒） */
	public static long judgeRest() {
		/* 载入真实的休息开始时间，避免重启开挂 */
		while (game_begin_time < 0L) {
			try {
				DataInputStream fin = new DataInputStream(new FileInputStream("rest.txt"));
				rest_begin_time = fin.readLong();
				fin.close();
			} catch (IOException e) {
			}	
		}
		
		long curTime = System.currentTimeMillis();
		/* 休息完成 */
		if (curTime - rest_begin_time > REST) {
			game_begin_time = curTime;
			rest_begin_time = 0;
			try {
				DataOutputStream fout = new DataOutputStream(new FileOutputStream("rest.txt"));
				fout.writeLong(rest_begin_time);
				fout.close();
			} catch (IOException e) {
			}
			return 0L;
		}
		/* 还要休息 */
		else {
			return REST - curTime + rest_begin_time;
		}
	}
	
	/* 判断是否需要休息 */
	public static boolean judgePlay() {
		long curTime = System.currentTimeMillis();
		if (curTime - game_begin_time > PLAY) {
			rest_begin_time = curTime;
			try {
				DataOutputStream fout = new DataOutputStream(new FileOutputStream("rest.txt"));
				fout.writeLong(rest_begin_time);
				fout.close();
			} catch (IOException e) {
			}
			return true;
		}
		else {
			return false;
		}
	}
}