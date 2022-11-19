import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.IOException;

public class CreatePanel {
    static JButton button;//登录按钮
    static JTextField jt1;//账号框
    static JPasswordField jt2;//密码框
    static JPanel panel1=new JPanel();//南部的画板

    //创建北部画板
    public static JPanel CreateNorthPan(){
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(420,150));

        ImageIcon i1=new ImageIcon("C:\\Users\\zz\\Desktop\\Q.png");
        i1.setImage(i1.getImage().getScaledInstance(420, 150, Image.SCALE_DEFAULT));
        Image image = i1.getImage();
        JLabel background=new JLabel(i1);
        background.setBounds(0,0,420,150);
        panel.add(background);
        return panel;
    }

    //创建西部画板
    public static JPanel CreateWestPan(){
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(95,100));
        panel.setBackground(Color.WHITE);

//        ImageIcon i1=new ImageIcon("C:\\Users\\zz\\Desktop\\qq.webp");
//        JLabel background=new JLabel(i1);
//        background.setBounds(0,0,120,120);
//        panel.add(background);
        return panel;
    }

    //创建中部画板
    public static JPanel CreateCenterPan(){
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(230,100));


        jt1=new JTextField(20);
        jt2=new JPasswordField(20);
        jt1.setBounds(0,10,215,20);
        jt2.setBounds(0,30,215,20);

        JCheckBox cb1,cb2;
        cb1=new JCheckBox("自动登录");
        cb2=new JCheckBox("记住密码");
        cb1.setBackground(Color.WHITE);
        cb2.setBackground(Color.WHITE);

        //给自动登录复选框创建监听器
        cb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cb1.isSelected()){

                    CreatePanel.Login();//调用登录的单击事件
                }
            }
        });

        //记住密码复选框添加监听事件
        cb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cb2.isSelected()){
                    if(jt1.getText().equals("2789835809")){
                        String str="111";
                        jt2.setText(str);
                    }
                }
            }
        });

        //找回密码按钮
        JButton button=new JButton("找回密码");
        button.setContentAreaFilled(false);
       // button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder());

        //给找回密码单击添加网页链接
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Runtime.getRuntime().exec("cmd /c start https://accounts.qq.com/find/password");
                }catch (IOException ee){
                    ee.printStackTrace();
                }

            }
        });

        cb1.setBounds(0,50,80,20);
        cb2.setBounds(80,50,80,20);
        button.setBounds(160,50,70,20);

        panel.add(jt1);
        panel.add(jt2);
        panel.add(cb1);
        panel.add(cb2);
        panel.add(button);

        return panel;
    }

    //创建东部画板
    public static JPanel CreateEastPan(){
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(95,100));
        panel.setBackground(Color.WHITE);

        return panel;
    }

    //创建南部画板
    public static JPanel CreateSouthPan(){
        panel1.setLayout(null);
        panel1.setBackground(Color.WHITE);
        panel1.setPreferredSize(new Dimension(420,50));

//        ImageIcon i=new ImageIcon("C:\\Users\\zz\\Desktop\\zz.png");
//        i.setImage(i.getImage().getScaledInstance(60, 20, Image.SCALE_DEFAULT));
//        Image image = i.getImage();

        JButton but=new JButton("注册账号");
        but.setContentAreaFilled(false);
        //but.setFocusPainted(false);
        but.setBorder(BorderFactory.createEmptyBorder());

        but.setBackground(Color.WHITE);
        but.setBounds(10,25,60,20);

        //给注册账号添加网页链接
        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Runtime.getRuntime().exec("cmd /c start https://ssl.zc.qq.com/v3/index-chs.html");
                }catch (IOException ee){
                    ee.printStackTrace();
                }

            }
        });

        //调用登录的单击事件
        CreatePanel.Login();

        button.setBounds(95,0,215,30);

        //添加二维码图标
        ImageIcon i1=new ImageIcon("C:\\Users\\zz\\Desktop\\E.png");
        i1.setImage(i1.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        Image image = i1.getImage();
        JLabel label=new JLabel(i1);
        label.setBounds(360,0,40,40);


        panel1.add(label);
        panel1.add(but);
        panel1.add(button);

        return panel1;
    }

    //登录按键的监听事件
    public static void Login(){
        ImageIcon ic=new ImageIcon("C:\\Users\\zz\\Desktop\\login.png");
        button=new JButton(ic);
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button){
                    if(jt1.getText().equals("2789835809")&&jt2.getText().equals("111")){
                        JOptionPane.showMessageDialog(panel1,"欢迎进入qq","登录界面",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        System.out.println(jt2.getPassword());
                        //JOptionPane.showMessageDialog(panel,"欢迎进入qq","登录界面",JOptionPane.INFORMATION_MESSAGE);
                        JOptionPane.showMessageDialog(panel1,"账号或密码不正确请重新输入","警告",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }
}
