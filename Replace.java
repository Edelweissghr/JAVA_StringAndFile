package stringAndFile;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Replace extends JFrame {
	public Replace()
	{
		a();
	}
	
	public void a()
	{
		JFrame replace = new JFrame("查找与替换");//新建一个窗口命名为"查找与替换"
		
		Container c = replace.getContentPane();//新建一个容器
		
		c.setLayout(new GridLayout(4, 1));//给窗格设置网格布局管理器GridLayout，四行一列
		
		JPanel [] p = new JPanel[4];//新建四个面板容器
		
		for(int i = 0; i < 4; i++)
		{
			p[i] = new JPanel();//分别声明数组里的元素
			c.add(p[i]);//把四个面板容器加入到c里面
		}
		
		JLabel [] label = new JLabel[3];//新建三个标签
		label[0] = new JLabel("文件：");
		label[1] = new JLabel("查找：");
		label[2] = new JLabel("替换：");
		
		JTextField [] textField = new JTextField[3];//新建三个文本编辑框
		textField[0] = new JTextField(50);//长度50
		textField[1] = new JTextField(50);
		textField[2] = new JTextField(50);
		
		for(int i = 0; i < 3; i++)
		{
			p[i].add(label[i]);//每个面板容器内放入一个标签一个文本编辑框
			p[i].add(textField[i]);
		}
		
		JButton theButton = new JButton("替换");//新建按钮"替换"
		
		p[3].add(theButton);//把按钮加入到第四个面板容器	
		
		replace.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗口可关闭
		replace.setSize(720, 180);//设置窗口大小
		replace.setVisible(true);//设置窗口可视
		
		theButton.addActionListener(new ActionListener(){//给按钮添加动作事件监听器
			public void actionPerformed(ActionEvent e)
			{
				String filePath = null, str = null, strReplace = null;//定义三个字符串
				
				filePath = textField[0].getText();//从文本编辑框中获取内容
				str = textField[1].getText();
				strReplace = textField[2].getText();
				
				File file = new File(filePath);//读取文件
				FileReader in = null;
				try {
					in = new FileReader(file);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				BufferedReader bufIn = new BufferedReader(in);
				CharArrayWriter tempStream = new CharArrayWriter();//内存流，作为临时流
				String line = null;//替换
				try {
					while((line = bufIn.readLine()) != null)
					{
						line = line.replaceAll(str, strReplace);//替换每行中符合条件的字符串
						tempStream.write(line);//将该行写入内存
						tempStream.append(System.getProperty("line.separator"));//添加换行符
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					bufIn.close();//关闭输入流
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				FileWriter out = null;
				try {
					out = new FileWriter(file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					tempStream.writeTo(out);//将内存中的流写入文件
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					out.close();//关闭
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(replace, "替换完成！");//弹窗告知"替换完成！"
			};
		});
	}
	public static void main(String args[])
	{
		Replace aaa = new Replace();
		// TODO Auto-generated method stub
	}
}

