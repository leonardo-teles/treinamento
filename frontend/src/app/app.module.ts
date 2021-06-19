import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import {InputTextModule} from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import {TableModule} from 'primeng/table';
import {TooltipModule} from 'primeng/tooltip';

import { ClientePesquisarComponent } from './cliente-pesquisar/cliente-pesquisar.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ContaPesquisarComponent } from './conta-pesquisar/conta-pesquisar.component';

@NgModule({
  declarations: [
    AppComponent,
    ClientePesquisarComponent,
    NavbarComponent,
    ContaPesquisarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    InputTextModule,
    ButtonModule,
    TableModule,
    TooltipModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
