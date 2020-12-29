import { Coach } from "./Coach";
import { CricketCoach } from "./CricketCoach";
import { GolfCoach } from "./GolfCoach";

let myCricketCoach = new CricketCoach();
let myGolfCoach = new GolfCoach();

// Declare a array for coaches... Initially empty
let theCoaches: Coach [] = [];

// Add the coaches to the array
theCoaches.push(myCricketCoach);
theCoaches.push(myGolfCoach);

for (let tempCoaches of theCoaches) {

    console.log(tempCoaches.getDailyWorkOut());

}