package org.example;

public class InnerClasses {
    //成员内部类
    public class MemberInnerClass{}

    public InnerInterFace method(){
        double d = 5.3e12;
        //局部内部类
        class LocalInnerClass{}
        //匿名内部类
        return new InnerInterFace() {
            @Override
            public void run() {}
        };
    }

    //静态内部类
    public static class StatisInnerClass{}

    public interface InnerInterFace{
        void run();
    }
}
