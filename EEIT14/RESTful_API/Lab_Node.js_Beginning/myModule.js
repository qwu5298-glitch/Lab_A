function hi(who) {
    return "Hello! " + who;
}
 
// module.exports = { firstName: "Jeremy", lastName: "Lin",
//     hello: function () { console.log("Hello") }};
// module.exports = "ABC";
module.exports.hello = hi;
module.exports.firstName = "Jeremy";