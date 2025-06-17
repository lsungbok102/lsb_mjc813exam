package com.mjc813.studyjava;

public class Mouse {
    private int pointX;
    private int pointY;

    public void clickLeftButton() {
        System.out.println("마우스(" + pointX + ", " + pointY + ") 왼쪽버튼 클릭됨");
    }

    public void clickRightButton() {
        System.out.println("마우스(" + pointX + ", " + pointY + ") 오른쪽버튼 클릭됨");
    }

    public void moveMouse(int x, int y) {
        this.pointX = x;
        this.pointY = y;
    }
}