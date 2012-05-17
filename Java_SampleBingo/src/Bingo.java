import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

/**
 * ビンゴの抽選部分プログラム
 *
 * @author kononushi
 *
 */
public class Bingo {

	//フォークしたプロジェクトから書き込み

	static boolean endFlag; // プログラムの終了を判定するフラグ
	static ArrayList<Integer> bingoNumber; // ビンゴの抽選番号を格納するリスト
	static Vector<Integer> bingoNumber2; // ビンゴの抽選結果を格納するリスト
	static int ball; // 何番目のボールかをカウントする変数

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		String test = "あいうえおかきくけこさしすせそ";

		// 抽選用数字を格納するリストを用意する
		bingoNumber = new ArrayList<Integer>();

		// 抽選された数字を格納するリストを用意する
		bingoNumber2 = new Vector<Integer>();

		// リストに抽選用数字を格納する
		for (int i = 1; i < 76; i++) {
			bingoNumber.add(i);
		}

		// リストをシャッフルする
		Collections.shuffle(bingoNumber);

		// 終了が選ばれるまで繰り返し処理
		do {

			System.out.println("【数字を入力してください】0:抽選  1:当選履歴  2:終了");

			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			String str = br.readLine();

			// 抽選履歴を表示する場合
			if (str.equals("1") || str.equals("１")) {

				// 抽選結果を表示する
				dispHistoryNumber();

				// 終了する場合
			} else if (str.equals("2") || str.equals("２")) {

				// 終了フラグを立てる
				endFlag = true;

				// 数字を抽選する場合
			} else if (str.equals("0") || str.equals("０")) {

				// ボールの番号を増やす
				ball++;

				// 抽選結果を格納するリストに抽選番号を追加
				bingoNumber2.add(getNumber());

				// 最後の抽選数字(75回目の抽選)の場合
				if (ball == 75) {
					System.out.println("最後の抽選数字：" + getNumber());
					System.out.println("すべての抽選が終了しました\n抽選結果は以下になります。");
					dispHistoryNumber();
					return;
				}

				// 抽選結果を出力
				System.out.println(ball + "回目当選番号：" + getNumber());

				// 抽選した数字はリストから削除する
				bingoNumber.remove(0);

				// 0～2以外の文字列が入力された場合
			} else {
				System.out.println("0～2の数値を入力してください");
			}

			// 終了判定
		} while (!endFlag);

		System.out.println("終了します");

		String test2 = "あいう";

		System.out.println(test == test2);
		System.out.println(test.equals(test2));


	}

	// ビンゴの当選番号を取得するメソッド
	public static int getNumber() {
		return bingoNumber.get(0);
	}

	// ビンゴの数字の履歴を取得する
	public static void dispHistoryNumber() {
		System.out.println(bingoNumber2);
	}
}
