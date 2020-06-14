package cn.kgc.day_05283.diushoujuan;

//2、创建一个环形链表类
public  class CycLink {
    Child firstChild=null;   //定义第一个小孩
    int len=0;                    //初始化链表长度
    Child temp=null;         //定义一个跑龙套的变量：作用就相当于指针，用来指向链表中的对象
    int k=0;                       //从编号为k的小孩开始数数，数数的时候要从这个小孩开始数
    int m=0;                      //每次数数的个数为m个
    //5、开始游戏
    public void play() {
        Child temp=this.firstChild; //初始化temp指向第一个小孩
        //找到开始游戏的小孩，这里还要遍历，遍历完后temp就是指向开始游戏的小孩
        for(int i=1;i<k;i++) {
            temp=temp.nextChild;
        }
//下面为在while循环中一次次的排除要出圈的小孩
        while(this.len!=1) {
            for(int j=1;j<m;j++){                    //数m下,找到要出圈的小孩，此时temp指向要出圈的小孩
                temp=temp.nextChild;
            }
//找到要出圈的前一个小孩，让这个小孩的的指针直接指向出圈小孩的下一个小孩，实现移除出圈小孩的功能
            Child temp2=temp;                   //引用第二个跑龙套为了指向出圈小孩的上一个小孩
            while(temp2.nextChild!=temp){  //这里使用了遍历所有链表一次的方法来找到上一个小孩，此方法存在效率低下的缺陷，读者可以自行优化
                temp2=temp2.nextChild;
            }
            //将temp2直接指向出圈小孩的下个小孩
            temp2.nextChild=temp.nextChild;
            temp=temp.nextChild;             //指向下一轮  开始数数的小孩
            len--;
        }
//打印出最后留下的小孩
        System.out.println(temp.no);
    }
    //设置从编号为k的小孩开始数数
    public void setk(int k) {
        this.k=k;
    }
    //设置数数的个数m
    public void setm(int m) {
        this.m=m;
    }
    //设置链表长度
    public void setlen(int len) {
        this.len=len;
    }
    // 3、初始化环形链表
    public void createLink() {
        for(int i=1;i<=len;i++){   //遍历链表中的所有对象
            if(i==1)  {                      //初始化第一个对象
                Child ch=new Child(i);
                this.firstChild=ch;
                this.temp=ch;      //可以看做（指针）引用temp指向第一个对象
            }else{
                if(i==len){            //初始化最后一个对象
                    Child ch=new Child(i);
                    temp.nextChild=ch;
                    temp=ch;
                    temp.nextChild=this.firstChild;   //环形链表的特点，最后对象的引用（指针）指向链表的第一个对象
                }else{
                    Child ch=new Child(i);
                    temp.nextChild=ch;
                    temp=ch;
                }
            }
        }
    }
    //4、打印环形链表
    public void show(){
//打印环形链表的时候也要遍历链表，所以也要定义一个跑龙套的引用（指针）temp
        Child temp=this.firstChild;
        do{
            System.out.print(temp.no+" ");
            temp=temp.nextChild;
        }while(temp!=this.firstChild);  // 这里要使用do while语句，因为while里的条件和初始化定义的temp条件相反，
        //所以要先执行do里的内容让temp向后移动才能让条件不冲突
    }
}
