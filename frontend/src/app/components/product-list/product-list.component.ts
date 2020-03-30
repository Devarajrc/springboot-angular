import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';
import { Item } from 'src/app/common/Item';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-product-list',
  //templateUrl: './product-list-table.component.html',
   templateUrl: './product-list-table.component.html',
  // templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products12: Item[];
  toalbill: number;
  quantity: number;
 

  
  constructor(private productService: ProductService, private httpClient: HttpClient) { }

  ngOnInit() {

    this.productService.sendGetRequest().subscribe((data: any[])=>{
      console.log(data);
      this.products12 = data;
    })
  }

  public getquantity(){
  //  let num=Number(this.quantity);
    return this.httpClient.get('http://localhost:8090/item' + '/serve/' + 9);
    }


  getbill(){
  this.productService.getBill().subscribe((data: any)=>{
    console.log(data);
    this.toalbill = data;
  })
}


  // listProducts() {
  //   this.productService.sendGetRequest().subscribe(
  //     data => {
  //       this.products12 = data;
  //     }
  //   )
  // }

}
