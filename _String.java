package stringAndFile;

import java.util.*;
import java.util.Map.Entry;
import java.io.*;


public class _String {

	public static void countString(String str)
	{
		int [] a = new int [94];
		for(int i = 0; i < 94; i++)
			a[i] = 0;
		for(int i = 0; i < str.length(); i++)
		{
			char t = str.charAt(i);
			for(int i1 = 0; i1 < 94; i1++)
			{
				if(t == (char)(i1 + 33))
					a[i1]++;
			}
		}
		for(int i = 0; i < 94; i++)
			if(a[i] != 0)
				System.out.println(((char)(i + 33)) + ":" + a[i]);
	}
	
	public static void dateFormatConversion(String str)
	{
		String year = null, month = null, day = null;
		String monthEnglish = "";
		Boolean op = false;
		for(int i = 0; i < str.length(); i++)
		{
			if(str.charAt(i) == '.')
				op = true;
		}
		if(op)
		{
			year = str.substring(0, 4);
			month = str.substring(5, 7);
			day = str.substring(8, 10);
			switch(month)
			{
			case "01":
				monthEnglish = "January";
				break;
			case "02":
				monthEnglish = "February";
				break;
			case "03":
				monthEnglish = "March";
				break;
			case "04":
				monthEnglish = "April";
				break;
			case "05":
				monthEnglish = "May";
				break;
			case "06":
				monthEnglish = "June";
				break;
			case "07":
				monthEnglish = "July";
				break;
			case "08":
				monthEnglish = "August";
				break;
			case "09":
				monthEnglish = "September";
				break;
			case "10":
				monthEnglish = "October";
				break;
			case "11":
				monthEnglish = "November";
				break;
			case "12":
				monthEnglish = "December";
				break;
			default:
				System.out.println("输入错误！");
			}
			System.out.println(monthEnglish + ' ' + day + ',' + year);
		}
		else if(!op)
		{
			int space = 0;
			for(int i = 0; i < 9; i++)
				if(str.charAt(i) == (char)32)
				{
					space = i;
					break;
				}
			for(int i = 0; i < space; i++)
				monthEnglish += str.charAt(i);
			switch(monthEnglish)
			{
			case "January":
				month = "01";
				break;
			case "February":
				month = "02";
				break;
			case "March":
				month = "03";
				break;
			case "April":
				month = "04";
				break;
			case "May":
				month = "05";
				break;
			case "June":
				month = "06";
				break;
			case "July":
				month = "07";
				break;
			case "August":
				month = "08";
				break;
			case "September":
				month = "09";
				break;
			case "October":
				month = "10";
				break;
			case "November":
				month = "11";
				break;
			case "December":
				month = "12";
				break;
			default:
				System.out.println("输入错误！");
			}
			day = str.substring(space + 1, space + 3);
			year = str.substring(space + 4, space + 8);
			System.out.println(year + '.' + month + '.' + day);
		}
		else
			System.out.println("输入错误！");
	}
	
	public static void verifyIPAddress(String str)
	{
		String first = "", second = "", third = "", fourth = "";
		int _first = 0, _second = 0, _third = 0, _fourth = 0;
		first = str.split("\\.")[0];
		second = str.split("\\.")[1];
		third = str.split("\\.")[2];
		fourth = str.split("\\.")[3];
		_first = Integer.parseInt(first);
		_second = Integer.parseInt(second);
		_third = Integer.parseInt(third);
		_fourth = Integer.parseInt(fourth);
		if(_first >= 0 && _first <= 255 && _second >= 0 && _second <= 255 && _third >= 0 && _third <= 255 && _fourth >= 0 && _fourth <= 255)
		{
			if(_first <= 127)
				System.out.println("A类");
			else if (_first <= 191)
				System.out.println("B类");
			else if (_first <= 223)
				System.out.println("C类");
			else
				System.out.println("其他地址");
		}
		else
			System.out.println("无效的IP地址！");
	}
	
	public static void fileReadWrite(String str, String filePath)
	{
		try {
			FileOutputStream fos = new FileOutputStream(filePath);
			fos.write(str.getBytes());
			fos.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("已写入D盘根目录下file.txt中，内容为：");
		System.out.println(str);
		String [] wordArray = str.split("\\s+");
		int wordCount = wordArray.length;
		System.out.println("Altogether " + wordCount + " word(s).");
		String _str = str.toLowerCase();
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		String[] strList = _str.split("\\s+|,|\\.");
		for(int i = 0; i < strList.length; i++)
		{
			if(!hash.containsKey(strList[i]))
				hash.put(strList[i], new Integer(1));
			else
				hash.put(strList[i], hash.get(strList[i]) + 1);
		}
		for(Entry<String, Integer> entry : hash.entrySet())
			System.out.println(entry.getKey() + " : " + entry.getValue());
	}

	public static void replace(String str, String strReplace, String filePath) throws IOException
	{
		File file = new File(filePath);
		FileReader in = new FileReader(file);
		BufferedReader bufIn = new BufferedReader(in);
		CharArrayWriter tempStream = new CharArrayWriter();
		String line = null;
		while((line = bufIn.readLine()) != null)
		{
			line = line.replaceAll(str, strReplace);
			tempStream.write(line);
			tempStream.append(System.getProperty("line.separator"));
		}
		bufIn.close();
		FileWriter out = new FileWriter(file);
		tempStream.writeTo(out);
		out.close();
		System.out.println("替换完成！");
	}
	
	public static void main(String[] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		String str = null, strReplace = null, filePath = null;
		
		System.out.println("请输入一段字符串，本次操作将会统计出各字符出现次数：");
		str = in.nextLine();
		countString(str);
		System.out.println();
		
		System.out.println("请输入一段时间，格式如\"1981.07.30\"或\"July 30,1981\":");
		str = in.nextLine();
		dateFormatConversion(str);
		System.out.println();
		
		System.out.println("请输入一个IP地址，格式如\"10.3.8.211\":");
		str = in.nextLine();
		verifyIPAddress(str);
		System.out.println();
		
		System.out.println("请输入一段英文词句：");
		str = in.nextLine();
		filePath = "D:/file.txt";
		fileReadWrite(str, filePath);
		System.out.println();
		
		System.out.println("请输入所需替换文件的文件路径及文件名(如\"D:/replace.txt\")：");
		filePath = in.nextLine();
		System.out.println("请输入待查找的文本：");
		str = in.nextLine();
		System.out.println("请输入替换的文本：");
		strReplace = in.nextLine();
		replace(str, strReplace, filePath);
	}
}
