package com.mjc.studyjava;

enum CPU {
    Gen9_i3, Gen9_i5, Gen9_i7, Gen9_i9, i5_14400F
}

enum RAM {
    GB_4, GB_8, GB_16, GB_32
}

enum StorageType {
    SSD, HDD
}

enum StorageSize {
    GB_240, GB_512, TB_1, TB_2
}

enum GraphicCard {
    GTX_1660, RTX_4080, Intel_A770, RX_7600, RTX_4070TI
}

public class Computer {
    private String name;
    private CPU cpu;
    private RAM ram;
    private StorageType storageType;
    private StorageSize storageSize;
    private GraphicCard graphicCard;
    private static Mouse mouse;

    public Computer() {
        this.name = "Computer";
        this.cpu = null;
        this.ram = null;
        this.storageType = null;
        this.storageSize = null;
        this.graphicCard = null;
        this.mouse = new Mouse();
    }

    public Computer(String name) {
        this.name = name;
        this.cpu = null;
        this.ram = null;
        this.storageType = null;
        this.storageSize = null;
        this.graphicCard = null;
        this.mouse = new Mouse();
    }

    public Computer(String name, CPU cpu) {
        this.name = name;
        this.cpu = cpu;
        this.ram = null;
        this.storageType = null;
        this.storageSize = null;
        this.graphicCard = null;
        this.mouse = new Mouse();
    }

    public Computer(String name, CPU cpu, RAM ram) {
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.storageType = null;
        this.storageSize = null;
        this.graphicCard = null;
        this.mouse = new Mouse();
    }

    public Computer(String name, CPU cpu, RAM ram, StorageType storageType, StorageSize storageSize) {
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.storageType = storageType;
        this.storageSize = storageSize;
        this.graphicCard = null;
        this.mouse = new Mouse();
    }

    public Computer(String name, CPU cpu, RAM ram, StorageType storageType, StorageSize storageSize, GraphicCard graphicCard) {
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.storageType = storageType;
        this.storageSize = storageSize;
        this.graphicCard = graphicCard;
        this.mouse = new Mouse();
    }

    public static void clickMouseLeftButton(int x, int y) {
        mouse.moveMouse(x, y);
        mouse.clickLeftButton();
    }

    public static void clickMouseRightButton(int x, int y) {
        mouse.moveMouse(x, y);
        mouse.clickRightButton();
    }

    public void boot() {
        System.out.println(name + " 켜졌습니다.");
    }

    public void shutdown() {
        System.out.println(name + " 꺼졌습니다.");
    }

    public void printSpec() {
        System.out.println("[" + name + " 스펙]");
        System.out.println("이름 : " + name);
        System.out.println("CPU : " + (cpu != null ? cpu : "조립중입니다"));
        System.out.println("RAM : " + (ram != null ? ram.toString().replace("GB_", "") + "GB" : "조립중입니다"));
        if (storageType != null && storageSize != null) {
            System.out.println("Storage : " + storageType + " " + storageSize);
        } else {
            System.out.println("Storage : 조립중입니다");
        }
        System.out.println("Graphic : " + (graphicCard != null ? graphicCard : "조립중입니다"));
        System.out.println();
    }

    public static void main(String[] args) {
        Computer[] computers = new Computer[6];
        computers[0] = new Computer(); // 기본 생성자
        computers[1] = new Computer("컴퓨터A");
        computers[2] = new Computer("컴퓨터B", CPU.Gen9_i3);
        computers[3] = new Computer("컴퓨터C", CPU.Gen9_i5, RAM.GB_16);
        computers[4] = new Computer("컴퓨터D", CPU.Gen9_i7, RAM.GB_32, StorageType.SSD, StorageSize.TB_1);
        computers[5] = new Computer("컴퓨터E", CPU.Gen9_i9, RAM.GB_32, StorageType.SSD, StorageSize.TB_2, GraphicCard.RTX_4080);
        Computer.clickMouseLeftButton(200, 400);
        Computer.clickMouseRightButton(600, 800);

        for (Computer comp : computers) {
            comp.boot();
        }

        System.out.println();

        for (Computer comp : computers) {
            comp.printSpec();
        }

        for (Computer comp : computers) {
            comp.shutdown();
        }
    }
}
