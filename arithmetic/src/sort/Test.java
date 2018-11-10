package sort;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test {
    static JTextArea textArea;
    //储存数字
    static String number = "";
    //储存文本
    static String data = "";
    //储存运算符
    static String operation = "";
    //储存结果
    static double answer = 0;
    public static void main(String[] args) {
        JFrame calculatorFrame = new JFrame("计算器");
        calculatorFrame.setLayout(new BorderLayout());

        JPanel textPanel = new JPanel();
        setTextPanel(textPanel);
        JPanel keyPanel = new JPanel();
        setKeyPanel(keyPanel);

        calculatorFrame.add(textPanel,BorderLayout.NORTH);
        calculatorFrame.add(keyPanel, BorderLayout.CENTER);
        calculatorFrame.setLocationRelativeTo(null);
        calculatorFrame.setSize(250,400);
        calculatorFrame.setResizable(false);
        calculatorFrame.setVisible(true);
    }
    public static void setTextPanel(JPanel panel) {
        //初始化文本框
        textArea = new JTextArea("0",3,20);
        textArea.setEditable(false);
        panel.add(textArea);
    }
    public static void setKeyPanel(JPanel panel) {
        panel.setLayout(new GridLayout(5,4,5,5));
        //添加按钮
        JButton[] keyButton = new JButton[20];
        String[] key = {"AC","Del","(+)","(-)","7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};
        for(int i=0; i<20;i++) {
            keyButton[i] = new JButton(key[i]);
            panel.add(keyButton[i]);
            keyButton[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    for(int i = 0; i < keyButton.length; i++) {
                        //数字键
                        if ((i >= 4 && i <= 6) || (i >= 8 && i <= 10) || (i >= 12 && i <= 14) || i == 16||i == 17) {
                            if (arg0.getSource().equals(keyButton[i])) {
                                setNumberKey(key, i);
                            }
                        }else if(i == 0||i ==1) {//清除键
                            if(arg0.getSource().equals(keyButton[i])) {
                                setClearKey(key, i);
                            }
                        }else if(i == 18) {//等号
                            if(arg0.getSource().equals(keyButton[i])) {
                                getAnswer();
                                data = String.valueOf(answer);
                                number = data;
                                operation = "";
                                textArea.append("\n" + String.valueOf(answer));
                            }
                        }else if(i == 7||i == 11||i == 15||i == 19){//运算操作
                            if(arg0.getSource().equals(keyButton[i])) {
                                setOperationKey(key, i);
                            }
                        }else {//正负号
                            if(arg0.getSource().equals(keyButton[i])) {
                                setPlusMinusKey(key, i);
                            }
                        }
                    }
                }
            });
        }
    }
    //对数字键的操作
    public static void setNumberKey(String[] key,int i) {
        if(number.equals("")&&key[i].equals(".")) {
            textArea.setText("");
        }else if(key[i].equals(".")&&(number.substring(number.length()-1)).equals(".")) {
            textArea.setText(data);
        }else {
            //number储存为计算准备
            number = number + key[i];
            //data储存为输出准备
            data = data + key[i];
            textArea.setText(data);
        }
    }
    //对清除键的操作
    public static void setClearKey(String[] key,int i) {
        //AC键，全部清除，将设置初始化
        if(i == 0) {
            textArea.setText("0");
            data = "";
            number = "";
            answer = 0;
            operation = "";
        }
        //Del键
        if(i == 1) {
            //截取data，去除最后一位
            if(data.length() > 1) {
                data = data.substring(0,data.length()-1);
                if(number.length()>0) {
                    number = number.substring(0,number.length()-1);
                }
                textArea.setText(data);
            }else {//全部清除后，设置初始化
                textArea.setText("0");
                data = "";
                number = "";
                answer = 0;
                operation = "";
            }
        }
    }
    //正负号操作
    public static void setPlusMinusKey(String[] key,int i) {
        //如果是负号，在number前面添加-。正号不予处理
        if(key[i].equals("(-)")) {
            number = String.valueOf(-1*Double.valueOf(number));
        }
        //将符号添加到data中
        data = key[i] + data;
        textArea.setText(number);
    }
    //对运算键的操作
    public static void setOperationKey(String[] key,int i) {
        //如果当前未输入数字或者刚刚输入运算符，进行容错
        if(number.equals("")) {
            operation = key[i];
        }else {
            //输入运算符号前先将之前的数据计算
            getAnswer();
            //保存运算符号
            operation = key[i];
            //将数据null，用来保存接下来需要输入的数据
            number = "";
            //将运算符号输出到文本窗口
            textArea.append(key[i]);
            //将运算符号添加到 当前文本
            data = data + key[i];
        }
    }
    //对等号的操作
    public static void getAnswer() {
        if(operation.equals("+")) {
            answer = answer + Double.valueOf(number);
        }else if(operation.equals("-")) {
            answer = answer - Double.valueOf(number);
        }else if(operation.equals("*")) {
            answer = answer * Double.valueOf(number);
        }else if(operation.equals("/")) {
            answer = answer / Double.valueOf(number);
        }else {
            answer = Double.valueOf(number);
        }
    }


}
