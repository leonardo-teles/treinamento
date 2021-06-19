import { Component } from '@angular/core';

@Component({
  selector: 'app-conta-pesquisar',
  templateUrl: './conta-pesquisar.component.html',
  styleUrls: ['./conta-pesquisar.component.css']
})
export class ContaPesquisarComponent {

  contas = [
  { cliente: 'Sarah Maya Isabelly Lima', agencia: '3842', numero: '95452-7', saldo: '300.0', tipo: 'CORRENTE' },
  { cliente: 'Severino Oliver Tiago da Mota', agencia: '8391', numero: '60695-4', saldo: '800.0', tipo: 'POUPANCA' },
  { cliente: 'Marli Eloá de Paula', agencia: '1780', numero: '1094423-6', saldo: '890.0', tipo: 'CORRENTE' },
  { cliente: 'Sarah Regina Kamilly Barbosa', agencia: '6610', numero: '0503045-5', saldo: '4000.0', tipo: 'CORRENTE' },
  { cliente: 'Aline Giovana Silvana Souza', agencia: '4531', numero: '07206246-8', saldo: '100.0', tipo: 'POUPANCA' },
  { cliente: 'Vanessa Eloá Louise Nogueira', agencia: '0995', numero: '27903400-0', saldo: '0.0', tipo: 'CORRENTE' },
  { cliente: 'Francisco Pedro Henrique Augusto Rezende', agencia: '4126', numero: '151065-7', saldo: '1300.0', tipo: 'POUPANCA' }
  ];
}
