import javax.swing.*;
import java.awt.*;

public class Register extends JFrame {
    JPanel p1,p2;


    Register(String s){
        super(s);
        setSize(420,300);
        setLocationRelativeTo(null);

        setUndecorated(true);//设置边框不可见
        setResizable(false);//设置窗体不可动

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        BorderLayout borderLayout=new BorderLayout();
        setLayout(borderLayout);

        //北部画板
        JPanel panNorth=CreatePanel.CreateNorthPan();
        add(panNorth,BorderLayout.NORTH);

       //中部画板
        JPanel panCenter=CreatePanel.CreateCenterPan();
        add(panCenter,BorderLayout.CENTER);

        //西部画板
        JPanel panWest=CreatePanel.CreateWestPan();
        add(panWest,BorderLayout.WEST);

        //东部画板
        JPanel panEast=CreatePanel.CreateEastPan();
        add(panEast,BorderLayout.EAST);

        //南部画板
        JPanel panSouth=CreatePanel.CreateSouthPan();
        add(panSouth,BorderLayout.SOUTH);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


    }
}

