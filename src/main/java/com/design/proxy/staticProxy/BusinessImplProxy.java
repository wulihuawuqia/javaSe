
package com.design.proxy.staticProxy;

public class BusinessImplProxy implements Business {

    private BusinessImpl businessImpl;
    @Override
    public void doAction() {
        // TODO Auto-generated method stub
        if (businessImpl == null) {
            businessImpl = new BusinessImpl();
        }
        befor();
        businessImpl.doAction();
        after();
    }

    public void befor() {
        System.out.println("执行前置动作！！！");
    }
    
    public void after() {
        System.out.println("执行后置动作！！！");
    }
    
    public static void main(String[] args) {
        //引用变量定义为抽象角色类型
        Business bi = new BusinessImplProxy();
        bi.doAction();
    }
}
