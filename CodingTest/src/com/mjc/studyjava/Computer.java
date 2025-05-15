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

    public Computer(String name, CPU cpu, RAM ram,
                    StorageType storageType, StorageSize storageSize,
                    GraphicCard graphicCard) {
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.storageType = storageType;
        this.storageSize = storageSize;
        this.graphicCard = graphicCard;
    }

    public void boot() {
        System.out.println(name + " 켜졌습니다.");
    }

    public void shutdown() {
        System.out.println(name + " 꺼졌습니다.");
    }

    public void printSpec() {
        System.out.println("[" + name + " 스펙]");
        System.out.println("CPU : " + cpu);
        System.out.println("RAM : " + ram.toString().replace("GB_", "") + "GB");
        System.out.println("Storage : " + storageType + " " + storageSize.toString().replace("GB_", "") + "GB");
        System.out.println("Graphic : " + graphicCard);
        System.out.println();
    }

    public static void main(String[] args) {
        Computer[] computers = new Computer[5];

        computers[0] = new Computer("sungbokPC", CPU.i5_14400F, RAM.GB_32, StorageType.SSD, StorageSize.TB_1, GraphicCard.RX_7600);
        computers[1] = new Computer("com1", CPU.Gen9_i3, RAM.GB_4, StorageType.HDD, StorageSize.GB_240, GraphicCard.GTX_1660);
        computers[2] = new Computer("com2", CPU.Gen9_i5, RAM.GB_8, StorageType.SSD, StorageSize.GB_512, GraphicCard.Intel_A770);
        computers[3] = new Computer("com3", CPU.Gen9_i7, RAM.GB_16, StorageType.SSD, StorageSize.TB_1, GraphicCard.RTX_4070TI);
        computers[4] = new Computer("com4", CPU.Gen9_i9, RAM.GB_32, StorageType.SSD, StorageSize.TB_2, GraphicCard.RTX_4080);

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
