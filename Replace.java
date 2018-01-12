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
		JFrame replace = new JFrame("�������滻");//�½�һ����������Ϊ"�������滻"
		
		Container c = replace.getContentPane();//�½�һ������
		
		c.setLayout(new GridLayout(4, 1));//�������������񲼾ֹ�����GridLayout������һ��
		
		JPanel [] p = new JPanel[4];//�½��ĸ��������
		
		for(int i = 0; i < 4; i++)
		{
			p[i] = new JPanel();//�ֱ������������Ԫ��
			c.add(p[i]);//���ĸ�����������뵽c����
		}
		
		JLabel [] label = new JLabel[3];//�½�������ǩ
		label[0] = new JLabel("�ļ���");
		label[1] = new JLabel("���ң�");
		label[2] = new JLabel("�滻��");
		
		JTextField [] textField = new JTextField[3];//�½������ı��༭��
		textField[0] = new JTextField(50);//����50
		textField[1] = new JTextField(50);
		textField[2] = new JTextField(50);
		
		for(int i = 0; i < 3; i++)
		{
			p[i].add(label[i]);//ÿ����������ڷ���һ����ǩһ���ı��༭��
			p[i].add(textField[i]);
		}
		
		JButton theButton = new JButton("�滻");//�½���ť"�滻"
		
		p[3].add(theButton);//�Ѱ�ť���뵽���ĸ��������	
		
		replace.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ô��ڿɹر�
		replace.setSize(720, 180);//���ô��ڴ�С
		replace.setVisible(true);//���ô��ڿ���
		
		theButton.addActionListener(new ActionListener(){//����ť��Ӷ����¼�������
			public void actionPerformed(ActionEvent e)
			{
				String filePath = null, str = null, strReplace = null;//���������ַ���
				
				filePath = textField[0].getText();//���ı��༭���л�ȡ����
				str = textField[1].getText();
				strReplace = textField[2].getText();
				
				File file = new File(filePath);//��ȡ�ļ�
				FileReader in = null;
				try {
					in = new FileReader(file);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				BufferedReader bufIn = new BufferedReader(in);
				CharArrayWriter tempStream = new CharArrayWriter();//�ڴ�������Ϊ��ʱ��
				String line = null;//�滻
				try {
					while((line = bufIn.readLine()) != null)
					{
						line = line.replaceAll(str, strReplace);//�滻ÿ���з����������ַ���
						tempStream.write(line);//������д���ڴ�
						tempStream.append(System.getProperty("line.separator"));//��ӻ��з�
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					bufIn.close();//�ر�������
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
					tempStream.writeTo(out);//���ڴ��е���д���ļ�
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					out.close();//�ر�
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(replace, "�滻��ɣ�");//������֪"�滻��ɣ�"
			};
		});
	}
	public static void main(String args[])
	{
		Replace aaa = new Replace();
		// TODO Auto-generated method stub
	}
}

