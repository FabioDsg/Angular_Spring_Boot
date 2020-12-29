var sportOne = ["Golf", "Cricket", "Tennis", "Swimming"];
// The traditional way  for loop
// for(let i=0; i < sportOne.length; i++) {
//     console.log(sportOne[i]);
// }
// Let's use the simplified for loop
for (var _i = 0, sportOne_1 = sportOne; _i < sportOne_1.length; _i++) {
    var tempSport = sportOne_1[_i];
    if (tempSport == "Swimming") {
        console.log(tempSport + " << My favorite!");
    }
    else {
        console.log(tempSport);
    }
}
