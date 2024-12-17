class Person
{
	public int myAge;			//年齢	
	private double myWeight;	//体重[kg]	

	// privateな変数にサブクラスからアクセスするとエラーになる
	// protectedにすると、継承したサブクラスからはアクセス可能になる
	private double myHeight;	//身長[cm]	



	private double myBMI;		// BMI ( 体重[kg] / 身長[m]^2 )

	// プライベートなメソッドはクラス外から呼べない
	private void calcBMI()
	{
		// メソッド内の変数はメンバ関数ではないのでクラス外からアクセスできない
		double calc_height = myHeight/100;
		double calc_weight = myWeight;

		myBMI= calc_weight / calc_height / calc_height;

	}

	// パブリックなメソッドはクラス外からも呼べる
	public double retBMI()
	{
		calcBMI();		// 同クラス内なので呼べる
		return myBMI;
	}

	void show()
	{
		System.out.println("年齢は"+myAge+"歳");
		System.out.println("体重は"+myWeight+"[kg]");
		System.out.println("身長は"+myHeight+"[cm]");
	}

	// 年齢設定を行うメソッド
	int setAge(int age)
	{
		if(age <0)
		{
			System.out.println("年齢が負です");
			return -1;								//負値のとき-1
		}

		myAge = age;
		return 0;
	}


	// 体重設定を行うメソッド
	int setWeight(double weight)
	{
		if(weight <=0)
		{
			System.out.println("体重がおかしな値です");
			return -1;								//負値のとき-1
		}

		// 自分のメンバ変数であることを明示的に示すためthisを使うことがある。
		// 今回はただ myWeight = weight   でもOK
		this.myWeight = weight;

		return 0;
	}


	// 身長設定を行うメソッド
	int setHeight(double myHeight)
	{
		if(myHeight <0)
		{
			System.out.println("身長がおかしな値です");
			return -1;								//負値のとき-1
		}

		// メンバ変数のmyHeightとメソッド引数myHeightを区別するためにthisが必要
		this.myHeight = myHeight;

		return 0;
	}
}


// Personクラスをスーパークラス(元)として、新しいサブクラスCharacterを作成
class Character extends Person
{
	private int chTv=8;

	public int retTvChannel()
	{
		return chTv;
	}
	
		
	// 身長設定を行うメソッドをオーバーライド
	int setHeight(double myHeight)
	{
		if(myHeight <0)
		{
			System.out.println("身長がおかしな値です");
			return -1;								//負値のとき-1
		}

		this.myHeight = myHeight +10.0;	// 芸能人は実際の身長より10cmさばを読む

		return 0;
	}
}

public class override 
{
	public static void main(String[] args)
	{
//		Person gachaping;
		// ガチャピンを新しいキャラクターサブクラスで定義
		Character gachaping;
		gachaping =new Character();	

		int ret;

		// 元にしたスーパークラスのメソッド、メンバ変数は使える
		gachaping.setAge(5);
		gachaping.setHeight(165.0);
		gachaping.setWeight(80.0);

		gachaping.show();

		System.out.println("BMI計算");
		System.out.println(gachaping.retBMI());

		// 当然新しいサブクラスの変数、関数も使える
		System.out.println("キャラクターのチャンネルは"+ gachaping.retTvChannel() + "です");



	}
}
