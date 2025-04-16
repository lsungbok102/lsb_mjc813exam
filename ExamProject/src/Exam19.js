class Exam19 {
    pdfExam19(){
        let input= prompt("숫자 두 개를 입력하세요");
        let number = input.split(" ");
        let a = parseInt(number[0]);
        let b = parseInt(number[1]);
        let c = a;
        for(let i = 0; i < b-1; i++){
            a *= c;
        }
        if(b == 0) a = 1;
        console.log(a);
    }
}

let exam19 = new Exam19();