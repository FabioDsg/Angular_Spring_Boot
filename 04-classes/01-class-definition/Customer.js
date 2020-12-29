var Customer = /** @class */ (function () {
    function Customer(theFirst, theLast) {
        this.firstName = theFirst;
        this.lastName = theLast;
    }
    return Customer;
}());
// Let's creat a instance
var myCustomer = new Customer("Paul", "Lezley");
console.log(myCustomer.firstName);
console.log(myCustomer.lastName);
