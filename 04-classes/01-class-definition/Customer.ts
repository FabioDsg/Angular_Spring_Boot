class Customer {
   
    firstName: string;
    lastName: string;

    constructor(theFirst: string, theLast: string){
    this.firstName = theFirst;
    this.lastName = theLast;
}
   
}

// Let's creat a instance
let myCustomer = new Customer("Paul", "Lezley");

console.log(myCustomer.firstName);
console.log(myCustomer.lastName);