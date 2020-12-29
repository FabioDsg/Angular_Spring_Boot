import { Component, OnInit } from '@angular/core';
import { mainModule } from 'process';
import { SalesPerson } from './sales-person';

@Component({
  selector: 'app-sales-person-list',
  templateUrl: './sales-person-list.component.html',
  styleUrls: ['./sales-person-list.component.css']
})
export class SalesPersonListComponent implements OnInit {

  // Create an array of objects
  salesPersonList: SalesPerson [] = [
    new SalesPerson("Jonh", "Doe", "doe@mail.com", 50000),
    new SalesPerson("Maria", "Ize", "maria@mail.com", 45000),
    new SalesPerson("Paul", "McCartney", "mccartney@outlook.com", 95000),
    new SalesPerson("Joe", "Satriani", "satriani@gmail.com", 65000),
  ];
  
  constructor() { }

  ngOnInit(): void {
  }

}
