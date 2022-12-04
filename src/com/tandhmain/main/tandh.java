package com.tandhmain.main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * @Author iVan@admin
 * @Version
 * @Date 周五, 2022/8/19 16:42 GMT+0800
 *
 * 使用swing进行桌面程序开发
 */

public class tandh {
    //设置比赛获胜标识符，确认是否已经有获胜者，初始化为false
    public static boolean isWin = false;

    public static void main(String[] args) {
        //创建一个窗口
        JFrame frame = new JFrame("龟兔赛跑");
        //设置窗口大小
        frame.setSize(500, 400);

        //去掉默认窗口布局
        frame.setLayout(null);

        //创建乌龟图片
        JLabel tortoiseIcon = new JLabel(new ImageIcon(
                "./picsrc/tortoise.jpg"));
        //设置乌龟图片坐标位置
        tortoiseIcon.setBounds(0, 100, 50, 50);
        //将乌龟图片添加到窗口中
        frame.add(tortoiseIcon);

        //创建兔子图片
        JLabel hareIcon = new JLabel(new ImageIcon(
                "./picsrc/hare.jpg"));
        //设置兔子图片坐标位置
        hareIcon.setBounds(0, 200, 50, 50);
        //将兔子图片添加到窗口中
        frame.add(hareIcon);

        //添加按钮
        JButton startButton = new JButton("开始");
        startButton.setBounds(200, 0, 100, 50);
        frame.add(startButton);

        //创建乌龟跑的线程
        Thread t1 = new Thread(){
            @Override
            public void run() {
                //设置随机数，备用
                Random random = new Random();
                //设置死循环，模拟乌龟移动
                while (true){
                    //获取乌龟的横坐标
                    double x = tortoiseIcon.getBounds().getX();
                    //通过设置乌龟新的横坐标来让其移动，每次随机0~5像素
                    tortoiseIcon.setBounds((int)x + random.nextInt(6), 100, 50, 50);
                    //判断，如果乌龟的横坐标大于等于终点，即窗口边界，结束循环
                    if (tortoiseIcon.getBounds().getX() >= 450){
                        //判断是否有获胜者，若无，则乌龟获胜并将isWin改为true
                        if (isWin == false){
                            isWin = true;
                            //弹出对话框提示信息--乌龟获胜
                            JOptionPane.showMessageDialog(null, "乌龟获胜！",
                                    "比赛结束", JOptionPane.WARNING_MESSAGE);
                        }
                        break;
                    }
                    //通过线程的sleep方法来模拟乌龟休息时间，0~500ms
                    try {
                        Thread.sleep(random.nextInt(6) * 100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        //设置兔子跑的线程
        Thread t2 = new Thread(){
            @Override
            public void run() {
                //设置随机数，备用
                Random random = new Random();
                //设置死循环，模拟兔子移动
                while (true){
                    //获取乌龟的横坐标
                    double x = hareIcon.getBounds().getX();
                    //通过设置兔子新的横坐标来让其移动，每次随机0~10像素
                    hareIcon.setBounds((int)x + random.nextInt(11), 200, 50, 50);
                    //判断，如果兔子的横坐标大于等于终点，即窗口边界，结束循环
                    if (hareIcon.getBounds().getX() >= 450){
                        //判断是否有获胜者，若无，则兔子获胜并将isWin改为true
                        if (isWin == false){
                            isWin = true;
                            //弹出对话框提示信息--兔子获胜
                            JOptionPane.showMessageDialog(null, "兔子获胜！",
                                    "比赛结束", JOptionPane.WARNING_MESSAGE);
                        }
                        break;
                    }
                    //通过线程的sleep方法来模拟兔子休息时间，0~1000ms
                    try {
                        Thread.sleep(random.nextInt(11) * 100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        //给按钮绑定事件：动作监听器
        startButton.addActionListener(new ActionListener() {
            //此方法，是点击按钮后，swing进行回调
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
//                //获取乌龟的横坐标，然后设置新坐标
//                double x1 = tortoiseIcon.getBounds().getX();
//                tortoiseIcon.setBounds((int)x1 + 10, 100, 50, 50);
//                //获取兔子的横坐标，然后设置新坐标
//                double x2 = hareIcon.getBounds().getX();
//                hareIcon.setBounds((int)x2 + 10, 200, 50, 50);
                t1.start();
                t2.start();

            }
        });


        //退出和关闭，在最后
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口显示  visible
        frame.setVisible(true);


    }
}
