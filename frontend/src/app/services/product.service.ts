import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Item } from '../common/Item';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  quantity: number;
  private baseUrl = 'http://localhost:8090/item';

  constructor(private httpClient: HttpClient) { }

  public sendGetRequest(){
    return this.httpClient.get(this.baseUrl + '/items');
  }

  public getBill(){
  return this.httpClient.get(this.baseUrl + '/serve/' + 5);
  }
}



interface GetResponse {
  _embedded: {
    products12: Item[];
  }
}