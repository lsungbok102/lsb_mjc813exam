package com.mjc813.studyjava;

import java.util.Arrays;
import java.util.Comparator;

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

public class Computer implements Comparable<Computer>, java.util.Comparator<Computer> {
    private String name;
    private CPU cpu;
    private RAM ram;
    private StorageType storageType;
    private StorageSize storageSize;
    private GraphicCard graphicCard;
    private static Mouse mouse;
    private Integer price;
    private Integer qty;

    public Computer() {
        this.name = "Computer";
        this.cpu = null;
        this.ram = null;
        this.storageType = null;
        this.storageSize = null;
        this.graphicCard = null;
        this.price = 0;
        this.qty = 0;
        this.mouse = new Mouse();
    }

    public Computer(String name, CPU cpu, RAM ram, StorageType storageType, StorageSize storageSize, GraphicCard graphicCard, Integer price, Integer qty) {
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.storageType = storageType;
        this.storageSize = storageSize;
        this.graphicCard = graphicCard;
        this.price = price;
        this.qty = qty;
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
        System.out.println("가격 : " + price);
        System.out.println("수량 : " + qty);
        System.out.println();
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getQty() {
        return qty;
    }

    public CPU getCpu() {
        return cpu;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Computer other = (Computer) obj;
        return this.cpu == other.cpu &&
                this.ram == other.ram &&
                this.storageType == other.storageType &&
                this.storageSize == other.storageSize;
    }

    @Override
    public int hashCode() {
        int result = cpu != null ? cpu.hashCode() : 0;
        result = 31 * result + (ram != null ? ram.hashCode() : 0);
        result = 31 * result + (storageType != null ? storageType.hashCode() : 0);
        result = 31 * result + (storageSize != null ? storageSize.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Computer other) {
        if (this.cpu == null || other.cpu == null) return 0;
        return this.cpu.ordinal() - other.cpu.ordinal();
    }

    @Override
    public int compare(Computer c1, Computer c2) {
        if (c1.ram == null || c2.ram == null) return 0;
        return c1.ram.ordinal() - c2.ram.ordinal();
    }

    public static void main(String[] args) {
        Computer[] computers = new Computer[] {
                new Computer("컴A", CPU.Gen9_i3, RAM.GB_8, StorageType.SSD, StorageSize.GB_240, GraphicCard.GTX_1660, 500_000, 10),
                new Computer("컴B", CPU.Gen9_i5, RAM.GB_16, StorageType.HDD, StorageSize.GB_512, GraphicCard.RX_7600, 800_000, 5),
                new Computer("컴C", CPU.Gen9_i3, RAM.GB_8, StorageType.SSD, StorageSize.TB_1, GraphicCard.Intel_A770, 550_000, 7),
                new Computer("컴D", CPU.Gen9_i7, RAM.GB_32, StorageType.SSD, StorageSize.TB_1, GraphicCard.RTX_4070TI, 1_200_000, 3),
                new Computer("컴E", CPU.i5_14400F, RAM.GB_16, StorageType.SSD, StorageSize.TB_2, GraphicCard.RTX_4080, 1_000_000, 4)
        };

        int totalValue = Arrays.stream(computers)
                .mapToInt(c -> c.getPrice() * c.getQty())
                .sum();
        System.out.println("총 재고 금액: " + totalValue + "원");

        CPU minCpu = Arrays.stream(computers)
                .map(Computer::getCpu)
                .min(Comparator.comparingInt(Enum::ordinal))
                .orElse(null);

        int qtyOfMinCpu = Arrays.stream(computers)
                .filter(c -> c.getCpu() == minCpu)
                .mapToInt(Computer::getQty)
                .sum();
        System.out.println("가장 낮은 CPU(" + minCpu + ")를 가진 컴퓨터의 총 재고 수량: " + qtyOfMinCpu + "개");
    }
}
