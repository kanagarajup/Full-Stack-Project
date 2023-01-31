import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from './customer';

@Injectable({ providedIn: 'root' })

export class CustomerService{
    
    private baseURL="http://localhost:8081/bank/customers";

    constructor(private httpclient:HttpClient) { }

    createCustomerList(customer:Customer):Observable<Object>{
        return this.httpclient.post<Customer>(`${this.baseURL}`,customer);
    }

    getCustomerList():Observable<Customer[]>{
        return this.httpclient.get<Customer[]>(`${this.baseURL}`);
    }

    getCustomerById(id: number): Observable<Customer>{
        return this.httpclient.get<Customer>(`${this.baseURL}/${id}`);
      }
    
      updateCustomer(id: number, customer: Customer): Observable<Object>{
        return this.httpclient.put(`${this.baseURL}/${id}`, customer);
      }
    
      deleteCustomer(id: number): Observable<Object>{
        return this.httpclient.delete(`${this.baseURL}/${id}`);
      }

}