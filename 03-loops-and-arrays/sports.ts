let sportOne: string [] = ["Golf", "Cricket", "Tennis", "Swimming"];

// The traditional way  for loop
// for(let i=0; i < sportOne.length; i++) {
//     console.log(sportOne[i]);
// }

// Let's use the simplified for loop
for (let tempSport of sportOne) {

    if (tempSport == "Swimming") {
        console.log(tempSport + " << My favorite!")
    } else {
        console.log(tempSport);
    }
}