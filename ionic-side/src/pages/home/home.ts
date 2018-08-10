import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { Http, Headers, RequestOptions } from '@angular/http';
import 'rxjs/add/operator/map';
import * as $ from 'jquery';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/timeout';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  todos: any;
  tempTodos: any;
  color: any;
  tempColor: any;
  subs: any;
  tdlNo = 3;
  tdlName;

  constructor(public navCtrl: NavController, public http: Http) {
    this.getToDoLists();
  }

  stopIteration() {
    this.subs.unsubscribe();
  }

  getToDoLists() {

    this.http.get('http://localhost:8080/todolists')
      .map(res => res.json()).subscribe(data => {
        this.tempTodos = data;
        console.log(data);
        console.log(this.tempTodos);
      });

    this.subs = Observable.interval(1000).subscribe(x => {
      if (this.tempTodos != undefined) {
        this.todos = this.tempTodos;
        console.log(this.todos);
        this.stopIteration();
      }
      if (this.tempTodos == undefined) {
        console.log("bulamadı");
      }
    })

  }

  addToDoLists() {

    var headers = new Headers();
    headers.append("Accept", 'application/json');
    headers.append('Content-Type', 'application/json');
    let options = new RequestOptions({ headers: headers });

    let postParams = {
      tdlNo: this.tdlNo + 1,
      tdlName: this.tdlName,
      tdlStatus: "On Going"
    }

    this.http.post("http://localhost:8080/todolist", postParams, options)
      .subscribe(data => {
        console.log(data['_body']);
      }, error => {
        console.log(error);// Error getting the data
      });

    this.getToDoLists();

    this.tdlNo++;
  }

  editToDoLists() {

    var headers = new Headers();
    headers.append("Accept", 'application/json');
    headers.append('Content-Type', 'application/json');
    let options = new RequestOptions({ headers: headers });

    let postParams = {
      tdlNo: this.tdlNo + 1,
      tdlName: this.tdlName,
      tdlStatus: "On Going"
    }

    this.http.put("http://localhost:8080/todolist", postParams, options)
      .subscribe(data => {
        console.log(data['_body']);
      }, error => {
        console.log(error);// Error getting the data
      });

    this.getToDoLists();
  }

}

