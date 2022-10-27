// boolean ->  true false

const amIFat = false; //or true or null -> 변수에 아무것도 없다(false랑은 다름)
let something; // 정의해주지 않음
console.log(amIFat);
console.log(something); //undefined 라고 출력

const mon ="mon";
const tue ="tue";
const wed ="wed";
const thu ="thu";
const fri ="fri";
const sat ="sat";
const sun ="sun";

// const daysOfWeek = mon + tue + wed + thu + fri + sat + sun;  
const daysOfWeek = [mon, tue, wed, thu, fri, sat]; //array
console.log(daysOfWeek); 
console.log(daysOfWeek[0]); // 인덱스 0부터 시작 맨 첫번째 값
daysOfWeek.push("sun")
console.log(daysOfWeek); 

const nonsense = [1, 2, "hello", false, null, true ,undefined, "jh"]
console.log(nonsense); 