var fs = require("fs");  // object  function  class
console.log("Starting...");
var datalist = [
    { "todoTableId": 1, "title": "Job A", "isComplete": 0 },
    { "todoTableId": 2, "title": "Job B", "isComplete": 1 },
    { "todoTableId": 3, "title": "Job C", "isComplete": 0 }
]

var s = JSON.stringify(datalist);
console.log(s)

fs.writeFile("./lab.json",
    s,
    function (error) {
        if (error) {
            console.log(error);
        }
        else {
            console.log("已建立檔案.");
        }
    }
);
console.log("Finish Flag.");


// var fs = require("fs");
// console.log("Starting...");
// fs.writeFileSync("./world.html",
//   "<html><body><h1>Hello! World.</h1></body></html>");
// console.log("已建立檔案.");