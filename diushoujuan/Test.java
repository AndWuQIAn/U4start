package cn.kgc.day_05283.diushoujuan;
    /*丢手帕问题
     * 作者：zyj0813
     */
    public class   Test {
            public static void main(String[] args) {
// TODO Auto-generated method stub
                CycLink cyclink=new CycLink();
                cyclink.setlen(5);      //设置链表长度，默认设置5，读者可以自行修改
                cyclink.createLink(); //建立环形链表
                cyclink.show();          //展示链表
//开始游戏
                cyclink.setk(4);         //默认2，可以自行修改
                cyclink.setm(2);        // 默认2，可以自行修改
                cyclink.play();
            }
        }
