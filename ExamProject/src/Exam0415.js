class Exam0415 {
    pdfExam17() {
        let height = prompt("키를 입력하세요");

        if (height >= 150) {
            console.log("YES");
        } else {
            console.log("NO");
        }
    }

    pdfExam18(){
        let input= prompt("점수를 입력하세요");
        let score = input.split(" ");
        let score_avg = 0;
        for(let i = 0; i < score.length; i++){
            score_avg += parseInt(score[i]);
        }
        score_avg = score_avg / score.length;
        console.log("평균 점수: ", score_avg);
    }
}

let exam = new Exam0415();