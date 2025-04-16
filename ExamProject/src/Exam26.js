class Exam26 {
    pdfExam26() {
        let input = prompt("행성 한글 이름을 입력하세요.");
        let EN = '';

        if(input == "수성") EN = "Mercury";
        else if(input == "금성") EN = "Venus";
        else if(input == "지구") EN = "Earth";
        else if(input == "화성") EN = "Mars";
        else if(input == "목성") EN = "Jupiter";
        else if(input == "토성") EN = "Saturn";
        else if(input == "천왕성") EN = "Uranus";
        else if(input == "해왕성") EN = "Neptune";
        else {
            console.log("다시 입력하여주세요.");
        }
        console.log(EN);
    }
}

let exam26 = new Exam26();