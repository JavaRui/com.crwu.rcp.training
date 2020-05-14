package com.crwu.common;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
public class RandomUtil {
	
	public static final char[] SMALL_CHAR = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','_'};
	public static final char[] BIG_CHAR = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','_'};
	public static final Object[] NUM_CHAR = new Object[]{'0','1','2','3','4','5','6','7','8','9'};
	
	private static final String[] IE_CODE_TYPE = new String[]{"IE","Mozilla","chromlum","opera","webkit"};
	private static final String[]  BROWER_TYPE = new String[]{"Microsoft Internet Explorer","Chrom","firefox","safari","firefox"};
	private static final String[] SYS_TYPE = new String[]{"window98","windowxp","window7","window2003","windowvista","window8","window9"};
	private static final String[]  BIT_TYPE = new String[]{"x86","64","32"};
	private static final String[] RESOLUTION_WIDTH_TYPE = new String[]{"1920","1680","1600","1440","1360","1280"};
	private static final String[] RESOLUTION_HEIGHT_TYPE = new String[]{"1200","1080","1050","900","768"};
//	private static final char[] ALL_CHAR = 
	//两百个常见姓�?
	private static final String firstNames = "王李张刘陈杨黄周赵吴孙徐林胡朱郭梁马高何郑罗宋谢叶韩任潘唐于冯董吕邓许曹曾袁程田彭钟蔡魏沈卢余杜蒋汪丁方苏贾姜姚"
			+ "陆戴傅夏廖萧石范金谭邹崔薛邱史江侯邵肖熊康秦雷孟白毛阎郝钱段俞洪顾贺龚庞尹万龙赖孔武邢颜汤章梅常阮黎倪施乔樊严齐陶温易兰文闫芦牛安向管殷霍翟佘葛伍辛练申付曲焦代鲁季"
			+ "覃毕麦�?�舒尚聂庄项盛童祝柴柳单岳阳骆纪欧左尤凌韦景詹莫路宁关丛翁容柯鲍蒲苗牟谷裴初屈成包游司祁靳甘席瞿欧阳卜褚解时费班华全房涂";
	//�?有姓�?
//	private static final String firstNames = "赵钱孙李周吴郑王冯陈楮卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛�?"
//			+ "贺�?�汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闽席季麻强贾路娄危江童颜郭"
//			+ "梅盛林刁锺徐丘骆高夏蔡田樊胡凌霍虞万支柯昝管卢莫经房裘缪干解应宗丁宣贲邓郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁�?羊於惠甄麹家封芮羿储靳汲邴糜松井段富"
//			+ "巫乌焦巴弓牧隗山谷车侯宓蓬全郗班仰秋仲伊宫宁仇栾暴甘斜厉戎祖武符刘景詹束龙叶幸司韶郜黎蓟薄印宿白�?蒲邰从鄂索咸籍赖卓蔺屠蒙池乔阴郁胥能苍双闻莘党翟谭贡"
//			+ "劳�?�姬申扶堵冉宰郦雍郤璩桑桂濮牛寿通边扈燕�?郏浦尚农温别庄晏柴瞿阎充慕连茹习宦艾鱼容向古易慎戈廖庾终暨居衡步都�?�满弘匡国文寇广禄阙东欧殳沃利蔚越夔隆师"
//			+ "巩厍聂晁勾敖融冷訾辛阚那�?饶空曾毋沙乜养鞠须丰巢关蒯相查后荆红游竺权�?�盖益桓公万俟司马上官欧阳夏侯诸葛闻人东方赫连皇甫尉迟公羊澹台公冶宗政濮阳淳于单�?"
//			+ "太叔申屠公孙仲孙轩辕令狐锺离宇文长孙慕容鲜于闾丘司徒司空丌官司寇仉督子车颛孙端木巫马公西漆雕乐正驷公良拓拔夹谷宰父谷梁晋楚阎法汝鄢涂钦段干百里东郭南�?"
//			+ "呼延归海羊舌微生岳帅缑亢况后有琴梁丘左丘东门西门商牟佘佴伯赏南宫墨哈谯笪年爱阳佟";
	
	private static final String lName = "峰格寒杰朗丽邈爽兴轩阳谊逸懿原韵卓赫霁亮临启熙�??誉源冠玉晗昱日涵忍煦蓄衍意映育采池林墨音藻漠昊苍空乾穹焱浩初宕荡广慨旷阔漫淼渺气�?"
			+ "�?皓蔼洽惬硕颂泰悌通同豫正鹤方量深盛图伟新致壮宏伯放富浚恺儒胜宝彩畴晖羲禧信煊雪云祯振奥灿藏美清荣嘉赐木慕纳年庆瑞石树澍祥歆许勋颖珍坚壁秉诚建柏茗修中健金鑫锦程瑾瑜晋经赋�?"
			+ "纶纬武景澄焕山铄靖琪君艾拔材楚发郎力迈楠能人悟晤侠贤彦友智季萌开凯唱定复乐旋时�?�家生圣童心欣咏游湛黎昕夫强勤行立果群策工吉骏朋理典敏旭知珠彭勃薄湃魄越祖鲸举鲲濮存溥璞浦奇"
			+ "玮希祺睿锐锋进精利阵慈聪范识绍钧升斯河罡骄禄路纵甫巍奕晔兆温书韦昌栋虹向晨笛项禹晓可怿觉鸥朝�?腾旺为辰汉火剑津阑渊洲谨筠齐永真竹尧炫松炎冰秋舒朔曦夏州烨磊霖烁熠煜仙春�?"
			+ "彤韶卫资长贞勇军寰宸泉堂甲驹魁青忠凌之丹梅凝梦如蕾孤晴尔醉柔问雁莲觅烟薇半念兰蓉幼亦依绿冬绮盼香桃琴翠槐芙菱荷霜萱沛菡静凡儿小碧巧惜卉幻诗珊丝蓝曼妙枫灵芷蝶柳笑宛傲�?"
			+ "萍瑶夜若紫最女二忆芹谷迎痴千岚以访冷蕊露从寻三�?�四五六七八苑藉展卿尚专用子默濯曾悬解决题都提�?�韩莹助佳答婉寓茵浪婷欢愉菲草很浓雯花纹倩就爱公主茹谐想�?"
			+ "纯善娅活璐月结合慧且张芸古薛少绝世貌赛禅絮唐杜红素轻肃婕琳入优乖妮�?�王淑姗�?娜样神钰色斑斓多于婧情画种忘忧舞照亭璇各面秀像受漂传说玲珑嫣鲜艳�?"
			+ "象令喜直标着茜留百婵嫦娥蓬期妃烈地势祝她将来品质伊姿桑榆滕阁序北虽赊扶摇东隅已�?�身形娴物檀植规沐琦犹上无暇昭满愿莉度皇帝曹�?"
			+ "宫梨淡黛滢媛端庄刘会剔�?�单桐珏";
	//笔画�?单的�?
	private static final String aName = "红绿蓝白黄赤金云丰王井开夫天无元云扎艺木五支厅太历友匹车巨牙瓦少中贝内水见午牛手毛升长仁片化斤爪从今�?"
			+ "公仓月氏风丹�?乌凤文六方火斗忆计户心尺巴孔队双书玉刊示末巧正功去甘世古节本术可丙左右石布龙�?"
			+ "东卡北业旧帅归旦目叶甲叮电号田史央四生禾丘仙仪白仔瓜乎丛用印乐句外处冬鸟包主立兰�?"
			+ "汁汇头汉宁让礼记永司尼民辽加皮圣台纠丝式动寺吉�?�扫地扬亚芝朽朴�?"
			+ "协西百页匠达列成迈贞师尘光莲花人明光早虫曲团同岁刚年朱先竹迁乔伟传伍"
			+ "延任华向后行舟全会合众朵名多壮冰庄庆亦刘齐交衣产问羊关米灯州"
			+ "江池汤兴宇宅字安军许农孙阳如好戏羽观欢红纪驰白杨槐树白果松梧桐法国桐垂柳桂花江河山一二三四五六七八九�?";
	
	private static RandomUtil inst;
	private Random random;
	
	private RandomUtil(){
		random = new Random(new Date().getTime());
	}
	
	public static RandomUtil getInst(){
		if(inst == null){
			inst = new RandomUtil();
		}
		return inst;
	}
	
	/**
	 * 获取50%的概�?
	 * @return
	 */
	public boolean getFlag(){
		
		return getFlag(1,2);
	}
	
	/**
	 * 获取�?个概率的成功�?
	 * @param chance 概率
	 * @param max 总概�?
	 * @return
	 */
	public boolean getFlag(int chance , int max){
		int i = random.nextInt(max);
		if(i < chance){
			return true;
		}
		return false;
	}
	
	
	/**
	 * 随机组合中英�?
	 * */
	public  String getRandomECN(int start ,int end){
		String en = getEnRandom(start, end);
		String ch = getChRandom(start, end);
		String num = getNumRandom(start, end);
		int i = random.nextInt(3);
		if(i == 0){
			return en+ch+num;
		}else if(i == 1){
			return ch+num+en;
		}else {
			return num+en+ch;
		}
		
	}
	/**
	 * 生成英文和数字，长度在start到end之间
	 * */
	public String getRandomEN(int start,int end){
		int len = getRange(start, end);
		
		return getFixedEN(len);
	}
	/**
	 * 生成固定长度的英文和数字
	 * */
	public String getFixedEN(int len){
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i<len;i++){
			if(getInt(2)%2 == 0){
				sb.append(getEn());
			}else{
				sb.append(getNum());
			}
		}
		return sb.toString();
	}
	
	/**
	 * 生成>start，且<end的数�?
	 * 
	 * */
	public int getRange(int start , int end){
		int index = random.nextInt(end - start)+start;
		return index;
	}
	/**
	 * 生成随机数字
	 * */
	public int getInt(int len){
		if(len == 0){
			return 0;
		}
		return random.nextInt(len);
	}
	/***********************************       下面是英�?         *********************************/
	/**
	 * 生成�?个英�?
	 * */
	public  String getEn(){
		String f = SMALL_CHAR[random.nextInt(Integer.MAX_VALUE)%SMALL_CHAR.length]+"";
		return f;
	}
	/**
	 * 生成固定长度的英�?
	 * */
	public String getEnFixed(int len){
		String str = "";
		for (int i = len; i > 0; i--) {
			str = str + getEn();
		}
		return str;
	}
	
	/**
	 * 生成长度在start和end之间的英�?
	 * */
	public  String getEnRandom(int start , int end){
		int len = getRange(start,end);
		return getEnFixed(len);
	}
	
	/*******************************        下面是数�?            ******************************/	
	/**
	 * 生成�?个在10之内的数�?
	 * */
	public  String getNum(){
		int r = Math.abs(random.nextInt(10));
		return r+"";
	}
	
	public  String getNumFixed(int len){
		String str = "";
		for (int i = len; i > 0; i--) {
			str = str + getNum();
		}
		return str;
	}
	
	public  String getNumRandom(int start , int end){
		int len = getRange(start,end);
		return getNumFixed(len);
	}
	
	/*******************************        下面是中�?            ******************************/	
	/**
	 * 获取规定长度的中�?
	 * */
	public  String getChFixed(int len){
		String str = "";
		for (int i = len; i > 0; i--) {
			str = str + getChinese();
		}
		return str;
	}
	/**
	 * 获取范围内的中文
	 * */
	public  String getChRandom(int start , int end){
		int index = getRange(start,end);
		return getChFixed(index);
	}
	/**
	 * 获取单个中文
	 * */
	public  String getChinese() {
		String str = lName.charAt(getInt(lName.length()))+"";
		//2E80-2FDF, 3400-4DBF, 4E00-9FFF
		return str;
	}
	/***********************************以下是特定数组中的随�?*********************************/
	/**
	 * 数组中一个随机对�?
	 * */
	public Object  getSpecial(Object[] sps){
		int r = Math.abs(random.nextInt(sps.length));
		return sps[r]+"";
	}
	/**
	 * 在数组sps范围内生成，len长度的对�?
	 * */
	public Object[] getSpecialFixed(Object[] sps , int len){
		Object[] objs = new Object[len];
		for (int i = len; i > 0; i--) {
			objs[i] = getSpecial(sps);
		}
		return objs;
	}
	/**
	 * 在数组sps范围内生成，长度在start和end之间的对�?
	 * */
	public  Object[] getNumRandom(Object[] sps , int start , int end){
		int len = getRange(start,end);
		return getSpecialFixed(sps,len);
	}
	
	
	public Object getSpecial(List sps){
		int r = Math.abs(random.nextInt(sps.size()));
		return sps.get(r);
	}
	
	/**
	 * 在数组sps范围内生成，len长度的对�?
	 * */
	public List getSpecialFixed(List sps , int len){
		List objs = new ArrayList(len);
		for (int i = len; i > 0; i--) {
			objs.add(getSpecial(sps));
		}
		return objs;
	}
	
	/**
	 * 在数组sps范围内生成，长度在start和end之间的对�?
	 * */
	public  List getNumRandom(List sps , int start , int end){
		int len = getRange(start,end);
		return getSpecialFixed(sps,len);
	}
	
	/**
	 * 获取长度�?23的身份证号码
	 * */
	public String getPersonNo(){
		return RandomUtil.getInst().getSpecialFixed((Object[])(RandomUtil.NUM_CHAR),23)+"";
	}
	/**
	 * 获取�?个手机号�?
	 * */
	public String getPhone(){
//		Integer[] heads = new Integer[]{175,176,177};
		Integer[] heads = new Integer[]{134,135,136,137,138,139,150,151,152,157,158,159,182,
				183,184,187,188,130,131,132,155,156,185,186,133,153,180,181,189};
		String head = getSpecial(heads)+"";
		return head + getNumFixed(8);
	}
	
	public String getPersonName(){
		String name = "";
		String first = firstNames.charAt(getInt(firstNames.length()))+"";
		name += first;
		for( int i = 0 ; i < getInt(2)+1 ; i ++ ){
			name += getChinese();
		}
		return name;
	}
	
	
	
	public String getIECode(){
		String code = IE_CODE_TYPE[random.nextInt(IE_CODE_TYPE.length)];
		return code;
	}
	
	public String getBrowser(){
		String browser = BROWER_TYPE[random.nextInt(BROWER_TYPE.length)];
		return browser;
	}
	
	public String getSysType(){
		String sys = SYS_TYPE[random.nextInt(SYS_TYPE.length)];
		return sys;
	}
	
	public String getBitType(){
		String bit = BIT_TYPE[random.nextInt(BIT_TYPE.length)];
		return bit;
	}
	
	public String getResolutionWidth(){
		String width = RESOLUTION_WIDTH_TYPE[random.nextInt(RESOLUTION_WIDTH_TYPE.length)];
		return width;
	}
	public String getResolutionHeight(){
		String width = RESOLUTION_HEIGHT_TYPE[random.nextInt(RESOLUTION_HEIGHT_TYPE.length)];
		return width;
	}
	
	public  String getResolution(String sp){
		return getResolutionWidth()+sp+ getResolutionHeight();
	}
//	public String getLastAddress(){
//		String[] stresss = new String[]{"街道" , "�?" , "�?", "�?", "�?", "�?" ,"片区", "管区" ,"�?","大厦","�?" , "小区" , "花园"};
//		String[] direction = new String[]{"�?","�?","�?","�?","前面","后面","旁边","左边","右边"};
//		String[] num = new String[]{"�?","�?","A","B","C","D","E","F"};
//		String[] last = new String[]{"�?","�?","�?"};
//		String[] last2 = new String[]{"�?","�?"};
//		
//		StringBuilder sb = new StringBuilder();
//		for( int j = 0 ; j < xxx.r.getInt(2)+2 ; j ++ ){
//			String string = aName.charAt(getInt(aName.length()))+"";
//			sb.append(string);
//			
//		}
//		String stress = xxx.r.getSpecial(stresss)+"";
//		sb.append(stress);
//		if(xxx.r.getFlag()){
//			sb.append(xxx.r.getSpecial(direction));
//		}
////		sb.append(xxx.r.getNumRandom(1, 4)+1);
//		
//		if(xxx.r.getFlag()){
//			sb.append(xxx.r.getSpecial(new Integer[]{1,2,3,4})+"");
//			sb.append(xxx.r.getSpecial(num));
//			sb.append(xxx.r.getSpecial(new Integer[]{1,2,3})+"");//�?
//			sb.append(xxx.r.getSpecial(new Integer[]{0,1})+"");//�?
//			sb.append(Integer.valueOf(getNum())%4+"");
//			sb.append(xxx.r.getSpecial(last));
//		}else{
//			sb.append(Integer.valueOf(xxx.r.getNumFixed(2))%20+"");//�?
//			sb.append(xxx.r.getSpecial(last2)+"");//�?
//			
//		}
//		
////		System.out.println(sb);
//		return sb.toString();
//	}
	
	
}

