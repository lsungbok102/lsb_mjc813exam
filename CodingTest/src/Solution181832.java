public class Solution181832 {
    // https://school.programmers.co.kr/learn/courses/30/lessons/181832
    public static void main(String[] args) {
        Solution181832 sol = new Solution181832();
        int result[][] = sol.solution(5);
        System.out.println("Solution181832 : " + result);
    }
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        this.printArray(answer);

        int number = 0; // 숫자를 하나씩 더해서 출력한다.
        int row = 0, col = 0;   // 현재행, 현재열
        int startRow = 0, endRow = n - 1;   // 시작행, 마지막행
        int startCol = 0, endCol = n - 1;   // 시작열, 끝열
        while(number <= n * n
                && startRow <= endRow
                && startCol <= endCol ) {
                // 숫자값이 n*n 보다 작거나 같고
                // 시작행 <= 끝행, 시작열 <= 큰열 이 참일때만 루프
            number = this.goRight(answer, row, startCol, endCol, number);
            col = endCol;
            startRow++;
            number = this.goDown(answer, col, startRow, endRow, number);
            row = endCol--;
            number = this.goLeft(answer, row, endCol, startCol, number);
            endRow--;
            col = startCol;
            number = this.goUp(answer, col, endRow, startRow, number);
            row = startRow;
            startCol++;
        }
        this.printArray(answer);
        return answer;
    }

    public void printArray(int[][] array) {
        for( int i = 0; i < array.length; i++ ) {
            for( int j = 0; j < array[i].length; j++ ) {
                System.out.printf("%4d", array[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    public int goRight(int[][] array, int row, int start, int end, int number) {
        for( int i = start; i <= end; i++ ) {
            if ( array[row][i] == 0 ) {
                array[row][i] = ++number;
            } else {
                continue;
            }
        }
        return number;
    }
    public int goLeft(int[][] array, int row, int start, int end, int number) {
        for( int i = start; i >= end; i-- ) {
            if ( array[row][i] == 0 ) {
                array[row][i] = ++number;
            } else {
                continue;
            }
        }
        return number;
    }
    public int goDown(int[][] array, int col, int start, int end, int number) {
        for( int i = start; i <= end; i++ ) {
            if ( array[i][col] == 0 ) {
                array[i][col] = ++number;
            } else {
                continue;
            }
        }
        return number;
    }
    public int goUp(int[][] array, int col, int start, int end, int number) {
        for( int i = start; i >= end; i-- ) {
            if ( array[i][col] == 0 ) {
                array[i][col] = ++number;
            } else {
                continue;
            }
        }
        return number;
    }
}
